package com.example.task.service;

import com.example.task.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product saveProduct(Product product);
}
