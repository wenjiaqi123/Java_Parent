package com.gsm.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.gsm.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public String insertFile(MultipartFile file) {
        String fileUrl = "";
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            fileUrl = "106.15.238.19:8888/" + storePath.getGroup() + "/" + storePath.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrl;
    }
}
