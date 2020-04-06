package com.gsm.service;

import com.gsm.entity.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    Result insertFile(MultipartFile file);
}
