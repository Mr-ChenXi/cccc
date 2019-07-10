package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.User;
import com.qhit.adminuser.service.user.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/UserList")
    public String userList(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("list",users);
        return "user/list";
    }

    @RequestMapping("/UserInsert")
    public void UserInsert(User user, HttpServletResponse response) throws IOException {
        String result="";
        int i = userService.insertSelective(user);
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }
    @RequestMapping("/delete")
    public void delete(User user, HttpServletResponse response) throws IOException {
        String result="";
        int i = userService.deleteByPrimaryKey(user.getUid());
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }
    @RequestMapping("/UserUpdate")
    public void UserUpdate(User user, HttpServletResponse response) throws IOException {
        String result="";
        int i = userService.updateByPrimaryKeySelective(user);
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }
    @RequestMapping("/getUser")
    public String getUserByUid(User user,Model model){
        User user1 = userService.selectByPrimaryKey(user.getUid());
        model.addAttribute("user",user1);
        return "/user/edit";
    }
}
