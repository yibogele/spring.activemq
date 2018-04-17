package com.willfan.spring.activemq.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Configuration
public class MessagingConfiguration {
//    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
//
//    private static final String ORDER_QUEUE = "order-queue";
//
//    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(AppConfig.DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com.willfan.spring.activemq","java.util"));
        return connectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(){
        return new CachingConnectionFactory(connectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
//        template.setConnectionFactory(cachingConnectionFactory()); // for cache
        template.setDefaultDestinationName(AppConfig.ORDER_QUEUE);
        template.setPubSubDomain(true);
        template.setReceiveTimeout(10000);

        return template;
    }
}
