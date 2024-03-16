package com.website.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysUserEntity {

    @TableId
    private Long id;

    private String userName;

    private String userCount;

    private String userPassword;

    private Long creatBy;

    private Date createTime;


}
