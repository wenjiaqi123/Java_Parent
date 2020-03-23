package com.gsm.service.impl;

import com.gsm.dao.SysRoleDao;
import com.gsm.dao.SysTokenDao;
import com.gsm.entity.LoginUser;
import com.gsm.entity.SysRole;
import com.gsm.entity.SysUser;
import com.gsm.dao.SysUserDao;
import com.gsm.service.SysUserService;
import com.gsm.utils.JwtUtils;
import com.gsm.utils.MD5Utils;
import com.gsm.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台管理人员账户(SysUser)表服务实现类
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysTokenDao sysTokenDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public LoginUser selectSysUserByAccountAndPwd(SysUser sysUser) {
        LoginUser loginUser = new LoginUser();
        //根据账号信息查询数据库
        SysUser user = sysUserDao.selectSysUserByAccountAndPwd(sysUser);
        if (user != null) {
            //前台明文，前台进行一次 Base64
            String sysUserOpen = sysUser.getUserPwdOpen();
            //前台密文再次MD5加密
            String sysUserMD5 = MD5Utils.getMD5(sysUser.getUserPwdClose());
            //后台明文，真实密码2次Base64【前后台各一次】
            String userOpenBase64 = Base64Utils.base64Decode(user.getUserPwdOpen());
            //后台密文，真实密码2次MD5【前后台各一次】
            String userClose = user.getUserPwdClose();
            if(sysUserOpen.equals(userOpenBase64) && sysUserMD5.equals(userClose)){
                SysRole role = sysRoleDao.selectRoleByUserId(user.getUserId());
                String token = jwtUtils.getJwt(Long.toString(user.getUserId()),user.getUserName(),Long.toString(role.getRoleId()),role.getRoleName());
                loginUser.setToken(token);
                user.setUserPwdOpen("");
                user.setUserPwdClose("");
                loginUser.setSysUser(user);
            }
        }
        return loginUser;
    }
}