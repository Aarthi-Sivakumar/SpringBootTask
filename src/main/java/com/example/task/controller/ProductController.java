package com.example.task.controller;

import com.example.task.api.ProductApi;
import com.example.task.entity.Product;
import com.example.task.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public Product saveProduct(Product product) {
    return productService.saveProduct(product);
    }
}
