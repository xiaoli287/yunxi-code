package com.goodidea.yunxi;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class YunxiApplicationTests {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", "127.0.0.1:8848");
            properties.put("namespace", "test_yunxi");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String contentInfo = configService.getConfig("yunxi.yaml",
                    "DEFAULT_GROUP", 1000L);
            System.out.println("contentInfo:" + contentInfo);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

}
