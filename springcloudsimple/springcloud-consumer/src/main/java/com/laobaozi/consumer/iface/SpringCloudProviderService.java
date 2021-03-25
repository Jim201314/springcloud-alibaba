package com.laobaozi.consumer.iface;


import com.laobaozi.consumer.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "springcloud-provicer-demo")
public interface SpringCloudProviderService {

    @PostMapping("/user/getUserName")
    public String getUserName();

    @PostMapping("/user/list")
    public List<UserDto> listUsers();

    @PostMapping("/user/addUser")
    public String addUser(@RequestBody UserDto userDto);



}
