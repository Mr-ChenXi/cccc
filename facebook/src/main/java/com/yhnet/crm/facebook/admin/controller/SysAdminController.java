package com.yhnet.crm.facebook.admin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.yhnet.crm.facebook.admin.entity.SysAdmin;
import com.yhnet.crm.facebook.admin.entity.SysConfig;
import com.yhnet.crm.facebook.admin.service.ISysAdminService;
import com.yhnet.crm.facebook.admin.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pacey
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/admin/sysAdmin")
public class SysAdminController {
    @Autowired
    private ISysAdminService sysAdminService;

    @PostMapping("/login")
    public R list(@RequestParam(value = "username",required = true) String username,
                  @RequestParam(value = "password",required = true) String password){
        SysAdmin sysAdmin = sysAdminService.getOne(Wrappers.<SysAdmin>lambdaQuery()
                .eq(SysAdmin::getUsername, username).eq(SysAdmin::getPassword, password));
        if(sysAdmin == null){
            return R.failed("用户名或密码错误");
        }
        return R.ok("登陆成功");
    }
}

