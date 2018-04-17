package com.willfan.spring.activemq.messaging;

import com.willfan.spring.activemq.model.Inventory;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public interface InventoryListener {
    public void onInventory(Inventory ir);
}
