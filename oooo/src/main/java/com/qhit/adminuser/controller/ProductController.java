package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.Product;
import com.qhit.adminuser.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/15.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public String list(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("list",list);
        return "/product/list";
    }
}
