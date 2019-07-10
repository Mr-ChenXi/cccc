package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.Category;
import com.qhit.adminuser.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public  String list(Model model){
        List<Category> list = categoryService.findAll();
        model.addAttribute("list",list);
        return  "/category/list";
    }
}
