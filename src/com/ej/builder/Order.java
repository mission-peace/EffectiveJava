package com.ej.builder;

import java.util.Date;

public class Order {

    private final String orderId;
    private final String customerId;
    private final int orderPrice;
    private final Date orderDate;
    
    public static class Builder{
        private String orderId;
        private String customerId;
        private int orderPrice;
        private Date orderDate;
        
        public Builder(String orderId, String customerId){
            this.orderId = orderId;
            this.customerId = customerId;
        }
        
        public Builder orderPrice(int orderPrice){
            this.orderPrice = orderPrice;
            return this;
        }
        
        public Builder orderDate(Date orderDate){
            this.orderDate = orderDate;
            return this;
        }
        
        public Order build(){
            return new Order(orderId, customerId, orderPrice, orderDate);
        }
    }
    
    private Order(String orderId, String customerId, int orderPrice, Date orderDate){
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }
    
    public static void main(String args[]){
        Order.Builder builder = new Order.Builder("2131", "1515");
        Order order = builder.orderPrice(10).orderDate(new Date()).build();
    }
}


