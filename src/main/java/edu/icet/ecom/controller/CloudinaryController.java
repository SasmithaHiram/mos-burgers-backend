package edu.icet.ecom.controller;

import edu.icet.ecom.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@CrossOrigin
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadImage = cloudinaryService.uploadImage(file);
            return ResponseEntity.ok(uploadImage);
        } catch (IOException exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("IMAGE UPLOAD FAILED: " + exception.getMessage());
        }
    }

}
