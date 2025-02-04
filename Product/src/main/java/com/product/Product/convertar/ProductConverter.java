package com.product.Product.convertar;

import com.product.Product.dto.ProductDto;
import com.product.Product.model.ProductModel;

public class ProductConverter {
    public static ProductDto toDTO(ProductModel product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    public static ProductModel toEntity(ProductDto dto) {
        ProductModel product = new ProductModel();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }
}
