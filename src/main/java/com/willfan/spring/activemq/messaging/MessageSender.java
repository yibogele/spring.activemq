package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.configuration.AppConfig;
import com.willfan.spring.activemq.model.Inventory;
import com.willfan.spring.activemq.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Product product) {

        jmsTemplate.setDefaultDestinationName(AppConfig.ORDER_QUEUE);
        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(product);
                return objectMessage;
            }
        });
    }

    public void sendMessage(final Inventory inventory) {

        jmsTemplate.setDefaultDestinationName(AppConfig.ORDER_RESPONSE_QUEUE);
        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(inventory);
                return objectMessage;
            }
        });
    }
}
