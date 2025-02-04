package com.order.Order.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private String id;
    private String productId;
    private int quantity;
    private double totalPrice;
    private String status;

}
