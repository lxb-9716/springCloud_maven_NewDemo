package com.it.springcloud.rabbitmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
        System.out.println("springcloud_rabbitmq_consumer消费者服务启动成功！！！");
    }
}
