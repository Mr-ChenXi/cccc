package com.yhnet.crm.facebook.admin.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.yhnet.crm.facebook.admin.common.util.Global;
import com.yhnet.crm.facebook.admin.entity.SysConfig;
import com.yhnet.crm.facebook.admin.entity.model.ConfigModel;
import com.yhnet.crm.facebook.admin.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pacey
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/admin/sysConfig")
public class SysConfigController {

    @Autowired
    private ISysConfigService sysConfigService;

    @GetMapping("/list")
    public R list(){
        List<SysConfig> sysConfigs = sysConfigService.list();
        ConfigModel configModel = new ConfigModel();
        sysConfigs.forEach(sysConfig -> {
            if(sysConfig.getCode().equals("wx_qrcode_path")){
                configModel.setWxQrcodePath(sysConfig.getValue());
            }else if(sysConfig.getCode().equals("banner")){
                configModel.setBanner(sysConfig.getValue());
            }else if(sysConfig.getCode().equals("wx_num")){
                configModel.setWxNum(sysConfig.getValue());
            } else if(sysConfig.getCode().equals("qq")){
                configModel.setQq(sysConfig.getValue());
            }else if(sysConfig.getCode().equals("remark")){
                configModel.setRemark(sysConfig.getValue());
            }
        });
        return R.ok(configModel);
    }
    @PostMapping("/update")
    public R update(@RequestBody ConfigModel configModel){
        List<SysConfig> sysConfigs = sysConfigService.list();
        sysConfigs.forEach(sysConfig -> {
            if(sysConfig.getCode().equals("wx_qrcode_path")){
                sysConfig.setValue(configModel.getWxQrcodePath());
            }else if(sysConfig.getCode().equals("banner")){
                sysConfig.setValue(configModel.getBanner());
            }else if(sysConfig.getCode().equals("wx_num")){
                sysConfig.setValue(configModel.getWxNum());
            } else if(sysConfig.getCode().equals("qq")){
                sysConfig.setValue(configModel.getQq());
            }else if(sysConfig.getCode().equals("remark")){
                sysConfig.setValue(configModel.getRemark());
            }
        });
        boolean b = sysConfigService.updateBatchById(sysConfigs);
        if(b){
            return R.ok("");
        }
        return R.failed("修改失败");
    }


}

