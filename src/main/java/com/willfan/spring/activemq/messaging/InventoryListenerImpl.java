package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.model.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public class InventoryListenerImpl implements InventoryListener{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListenerImpl.class);

    @Override
    public void onInventory(Inventory ir) {
        LOGGER.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Inventory received: {}", ir);
    }
}
