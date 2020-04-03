package com.gsm.service.impl;

import com.gsm.dao.LoginDao;
import com.gsm.dao.WebUserDao;
import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import com.gsm.entity.WebUser;
import com.gsm.service.WebUserService;
import com.gsm.utils.Base64Utils;
import com.gsm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户表(WebUser)表服务实现类
 */
@Service("webUserService")
public class WebUserServiceImpl implements WebUserService {
    @Autowired
    private WebUserDao webUserDao;
    @Autowired
    private LoginDao loginDao;

    @Override
    public Result updateWebUserInfoById(WebUser webUser) {
        webUser.setUpdateDate(new Date());
        webUserDao.updateWebUserInfoById(webUser);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updatePwdByIphoneNo(WebUser webUser) {
        //手机号是否已经注册，未注册直接返回
        WebUser user = loginDao.selectUserPwdByIphoneNo(webUser.getIphoneNo());
        if (user == null) {
            Result result = new Result(false, StatusCode.ERROR_LOGIN, "", "该用户还未注册");
            return result;
        }
        //密码加密
        String pwdOpen = webUser.getUserPwdOpen();
        String pwdClose = webUser.getUserPwdClose();
        webUser.setUserPwdOpen(Base64Utils.base64Encode(pwdOpen));
        webUser.setUserPwdClose(MD5Utils.getMD5(pwdClose));
        //修改
        webUser.setWebUserId(user.getWebUserId());
        webUserDao.updateWebUserInfoById(webUser);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}