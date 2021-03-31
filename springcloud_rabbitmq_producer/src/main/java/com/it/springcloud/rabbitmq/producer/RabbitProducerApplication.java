package com.it.springcloud.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
        System.out.println("springcloud_rabbitmq_producer生产者服务启动成功！！！");
    }
}
