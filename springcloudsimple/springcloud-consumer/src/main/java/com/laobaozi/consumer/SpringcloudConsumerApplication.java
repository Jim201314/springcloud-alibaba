package com.laobaozi.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.laobaozi.consumer.iface")
public class SpringcloudConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

}
