package com.product.Product.service;

import com.product.Product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDTO);
    ProductDto getProductById(String id);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(String id, ProductDto productDTO);
    void deleteProduct(String id);
}
