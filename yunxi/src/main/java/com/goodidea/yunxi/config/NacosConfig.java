package com.goodidea.yunxi.config;


import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import lombok.Data;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// 刷新配置
@RefreshScope
@Data
@Component
public class NacosConfig {
//    @Value("${server.port}")
//    private Integer serverPort;
//
//    @Value("${spring.application.name}")
//    private String applicationName;

//    @NacosInjected
//    private NamingService namingService;

    @Autowired
    NacosConfigProperties nacosConfigProperties;

    @Autowired
    NacosDiscoveryProperties nacosDiscoveryProperties;
    /**
     * 通过Naming服务注册实例到注册中心
     *
     * @throws NacosException
     */
    @PostConstruct
    public void registerInstance() throws NacosException {

        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

        namingService.registerInstance("yunxi", "127.0.0.1", 8083);

    }
}
