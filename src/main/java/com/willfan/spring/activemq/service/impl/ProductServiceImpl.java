package com.willfan.spring.activemq.service.impl;

import com.willfan.spring.activemq.messaging.MessageSender;
import com.willfan.spring.activemq.model.Product;
import com.willfan.spring.activemq.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void sendProduct(Product product) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        LOG.info("Application : sending order request {}", product);
        messageSender.sendMessage(product);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
