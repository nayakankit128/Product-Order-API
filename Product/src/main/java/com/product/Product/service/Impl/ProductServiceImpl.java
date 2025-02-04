package com.product.Product.service.Impl;

import com.product.Product.convertar.ProductConverter;
import com.product.Product.dto.ProductDto;
import com.product.Product.exceptions.ProductNotFound;
import com.product.Product.model.ProductModel;
import com.product.Product.repository.ProductRepository;
import com.product.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;



    @Override
    public ProductDto createProduct(ProductDto productDTO) {
        ProductModel product = ProductConverter.toEntity(productDTO);
        ProductModel savedProduct = productRepository.save(product);
        return ProductConverter.toDTO(savedProduct);
    }

    @Override
    public ProductDto getProductById(String id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("product not found"));
        return ProductConverter.toDTO(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(String id, ProductDto productDTO) {
        ProductModel existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("product not found"));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());

        ProductModel updatedProduct = productRepository.save(existingProduct);
        return ProductConverter.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("id not found"));
        productRepository.delete(product);
    }
}
