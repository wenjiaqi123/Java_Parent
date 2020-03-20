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
    /**
     * SpringBoot   必须会 熟练会，像写 for 循环一样熟练
     *      配置信息能够看懂
     *
     *  基础  CRUD ，码农
     *      SSM 框架（虽然不用了，但是沿用讲法）
     *      Struts2  +  Spring   + Hibernate    SSH（明清时期）
     *      SpringMVC  +  Spring   + Mybatis    SSM (近现代)   2015-2016年左右
     *      SpringBoot      当代
     *      SpringCloud     当代
     */
}