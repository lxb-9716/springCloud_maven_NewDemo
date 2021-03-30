package com.it.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

//@EnableZuulServer //高配版本
@EnableZuulProxy   //低配版本，开启zuul网关
@EnableEurekaClient //当前服务是eureka的一个客户端
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        System.out.println("springcloud_zuul_gatway网关微服务启动成功！！！");
    }
}
