package com.rs.springframework.listner;

import com.rs.springframework.config.JmsConfig;
import com.rs.springframework.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * created by rs 3/5/2022.
 */
@Component
public class HelloMessageListner {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I Got a Message!!!!!");

        System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
        // throw new RuntimeException("foo");

    }

}
