package com.gsm.service.impl;

import com.gsm.dao.RegisterDao;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.entity.WebUser;
import com.gsm.service.RegisterService;
import com.gsm.utils.Base64Utils;
import com.gsm.utils.IdUtils;
import com.gsm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户表(WebUser)表服务实现类
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;
    @Autowired
    private IdUtils idUtils;

    @Override
    public Result selectIphoneNoIsRegister(Long iphoneNo) {
        //查询手机号是否已经注册
        int total = registerDao.selectIphoneNoIsRegister(iphoneNo);
        Result result = new Result(true, StatusCode.OK,"手机号个数",total);
        return result;
    }

    @Override
    public Result insertWebUser(WebUser webUser) {
        long webUserId = idUtils.nextId();
        webUser.setWebUserId(webUserId);
        webUser.setCreateDate(new Date());
        /**
         * 密码明文 前端base64加密   后端 base64加密
         * 密码密文 前端 MD5加密   后端MD5加密
         */
        String base64Encode = Base64Utils.base64Encode(webUser.getUserPwdOpen());
        webUser.setUserPwdOpen(base64Encode);

        String md5 = MD5Utils.getMD5(webUser.getUserPwdClose());
        webUser.setUserPwdClose(md5);
        registerDao.insertWebUser(webUser);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}