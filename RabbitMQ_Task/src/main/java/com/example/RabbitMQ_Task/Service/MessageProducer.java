package com.example.RabbitMQ_Task.Service;

import com.example.RabbitMQ_Task.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;



    public void sendmsg(String jsonmsg){

        rabbitTemplate.convertAndSend(RabbitMQConfig.Exchange_Name,RabbitMQConfig.Routing_Key,jsonmsg.getBytes());

    }
}
