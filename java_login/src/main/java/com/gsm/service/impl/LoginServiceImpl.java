package com.gsm.service.impl;

import com.gsm.dao.LoginDao;
import com.gsm.entity.*;
import com.gsm.service.LoginService;
import com.gsm.utils.Base64Utils;
import com.gsm.utils.JwtUtils;
import com.gsm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public Result selectUserCanLoginReturnInfo(LoginUser loginUser) {
        LoginUserVo userVo = new LoginUserVo();
        WebUser webUser = loginDao.selectUserPwdByAccount(loginUser.getAccount());
        if (webUser == null) {
            Result result = new Result(false, StatusCode.ERROR_LOGIN, "", "该用户还未注册");
            return result;
        }
        //前台明文，前台进行一次 Base64
        String userPwdOpen = loginUser.getUserPwdOpen();
        //前台密文再次MD5加密
        String base64Decode = Base64Utils.base64Decode(webUser.getUserPwdOpen());
        //前台密文再次MD5加密
        String md5 = MD5Utils.getMD5(loginUser.getUserPwdClose());
        //后台密文，真实密码2次MD5【前后台各一次】
        String userPwdClose = webUser.getUserPwdClose();
        if (userPwdOpen.equals(base64Decode) && md5.equals(userPwdClose)) {
            String token = jwtUtils.getJwt(Long.toString(webUser.getWebUserId()), webUser.getUserName(), "", "");
            userVo.setToken(token);

            webUser.setUserPwdOpen("");
            webUser.setUserPwdClose("");
            userVo.setWebUser(webUser);
        }
        Result result = new Result(true, StatusCode.OK, "", userVo);
        return result;
    }

    @Override
    public Result selectWebUserInfo(Long webUserId) {
        WebUser webUser = loginDao.selectUserInfoByUserId(webUserId);
        Result result = new Result(true, StatusCode.OK, "", webUser);
        return result;
    }

    @Override
    public Result selectUserCanLoginByVerCodeReturnInfo(String iphoneNo) {
        WebUser webUser = loginDao.selectUserPwdByIphoneNo(iphoneNo);
        if (webUser == null) {
            Result result = new Result(false, StatusCode.ERROR_LOGIN, "", "该用户还未注册");
            return result;
        }
        LoginUserVo userVo = new LoginUserVo();
        String token = jwtUtils.getJwt(Long.toString(webUser.getWebUserId()), webUser.getUserName(), "", "");
        userVo.setToken(token);

        webUser.setUserPwdOpen("");
        webUser.setUserPwdClose("");
        userVo.setWebUser(webUser);
        Result result = new Result(true, StatusCode.OK, "", userVo);
        return result;
    }
}
