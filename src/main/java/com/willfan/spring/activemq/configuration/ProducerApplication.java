package com.willfan.spring.activemq.configuration;

import com.willfan.spring.activemq.model.Product;
import com.willfan.spring.activemq.service.ProductService;
import com.willfan.spring.activemq.util.BasicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Will Fan
 * @version 0.1 2018/4/16
 */
public class ProducerApplication {
    static final Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);

    private static AtomicInteger id = new AtomicInteger();

    public static void main(String[] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        ProductService productService = (ProductService) context.getBean("productService");


        Product product = getProduct();
        LOG.info("Application : sending order {}", product);
        productService.sendProduct(product);

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((AbstractApplicationContext)context).close();
    }


    private static Product getProduct(){
        Product p = new Product();
        p.setName("Product "+id.incrementAndGet());
        p.setProductId(BasicUtil.getUniqueId());
        p.setQuantity(2);
        return p;
    }
}
