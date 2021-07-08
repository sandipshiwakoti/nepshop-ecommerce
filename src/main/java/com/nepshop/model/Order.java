package com.nepshop.model;

public class Order {
    int id;
    Double total_cost;
    int customer_id;
    String shipping_address;
    String phone;
    String payment_method;

    public Order(int id, Double total_cost, int customer_id, String shipping_address, String phone,
            String payment_method) {
        this.id = id;
        this.total_cost = total_cost;
        this.customer_id = customer_id;
        this.shipping_address = shipping_address;
        this.phone = phone;
        this.payment_method = payment_method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "Order [customer_id=" + customer_id + ", id=" + id + ", payment_method=" + payment_method + ", phone="
                + phone + ", shipping_address=" + shipping_address + ", total_cost=" + total_cost + "]";
    }
}
