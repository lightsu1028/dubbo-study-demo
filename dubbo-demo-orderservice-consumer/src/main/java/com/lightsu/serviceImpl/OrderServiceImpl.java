package com.lightsu.serviceImpl;

import com.lightsu.model.User;
import com.lightsu.service.OrderService;
import com.lightsu.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    @Reference
    UserService userService;

    @Override
    public List<User> getUserByName() {
       return userService.getUserByName();
    }
}
