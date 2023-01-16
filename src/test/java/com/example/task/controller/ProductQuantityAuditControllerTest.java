package com.example.task.controller;

import com.example.task.entity.ProductQuantityAudit;
import com.example.task.service.impl.ProductQuantityAuditImpl;
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
public class ProductQuantityAuditControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    ProductQuantityAuditController productQuantityAuditController;

    @InjectMocks
    ProductQuantityAuditImpl productQuantityAuditImpl;

    ProductQuantityAudit productQuantityAudit;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(productQuantityAuditController).build();
        productQuantityAudit = new ProductQuantityAudit("190290","003",100,"REFURBISH",45,100);
    }

    @Test
    public void saveQuantityAudit()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/history/update")
                .content(objectWriter.writeValueAsString(productQuantityAudit))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
