package com.qhit.adminuser.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.adminuser.pojo.BaseDept;
import com.qhit.adminuser.service.basedept.BaseDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Controller
@RequestMapping("/baseDept")
public class BaseDeptController {

    @Autowired
    private BaseDeptService baseDeptService;

    @RequestMapping("/deptList")
    public void getDeptList(HttpServletResponse response) throws IOException {

        List<BaseDept> deptList = baseDeptService.getDeptList();

        System.out.println(deptList);
        response.getWriter().write(String.valueOf(JSON.toJSONString(deptList)));
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<BaseDept> deptList = baseDeptService.getDeptList();
        model.addAttribute("list",deptList);
        return  "/baseDept/list";
    }
}
