package com.laobaozi.springcloud.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    /**
     * sentinel流控测试接口
     * @return
     */
    @RequestMapping("/user/getUserLimitTest")
    @SentinelResource(value = "getUserLimitTest", blockHandler = "handleLimitException")
    public String getUserLimitTest() {
        System.out.println("comming to the jim api limit test");
        return "this is jim api limit test";
    }

    /**
     * sentinel 异常精熔断测试接口
     * @return
     */
    @RequestMapping("/user/getUserExceptionDegradeTest")
    @SentinelResource(value = "getUserExceptionDegradeTest",  fallback = "handleErrorException")
    public String getUserExceptionTest() {
        System.out.println("comming to the jim api degrade test");
        throw new RuntimeException("error");
    }

    /**
     * 限流异常捕获
     * @param exception
     * @return
     */
    public String handleLimitException(BlockException exception){
        System.out.println("flow exception:"+exception.getClass().getCanonicalName());
        return ("达到阈值了,不要再访问了!");
    }

    /**
     * 异常降级捕获
     * @return
     */
    public String handleErrorException(){
        System.out.println("flow degrade exception");
        return ("服务被熔断了，不要调用!");
    }




}
