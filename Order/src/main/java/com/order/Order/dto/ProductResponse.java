package com.order.Order.dto;

import lombok.Data;
@Data
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;

}
