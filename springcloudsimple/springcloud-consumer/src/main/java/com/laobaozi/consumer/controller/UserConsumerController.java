package com.laobaozi.consumer.controller;


import com.laobaozi.consumer.iface.SpringCloudProviderService;
import com.laobaozi.consumer.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConsumerController {

    @Autowired
    SpringCloudProviderService springCloudProviderService;

    @RequestMapping("/user/getUserName")
    public String listUsersName() {
        return springCloudProviderService.getUserName();
    }


    @RequestMapping("/user/list")
    public List<UserDto> listUsers() {
        return springCloudProviderService.listUsers();
    }


    @RequestMapping("/user/addUser")
    public String addUser(@RequestBody UserDto userDto) {
        return springCloudProviderService.addUser(userDto);
    }

}
