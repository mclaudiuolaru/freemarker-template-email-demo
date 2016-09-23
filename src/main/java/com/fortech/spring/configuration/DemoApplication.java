package com.fortech.spring.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.fortech.spring.model.CustomerInfo;
import com.fortech.spring.model.ProductOrder;
import com.fortech.spring.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.sendOrderConfirmation(getDummyOrder());
		((AbstractApplicationContext) context).close();
        SpringApplication.run(DemoApplication.class, args);
	}

	public static ProductOrder getDummyOrder() {
		ProductOrder order = new ProductOrder();
		order.setOrderPassword("theaccountpassword");

		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerName("Claudiu Olaru");
        customerInfo.setCustomerEmail("claudiu.olaru@fortech.ro");
		order.setCustomerInfo(customerInfo);
		return order;
	}
}
