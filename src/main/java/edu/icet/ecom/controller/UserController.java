package edu.icet.ecom.controller;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {
    private final UserService service;

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

    @GetMapping("/search-userByEmail/{email}")
    public List<User> searchUserByEmail(@PathVariable String email) {
        return service.searchUserByEmail(email);
    }

}
