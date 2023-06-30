package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            File newFile = new File(uploadDirectory + fileName);
            file.transferTo(Path.of(newFile.getAbsolutePath()));

            return ResponseEntity.ok("Снимката е добавена успешно");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Проблем с добавянето на снимката");
        }
    }
}
