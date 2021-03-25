package com.laobaozi.springcloud.provider.service;


import com.laobaozi.springcloud.provider.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service")
public interface UserFeginService {

    @PostMapping("/fegin/user/list")
    UserDto listUser();



}
