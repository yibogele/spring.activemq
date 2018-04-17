package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public class ProductListenerImpl implements ProductListener{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListenerImpl.class);

    @Override
    public void onProduct(Product product) {
        LOGGER.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Product received: {}", product);
    }
}
