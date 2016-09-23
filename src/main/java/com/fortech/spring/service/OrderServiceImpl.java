package com.fortech.spring.service;

import com.fortech.spring.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    MailService mailService;

    @Override
    public void sendOrderConfirmation(ProductOrder productOrder) {
        mailService.sendEmail(productOrder);
    }
}
