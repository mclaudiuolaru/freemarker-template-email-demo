package com.fortech.spring.service;

import com.fortech.spring.model.ProductOrder;

public interface OrderService {
    public void sendOrderConfirmation(ProductOrder productOrder);
}
