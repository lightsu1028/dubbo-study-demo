package com.lightsu.config;

import com.lightsu.service.UserService;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

//dubbo api 配置
@Configuration
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("user-service-provider");
        return application;
    }

    @Bean
    public RegistryConfig registryConfig(){
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        registry.setProtocol("zookeeper");
        return registry;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        return protocol;
    }

    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService userService){
        // 服务提供者暴露服务配置
        ServiceConfig<UserService> serviceConfig = new ServiceConfig(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        serviceConfig.setApplication(applicationConfig());
        serviceConfig.setRegistry(registryConfig()); // 多个注册中心可以用setRegistries()
        serviceConfig.setProtocol(protocolConfig()); // 多个协议可以用setProtocols()
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserByName");
        methodConfig.setTimeout(4000);

        List<MethodConfig> methodConfigs = Arrays.asList(methodConfig);

        serviceConfig.setMethods(methodConfigs);

        return serviceConfig;
    }
}
