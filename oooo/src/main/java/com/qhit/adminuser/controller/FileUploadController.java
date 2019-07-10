package com.qhit.adminuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping("/fileupload")
    @ResponseBody
    public String fileupload(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //获取文件根路径
        String path = request.getServletContext().getRealPath("/images/upload");
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //转义 将路径中的 / 转义为 \
        String path1[]=path.split("\\\\");
        //截取最后的 文件名
        String path2 = path1[path1.length - 1];
        //将文件路径和名字写入File
        File dir=new File(path,fileName);
        //判断文件夹是否存在 没有则创建
        if(dir.exists()){
            dir.mkdirs();
        }
        //判断传入的文件是否为空 如果不为空 则解析
        if(!file.isEmpty()){
            file.transferTo(dir);
            return path2+"\\"+fileName;

        }else {
            System.out.println("空文件");
            return "空文件";
        }


    }

}
