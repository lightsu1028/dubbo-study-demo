package com.lightsu.serviceImpl;

import com.lightsu.model.User;
import com.lightsu.service.UserService;
import io.netty.util.internal.StringUtil;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class UserServiceStub implements UserService {

    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<User> getUserByName(String name) {
        System.out.println("UserServiceStub 调用");
        if(StringUtils.isBlank(name)){
            return null;
        }
        return userService.getUserByName(name);
    }
}
