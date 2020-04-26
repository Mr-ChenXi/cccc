package com.yhnet.crm.facebook.admin.common.util;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yhnet.crm.facebook.admin.entity.SysConfig;
import com.yhnet.crm.facebook.admin.service.ISysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 缓存帮助类
 */
@Slf4j
@Component
public class CacheUtil {

    @Resource
    private ISysConfigService sysConfigService;

    /**
     * 初始化系统参数配置
     */
    @PostConstruct
    public void initSysConfig() {
        if (Global.configMap !=null ){
            return;
        }

        Map<String, Object> configMap = new HashMap<>();

        List<SysConfig> sysConfigs = sysConfigService.list();
        for (SysConfig sysConfig : sysConfigs) {
            if (null != sysConfig && StringUtil.isNotBlank(sysConfig.getCode())) {
                configMap.put(sysConfig.getCode(), sysConfig.getValue());
            }
        }

        Global.configMap = new HashMap<String, Object>();
        Global.configMap.putAll(configMap);
    }

    public void reload(){
        List<SysConfig> sysConfigs = sysConfigService.list();
        for (SysConfig sysConfig : sysConfigs) {
            if (null != sysConfig && StringUtils.isNotBlank(sysConfig.getCode())) {
                Global.configMap.put(sysConfig.getCode(), sysConfig.getValue());
            }
        }
    }

}
