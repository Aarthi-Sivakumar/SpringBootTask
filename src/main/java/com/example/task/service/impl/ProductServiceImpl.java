package com.example.task.service.impl;

import com.example.task.entity.Product;
import com.example.task.repository.ProductRepo;
import com.example.task.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product saveProduct(Product product) {
        Product save = productRepo.save(product);
        return save;
    }
}
