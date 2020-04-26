package com.yhnet.crm.facebook.admin.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.yhnet.crm.facebook.admin.common.util.CacheUtil;
import com.yhnet.crm.facebook.admin.common.util.Constant;
import com.yhnet.crm.facebook.admin.common.util.Global;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 文件上传
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class FileController {

    @Autowired
    private CacheUtil cacheUtil;

    @PostMapping("/fileUpload")
    public R fileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File newFile = new File(Constant.WX_QR_PATH, fileName);
        FileUtils.copyInputStreamToFile(file.getInputStream(),newFile);
//        String qrUrl = Global.getValue("server_host") + "/admin/fetch/wxqr/" + fileName;
        String qrUrl = "http://192.168.0.125:8080" + "/admin/fetch/wxqr/" + fileName;
        return R.ok(qrUrl);
    }

    /**
     * 获取文件
     * @param type
     * @param fileName
     * @return
     */
    @GetMapping("/fetch/{type}/{fileName}")
    public ResponseEntity<Resource> file(@PathVariable String type, @PathVariable String fileName){
        Resource file = loadAsResource(type + "/" + fileName);
        MediaType mediaType = MediaType.parseMediaType("image/jpeg");//TODO 暂时写死图片
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }
    /**
     * 重载缓存
     */
    @RequestMapping("/reloadCache")
    public void reloadCache(){
        cacheUtil.reload();
    }


    private Path rootLocation;
    public Resource loadAsResource(String filename) {
        try {
            if (rootLocation == null){
                rootLocation = Paths.get(Constant.LOCAL_STORAGE);
                try {
                    Files.createDirectories(rootLocation);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
