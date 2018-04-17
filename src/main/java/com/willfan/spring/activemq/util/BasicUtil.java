package com.willfan.spring.activemq.util;

import java.util.UUID;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public class BasicUtil {
    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
