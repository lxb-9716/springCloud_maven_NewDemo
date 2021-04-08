package com.it.springcloud.rabbitmq.producer.controller;

import com.it.springcloud.rabbitmq.producer.config.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rabbitmq")
public class RabbitmqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*发送消息*/
    @GetMapping("/testRabbitmqSend")
    public void testRabbitmqSend() {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTING_KEY_A, "向A队列发送了消息！！！");
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTING_KEY_B, "向B队列发送了消息！！！");
    }
}
