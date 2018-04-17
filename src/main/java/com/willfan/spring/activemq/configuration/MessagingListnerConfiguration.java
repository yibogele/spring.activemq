package com.willfan.spring.activemq.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Configuration
@EnableJms
public class MessagingListnerConfiguration {
//    @Autowired
//    ConnectionFactory connectionFactory;

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
        factory.setConnectionFactory(cachingConnectionFactory);
        factory.setConcurrency("2-10");
        factory.setPubSubDomain(true);

        return factory;
    }

}
