package com.it.springcloud.rabbitmq.consumer.config.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*定义交换机名称*/
    public static final String EXCHANGE_A = "exchange_a";
    public static final String EXCHANGE_B = "exchange_b";

    /*定义消息队列名称*/
    public static final String QUEUE_A = "queue_a";
    public static final String QUEUE_B = "queue_b";

    /*定义路由名称*/
    public static final String ROUTING_KEY_A = "routing_key_a";
    public static final String ROUTING_KEY_B = "routing_key_b";

    /*交换机A*/
    @Bean
    public DirectExchange directExchangeA() {
        return new DirectExchange(EXCHANGE_A);
    }

    /*队列A*/
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A);
    }

    /*队列B*/
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B);
    }

    /*绑定队列A到交换机A，并指定routingKey为A*/
    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(directExchangeA()).with(ROUTING_KEY_A);
    }

    /*绑定队列B到交换机A，并指定routingKey为B*/
    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(directExchangeA()).with(ROUTING_KEY_B);
    }
}
