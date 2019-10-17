package com.crazyplay.highwan.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 1, 2019)
 * @version 1.0
 * @fileName UserApplication.java
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
