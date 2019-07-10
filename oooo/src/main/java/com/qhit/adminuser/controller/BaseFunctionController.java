package com.qhit.adminuser.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.adminuser.pojo.BaseFunction;
import com.qhit.adminuser.service.basefunction.BaseFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Controller
@RequestMapping("/baseFunction")
public class BaseFunctionController {

    @Autowired
    private BaseFunctionService baseFunctionService;

    //无权限
    @RequestMapping("/functionList")
    public void BaseFuntionList(HttpServletResponse response) throws IOException {
//        response.setContentType("json/appliction");
        List<BaseFunction>  baseFunctions = baseFunctionService.findAll();
        response.getWriter().write(String.valueOf(JSON.toJSONString(baseFunctions)));
    }
    //有权限
    @RequestMapping("/functionListByUid")
    public void BaseFuntionListByUid(HttpServletResponse response ,
                                     @RequestParam("uid") Integer uid) throws IOException {

        List<BaseFunction> allByUid = baseFunctionService.findAllByUid(uid);
        response.getWriter().write(String.valueOf(JSON.toJSONString(allByUid)));
    }
    @RequestMapping("/listold")
    public  String listold(Model model){
        List<BaseFunction>  baseFunctions = baseFunctionService.findAll();
        model.addAttribute("list",baseFunctions);
        return "/baseFunction/listold";
    }

    @RequestMapping("/distribute")
    public String distribute(Model model, @RequestParam("rid") Integer rid){
        List<BaseFunction> baseFunction = baseFunctionService.getBaseFunctionNameAndId(rid);
        List<BaseFunction> baseNotFunction = baseFunctionService.getNotBaseFunctionNameAndId(rid);
        model.addAttribute("rid",rid);
        model.addAttribute("rightList",baseFunction);
        model.addAttribute("leftList",baseNotFunction);
        return "/baseRole/distribute";
    }

    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(HttpServletRequest request, Integer rid){
        String [] fids = request.getParameterValues("fid");
        baseFunctionService.inserts(rid, fids);
        return "forward:/baseRole/list.action";
    }
}
