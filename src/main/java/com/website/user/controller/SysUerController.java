package com.website.user.controller;

import com.website.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class SysUerController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public void userLogin() {
        sysUserService.userLogin();
    }
}
