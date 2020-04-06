package com.gsm.controller;

import com.gsm.entity.Result;
import com.gsm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sFile")
public class SmallFileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/addFile")
    public Result insertFile(MultipartFile file) {
        Result result = fileService.insertFile(file);
        return result;
    }
}