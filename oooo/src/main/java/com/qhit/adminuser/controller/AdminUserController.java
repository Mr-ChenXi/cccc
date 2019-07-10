package com.qhit.adminuser.controller;

import com.qhit.adminuser.pojo.Adminuser;
import com.qhit.adminuser.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by 爸爸 on 2019/5/12.
 */
@Controller
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/login")
    public String login(Adminuser adminuser, Model model){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        Adminuser user = adminUserService.getUserByNameAndPwd(adminuser);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return "index/home";
        }else{
            model.addAttribute("error","用户名或密码错误！");
            return "index/index";
        }

    }
    @RequestMapping("/AdminuserList")
    public String getAdminList(Model model){
        List<Adminuser> adminusers = adminUserService.getAdminList();
        if(adminusers!=null){
            model.addAttribute("list",adminusers);
//            System.out.println(adminusers.get(0).getBaseDept().getDeptName());
        }
        return "admin/list";
    }

    @RequestMapping("/getAdminUser")
    public String getAdminUser(Adminuser adminuser,Model model){
        Adminuser user = adminUserService.selectByPrimaryKey(adminuser.getUid());
        model.addAttribute("adminuser",user);
        return "/admin/edit";
    }

    @RequestMapping("/addAdminUser")
    public  void addAdminUser(Adminuser adminuser,HttpServletResponse response) throws IOException {
        int insert = adminUserService.insert(adminuser);
        String result="";
        if(insert>0){
            result ="Y";
        }else {
            result ="N";
        }
        response.getWriter().write(result);
    }

    @RequestMapping("/delAdminUser")
    public  void delAdminUser(@RequestParam("uid") Integer uid,HttpServletResponse response) throws IOException {
        String result="";
        int i = adminUserService.deleteByPrimaryKey(uid);
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }

    @RequestMapping("/updateAdminUser")
    public void updateAdminUser(Adminuser adminuser,HttpServletResponse response) throws IOException {
        String result="";
        int i = adminUserService.updateByPrimaryKeySelective(adminuser);
        if(i>0){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }
    @RequestMapping(value = "oldPassword")
    public void oldPassword(Integer uid, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        String result="";
        Adminuser adminuser = adminUserService.selectByPrimaryKey(uid);
        if(adminuser.getPassword().equals(password)){
            result="Y";
        }else {
            result="N";
        }
        response.getWriter().write(result);
    }
    @RequestMapping("/updatePassword")
    public void  updatePassword(HttpServletResponse response,Adminuser adminuser) throws IOException {
        int i = adminUserService.updateByPrimaryKeySelective(adminuser);
        if(i!=0){
            response.getWriter().write("Y");
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        request.getSession().removeAttribute("user");
        return "index/index";
    }
    @RequestMapping("/findListByName")
    public  String findListByName(Model  model,Adminuser adminuser){

        List<Adminuser> listByName = adminUserService.findListByName(adminuser);
        model.addAttribute("list",listByName);
        return "/admin/list";
    }

    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(HttpServletRequest request,Integer uid){
       String [] rids = request.getParameterValues("rid");

            adminUserService.inserts(uid, rids);

        return "forward:/AdminuserList.action";
    }
}
