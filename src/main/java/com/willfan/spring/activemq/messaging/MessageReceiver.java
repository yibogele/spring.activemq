package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.configuration.AppConfig;
import com.willfan.spring.activemq.model.Inventory;
import com.willfan.spring.activemq.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Component
public class MessageReceiver {
    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
//    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";
    private ProductListener productListener = null;
    private InventoryListener inventoryListener = null;

    public void setProductListener(ProductListener productListener){
        this.productListener = productListener;
    }

    public void setInventoryListener(InventoryListener inventoryListener){
        this.inventoryListener = inventoryListener;
    }

    @JmsListener(destination = AppConfig.ORDER_RESPONSE_QUEUE)
    public void receiveInventory(final Message<Inventory> message) throws JMSException {
        LOG.info("======================================================");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);

        Inventory response = message.getPayload();
        LOG.info("Application : Inventory received : {}",response);
        LOG.info("=======================================================");
        if(this.inventoryListener != null)
        this.inventoryListener.onInventory(response);
    }

    @JmsListener(destination = AppConfig.ORDER_QUEUE)
    public void receiveProduct(final Message<Product> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);

        Product response = message.getPayload();
        LOG.info("Application : Product received : {}",response);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if(this.productListener != null)
        this.productListener.onProduct(response);
    }
}
