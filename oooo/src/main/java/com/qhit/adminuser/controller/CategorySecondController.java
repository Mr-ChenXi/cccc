package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.CategorySecond;
import com.qhit.adminuser.service.categorysecond.CategorySecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Controller
@RequestMapping("/categorysecond")
public class CategorySecondController {
    @Autowired
    private CategorySecondService categorySecondService;

    @RequestMapping("/list")
    public  String  list(Model mode){
        List<CategorySecond> list = categorySecondService.findAll();
        mode.addAttribute("list",list);
        return  "/categorysecond/list";
    }
}
