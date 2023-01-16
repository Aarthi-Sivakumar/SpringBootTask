package com.example.task.service;

import com.example.task.entity.Product;
import com.example.task.repository.ProductRepo;
import com.example.task.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;

    @Before
    public void setUp(){
        product = new Product("004","Laptop",1500,15000.0f);
    }

    @Test
    public void saveProduct() throws Exception{
        when(productRepo.save(any(Product.class))).thenReturn(product);
        Product actual = productService.saveProduct(product);
        Assertions.assertEquals(actual.getProductId(),product.getProductId());
    }

}
