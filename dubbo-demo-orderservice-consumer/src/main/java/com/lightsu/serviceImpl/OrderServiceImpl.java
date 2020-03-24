package com.lightsu.serviceImpl;

import com.lightsu.model.User;
import com.lightsu.service.OrderService;
import com.lightsu.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    @Reference(version = "1.0.0")
    @Reference(check = false)
//    @Reference(timeout = 3000)
//    @Reference(retries = 1)
//    @Reference(stub = "com.lightsu.serviceImpl.UserServiceStub")
//    @Reference(stub = "true") //设置为 true 需要将UserServiceStub放到UserService一个包下
    UserService userService;

    @Override
    public List<User> getUserByName(String name) {
       return userService.getUserByName(name);
    }
}
