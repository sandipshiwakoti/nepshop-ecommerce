package com.nepshop.model;

public class OrderedProduct {
    String photo;
    String name;
    String company;
    Double price;
    int quantity;
    String shipping_address;
    String payment_method;

    public OrderedProduct(String photo, String name, String company, Double price, int quantity,
            String shipping_address, String payment_method) {
        this.photo = photo;
        this.name = name;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
        this.shipping_address = shipping_address;
        this.payment_method = payment_method;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "OrderedProduct [company=" + company + ", name=" + name + ", payment_method=" + payment_method
                + ", photo=" + photo + ", price=" + price + ", quantity=" + quantity + ", shipping_address="
                + shipping_address + "]";
    }

}
