package com.laobaozi.springcloud.provider.controller;

import com.laobaozi.springcloud.provider.model.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @RequestMapping("/user/list")
    public List<UserDto> listUsers() {
        List users = new ArrayList();
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("张三");
        users.add(userDto);
        return users;
    }


    @RequestMapping("/user/getUserName")
    public String listUsersName() {
        return "this is jim";
    }


    @RequestMapping("/user/addUser")
    public String addUser(@RequestBody UserDto userDto) {
        return userDto.getName()+" add success ";
    }



}
