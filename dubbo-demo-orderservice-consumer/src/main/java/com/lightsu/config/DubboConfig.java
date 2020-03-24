package com.lightsu.config;

import com.lightsu.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("order.service.consumer");
        return application;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        registry.setUsername("zookeeper");
        return registry;
    }

    @Bean
    public ReferenceConfig<UserService> referenceConfig() {
        // 引用远程服务
        ReferenceConfig<UserService> reference = new ReferenceConfig(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(applicationConfig());
        reference.setRegistry(registryConfig()); // 多个注册中心可以用setRegistries()
        reference.setInterface(UserService.class);
        return reference;
    }

    @Bean
    public UserService userService(ReferenceConfig referenceConfig){
        UserService userService = referenceConfig().get();
        return userService;
    }

}
