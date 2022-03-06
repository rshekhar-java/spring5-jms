package com.rs.springframework.sender;

import com.rs.springframework.config.JmsConfig;
import com.rs.springframework.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * created by rs 3/5/2022.
 */
@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I am Sending a message");

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World !!")
                .build();
         jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,message);

         System.out.println("Message Sent Successfully!");
    }

}
