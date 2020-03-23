package com.lightsu.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{
    private String name;
    private Integer age;
    private String sex;
    private String address;

    public User(String name, Integer age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
}
