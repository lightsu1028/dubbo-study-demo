package com.lightsu.serviceImpl;

import com.lightsu.model.User;
import com.lightsu.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service(version ="2.0.0" )
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUserByName() {
        System.out.println("provider方法调用，当前版本2.0.0");
        User u1 = new User("Jack", 20, "男", "北京");
        User u2 = new User("Jack", 43, "男", "上海");
//        try {
////            Thread.sleep(2000);
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return Arrays.asList(u1,u2);
    }
}
