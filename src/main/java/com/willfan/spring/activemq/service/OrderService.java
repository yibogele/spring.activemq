package com.willfan.spring.activemq.service;

import com.willfan.spring.activemq.model.Product;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public interface OrderService {
    public void processOrder(Product product);
}
