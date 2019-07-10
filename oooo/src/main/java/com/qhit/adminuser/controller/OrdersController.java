package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.Orders;
import com.qhit.adminuser.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Orders> list = ordersService.findAll();
        model.addAttribute("list",list);
        return "/orders/list";
    }
}
