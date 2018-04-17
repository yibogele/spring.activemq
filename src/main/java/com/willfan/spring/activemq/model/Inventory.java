package com.willfan.spring.activemq.model;

import java.io.Serializable;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public class Inventory implements Serializable {
    private String productId;
    private int returnCode;
    private String comment;

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Inventory [productId=" + productId + ", returnCode=" + returnCode + ", comment=" + comment
                + "]";
    }
}
