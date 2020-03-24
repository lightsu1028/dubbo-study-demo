package com.lightsu.controller;

import com.lightsu.model.User;
import com.lightsu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public Object getUser(@RequestParam String  name){
        List<User> userByName = orderService.getUserByName(name);
        return userByName;
    }
}
