package com.selfordersystem.deskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class DeskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeskServiceApplication.class, args);
    }

}
