package com.willfan.spring.activemq.service.impl;

import com.willfan.spring.activemq.messaging.MessageSender;
import com.willfan.spring.activemq.model.Inventory;
import com.willfan.spring.activemq.model.Product;
import com.willfan.spring.activemq.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void processOrder(Product product) {

        Inventory response = prepareResponse(product);
        LOG.info("Inventory : sending order confirmation {}", response);
        messageSender.sendMessage(response);
    }

    private Inventory prepareResponse(Product product){
        Inventory response = new Inventory();
        response.setProductId(product.getProductId());
        response.setReturnCode(200);
        response.setComment("Order Processed successfully");
        return response;
    }

    public void sendInventory(Inventory ir){
        LOG.info("------------------------------------------------------");
        LOG.info("Application : sending order request {}", ir);
        messageSender.sendMessage(ir);
        LOG.info("------------------------------------------------------");
    }
}
