package com.gsm.controller;

import com.gsm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public String insertFile(MultipartFile file) {
        System.out.println(1);
        String s = fileService.insertFile(file);
        System.out.println(2);
        return s;
    }
}