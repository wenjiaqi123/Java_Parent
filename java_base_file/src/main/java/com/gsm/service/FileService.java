package com.gsm.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String insertFile(MultipartFile file);
}
