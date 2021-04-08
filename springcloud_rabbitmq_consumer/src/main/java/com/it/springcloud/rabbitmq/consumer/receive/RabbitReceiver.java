package com.it.springcloud.rabbitmq.consumer.receive;

import com.it.springcloud.rabbitmq.consumer.config.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列---接收方
 */
@Component
public class RabbitReceiver {
    /*接收A队列中的消息*/
    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void receiveA(String msg) {
        System.out.println("接收到了交换机发送到A队列的消息msg：" + msg);
    }

    /*接收B队列中的消息*/
    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    public void receiveB(String msg) {
        System.out.println("接收到了交换机发送到B队列的消息msg：" + msg);
    }
}
