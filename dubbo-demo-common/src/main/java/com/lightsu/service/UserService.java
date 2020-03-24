package com.lightsu.service;

import com.lightsu.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserByName(String name);
}
