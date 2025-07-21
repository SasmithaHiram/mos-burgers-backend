package edu.icet.ecom.controller;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {
    private final UserService service;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        return ResponseEntity.ok(service.isValid(user));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> create(@RequestBody User user) {
        boolean isCreated = service.create(user);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
