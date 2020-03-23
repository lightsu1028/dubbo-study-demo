package com.lightsu.serviceImpl;

import com.lightsu.model.User;
import com.lightsu.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUserByName() {
        User u1 = new User("Jack", 20, "男", "北京");
        User u2 = new User("Jack", 43, "男", "上海");

        return Arrays.asList(u1,u2);
    }
}
