package com.example.RabbitMQ_Task.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String Queue_Name = "msgQueue";
    public static final String Exchange_Name = "msgExchange";
    public static final String Routing_Key = "msgRoutingKey";

    @Bean
    public Queue queue() {
        return new Queue(Queue_Name);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange_Name);
    }


    @Bean
    public Binding binding(Queue Queue_Name, TopicExchange Exchange_Name) {
        return BindingBuilder.bind(Queue_Name).to(Exchange_Name).with(Routing_Key);
    }

}
