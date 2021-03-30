package com.it.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine  //开启turbine 断路器聚合监控
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
        System.out.println("springcloud_hystrix_turbine断路器聚合监控服务启动成功！！！");
    }
}
