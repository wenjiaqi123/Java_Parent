package com.gsm.service.impl;

import com.gsm.dao.SysTokenDao;
import com.gsm.entity.LoginUser;
import com.gsm.entity.SysToken;
import com.gsm.entity.SysUser;
import com.gsm.dao.SysUserDao;
import com.gsm.service.SysUserService;
import com.gsm.utils.MD5Utils;
import com.gsm.utils.PwdUtils;
import com.gsm.utils.TokenUtils;
import jdk.nashorn.internal.parser.Token;
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

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long userId) {
        return this.sysUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }

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
            String userOpenBase64 = PwdUtils.base64Decode(user.getUserPwdOpen());
            //后台密文，真实密码2次MD5【前后台各一次】
            String userClose = user.getUserPwdClose();
            if(sysUserOpen.equals(userOpenBase64) && sysUserMD5.equals(userClose)){
                String token = sysTokenDao.selectTokenByUserId(user.getUserId());
                loginUser.setToken(token);
                user.setUserPwdOpen("");
                user.setUserPwdClose("");
                loginUser.setSysUser(user);
            }
        }
        return loginUser;
    }
}