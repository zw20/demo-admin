package com.website.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.user.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
}
