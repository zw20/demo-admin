package com.website.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.website.user.entity.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {
    void userLogin();
}
