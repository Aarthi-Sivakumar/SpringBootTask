package com.example.task.api;

import com.example.task.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/products")
@CrossOrigin
public interface ProductApi {
    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product);

}
