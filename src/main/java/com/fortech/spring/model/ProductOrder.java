package com.fortech.spring.model;

public class ProductOrder {

    private String orderPassword;
    private CustomerInfo customerInfo;

    public String getOrderPassword() {
        return orderPassword;
    }

    public void setOrderPassword(String orderPassword) {
        this.orderPassword = orderPassword;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    @Override
    public String toString() {
        return "ProductOrder [orderPassword="+ orderPassword +", customerInfo="+customerInfo+"]";
    }

}
