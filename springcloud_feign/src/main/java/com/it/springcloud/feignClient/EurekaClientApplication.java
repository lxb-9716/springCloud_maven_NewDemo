package com.it.springcloud.feignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient   //表示该服务是eureka的客户端
//@EnableCircuitBreaker //激活使用hystrix   由于feign集成了hystrix熔断器，所以该注解可省略不写
@EnableFeignClients  //feign远程调用
@ComponentScan("com.it.springcloud")
@Configuration("application-db.yml")
@SpringBootApplication//当前类是springBoot的启动类,排除数据源的自动扫描
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
        System.out.println("eurekaClient客户端启动成功");
    }
}
