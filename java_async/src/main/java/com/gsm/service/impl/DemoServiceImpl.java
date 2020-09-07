package com.gsm.service.impl;

import com.gsm.service.DemoService;
import com.gsm.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private FileUtil fileUtil;

    @Override
    public String transferFile(String from, String to) {
        File file = new File(from);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            try {
                fileUtil.transferFile(name, from, to);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
