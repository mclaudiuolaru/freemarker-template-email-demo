package com.fortech.spring.model;

public class CustomerInfo {

    private String customerName;
    private String customerAddress;
    private String customerEmail;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "CustomerInfo [customerName="+ customerName +"customerAddress="+ customerAddress +"customerEmail="+ customerEmail +"]";
    }
}
