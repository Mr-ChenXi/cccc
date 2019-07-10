package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.BaseRole;
import com.qhit.adminuser.service.baserole.BaseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/14.
 */
@Controller
@RequestMapping("/baseRole")
public class BaseRoleController {

    @Autowired
    private BaseRoleService  baseRoleService;

    @RequestMapping("/list")
    public String list(Model model){
        List<BaseRole> baseRoles = baseRoleService.getBaseRoles();
        model.addAttribute("list",baseRoles);
        return "/baseRole/list";
    }

    @RequestMapping("/distribute")
    public String distribute(Model model, @RequestParam("uid") Integer uid){

        List<BaseRole> baseUserRoles = baseRoleService.getBaseUserRoles(uid);
        List<BaseRole> notBaseUserRoles = baseRoleService.getNotBaseUserRoles(uid);
        model.addAttribute("uid",uid);
        model.addAttribute("rightList",baseUserRoles);
        model.addAttribute("leftList",notBaseUserRoles);
        return  "/admin/distribute";
    }
}
