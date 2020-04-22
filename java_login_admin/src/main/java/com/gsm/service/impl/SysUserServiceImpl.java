package com.gsm.service.impl;

import com.gsm.dao.SysRoleDao;
import com.gsm.dao.SysTokenDao;
import com.gsm.dao.SysUserRoleDao;
import com.gsm.entity.*;
import com.gsm.dao.SysUserDao;
import com.gsm.service.SysUserService;
import com.gsm.utils.IdUtils;
import com.gsm.utils.JwtUtils;
import com.gsm.utils.MD5Utils;
import com.gsm.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private IdUtils idUtils;

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
            if (sysUserOpen.equals(userOpenBase64) && sysUserMD5.equals(userClose)) {
                SysRole role = sysRoleDao.selectRoleByUserId(user.getUserId());
                String token = jwtUtils.getJwt(Long.toString(user.getUserId()), user.getUserName(), Long.toString(role.getRoleId()), role.getRoleName());
                loginUser.setToken(token);
                user.setUserPwdOpen("");
                user.setUserPwdClose("");
                loginUser.setSysUser(user);
            }
        }
        return loginUser;
    }

    @Override
    public Result selectSysUser() {
        List<SysUser> list = sysUserDao.selectAllSysUser();
        list.forEach(i -> {
            String pwdOpen = i.getUserPwdOpen();
            i.setUserPwdOpen(Base64Utils.base64Decode(pwdOpen));
            SysRole sysRole = sysRoleDao.selectRoleByUserId(i.getUserId());
            i.setSysRole(sysRole);
        });
        Result result = new Result(true, StatusCode.OK, "", list);
        return result;
    }

    @Override
    public Result insertSysUser(SysUser sysUser) {
        long userId = idUtils.nextId();
        sysUser.setUserId(userId);
        sysUser.setUserPwdOpen(Base64Utils.base64Encode(sysUser.getUserPwdOpen()));
        sysUser.setUserPwdClose(MD5Utils.getMD5(sysUser.getUserPwdClose()));
        sysUser.setStatus(1);
        sysUserDao.insertSysUser(sysUser);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateSysUser(SysUser sysUser) {
        String userPwdOpen = sysUser.getUserPwdOpen();
        String userPwdClose = sysUser.getUserPwdClose();

        sysUser.setUserPwdOpen(Base64Utils.base64Encode(userPwdOpen));
        sysUser.setUserPwdClose(MD5Utils.getMD5(userPwdClose));
        sysUserDao.updateSysUser(sysUser);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result deleteSysUserById(Long userId) {
        sysUserDao.deleteSysUserById(userId);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }

    @Override
    public Result updateSysUserRole(Long userId, Long roleId) {
        sysUserRoleDao.deleteUserRole(userId);

        SysUserRole sysUserRole = SysUserRole.builder()
                .userRoleId(idUtils.nextId())
                .userId(userId)
                .roleId(roleId)
                .build();
        sysUserRoleDao.insertUserRole(sysUserRole);
        Result result = new Result(true, StatusCode.OK);
        return result;
    }
}