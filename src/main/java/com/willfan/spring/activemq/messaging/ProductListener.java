package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.model.Product;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public interface ProductListener {
    public void onProduct(Product product);
}
