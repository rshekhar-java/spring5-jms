package com.rs.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * created by rs 3/5/2022.
 */
@Configuration
public class JmsConfig {
    public static final String MY_QUEUE = "my-hello-world";
    public static final String MY_SEND_RCV_QUEUE = "replybacktome";


    @Bean
    public MappingJackson2MessageConverter messageConverter(){

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
