package com.crazyplay.highwan.party;

import org.mybatis.spring.annotation.MapperScan;
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
 * @fileName PartyApplication.java
 */
@SpringBootApplication
@MapperScan("com.crazyplay.highwan.party.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class PartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(PartyApplication.class, args);
    }
}
