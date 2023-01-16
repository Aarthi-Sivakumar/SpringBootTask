package com.example.task.service;

import com.example.task.entity.Product;
import com.example.task.entity.ProductQuantityAudit;
import com.example.task.repository.ProductQuantityAuditRepo;
import com.example.task.repository.ProductRepo;
import com.example.task.service.impl.ProductQuantityAuditImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductQuantityAuditTest {

    @Mock
    ProductQuantityAuditRepo productQuantityAuditRepo;

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductQuantityAuditImpl productQuantityAudit;

    ProductQuantityAudit productQuantityAudit1;
    ProductQuantityAudit productQuantityAudit2;
    ProductQuantityAudit productQuantityAudit3;
    ProductQuantityAudit productQuantityAudit4;
    Product product;
    Product product1;

    @Before
    public void setUp(){
        product = new Product("004","Laptop",1500,15000.0f);
        product1 = new Product("004","Laptop",10,15000.0f);
        productQuantityAudit1 = new ProductQuantityAudit("190290","004",100,"CONSUME",45,100);
        productQuantityAudit2 = new ProductQuantityAudit("190290","004",100,"APPEND",45,100);
        productQuantityAudit3 = new ProductQuantityAudit("190290","004",100,"REFURBISH",45,100);
        productQuantityAudit4 = new ProductQuantityAudit("190290","004",100,"NOCOMMENT",45,100);

    }

    @Test
    public void getByIdExists()throws Exception {
        Mockito.when(productQuantityAuditRepo.findByProductId(anyString())).thenReturn(List.of(productQuantityAudit1));
        List<ProductQuantityAudit> exists = productQuantityAudit.getDetailsById(productQuantityAudit1.getProductId());
        Assertions.assertEquals(exists,List.of(productQuantityAudit1));
    }

    @Test
    public void methodConsume()throws Exception{
        Mockito.when(productRepo.findById(productQuantityAudit1.getProductId())).thenReturn(Optional.of(product));
        String consume = productQuantityAudit.addHistory(productQuantityAudit1);
        Assertions.assertEquals("Update after type : " + productQuantityAudit1.getType(),consume);
    }

    @Test
    public void methodAppend()throws Exception{
        Mockito.when(productRepo.findById(productQuantityAudit2.getProductId())).thenReturn(Optional.of(product));
        String append = productQuantityAudit.addHistory(productQuantityAudit2);
        Assertions.assertEquals("Update after type : " + productQuantityAudit2.getType(), append);
    }

    @Test
    public void methodRefurbish()throws Exception{
        Mockito.when(productRepo.findById(productQuantityAudit3.getProductId())).thenReturn(Optional.of(product));
        String refurbish = productQuantityAudit.addHistory(productQuantityAudit3);
        Assertions.assertEquals("Update after type : " + productQuantityAudit3.getType(), refurbish);
    }

    @Test
    public void productNotAvailable()throws Exception{
        Mockito.when(productRepo.findById(productQuantityAudit1.getProductId())).thenReturn(Optional.of(product1));
        String notAvailable = productQuantityAudit.addHistory(productQuantityAudit1);
        Assertions.assertEquals("Not much product available", notAvailable);
    }

    @Test
    public void wrongDetails()throws Exception{
        Mockito.when(productRepo.findById(productQuantityAudit4.getProductId())).thenReturn(Optional.of(product));
        String notFound = productQuantityAudit.addHistory(productQuantityAudit4);
        Assertions.assertEquals("No product exists in this id or there may be mistake in your details", notFound);
    }
}
