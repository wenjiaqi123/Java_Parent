package com.gsm.controller;

import com.gsm.entity.OssToken;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.utils.OSSTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ossToken")
public class OSSTokenController {
    @Autowired
    private OSSTokenUtils ossTokenUtils;

    @GetMapping("/sts")
    public Result getOssToken(){
        OssToken ossToken = ossTokenUtils.getOssToken();
        Result result = new Result(true, StatusCode.OK,"",ossToken);
        return result;
    }
}
