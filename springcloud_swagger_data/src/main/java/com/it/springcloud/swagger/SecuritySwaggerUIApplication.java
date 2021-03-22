package com.it.springcloud.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = "com.it.springcloud.model.pojo")//扫描实体类所在的包路径
@ComponentScan(basePackages = "com.it.springcloud")
public class SecuritySwaggerUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySwaggerUIApplication.class, args);
        System.out.println("springcloud_swagger_data服务" +
                "成功启动！！！");
    }
}
