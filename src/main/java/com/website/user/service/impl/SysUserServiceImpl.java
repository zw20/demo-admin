package com.website.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.user.dao.SysUserDao;
import com.website.user.entity.SysUserEntity;
import com.website.user.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService  {
    @Override
    public void userLogin() {
        System.out.println("用户登录了");
    }
}
