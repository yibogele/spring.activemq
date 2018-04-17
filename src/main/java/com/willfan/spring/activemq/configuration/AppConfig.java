package com.willfan.spring.activemq.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Configuration
@ComponentScan(basePackages = "com.willfan.spring.activemq")
@Import({MessagingConfiguration.class, MessagingListnerConfiguration.class})
public class AppConfig {
    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    public static final String ORDER_RESPONSE_QUEUE = "topic://order-response-queue";
    public static final String ORDER_QUEUE = "topic://order-queue";

    @Value("{activemq.brokerUrl}")
    public static String brokerUrl;

    @Value("{activemq.productTopic}")
    public static String productTopic;

}
