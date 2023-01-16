package com.example.task.controller;

import com.example.task.entity.Product;
import com.example.task.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @InjectMocks
  private  ProductController productController;


    Product product;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        product = new Product("004","Laptop",1500,15000.0f);
    }

    @Mock
    ProductServiceImpl productServiceImpl;
    @Test
    public void whenSaveProductThenReturnProduct()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/add")
                       .content(objectWriter.writeValueAsString(product))
                       .contentType(MediaType.APPLICATION_JSON))
                         .andExpect(status().isOk());
    }
}
