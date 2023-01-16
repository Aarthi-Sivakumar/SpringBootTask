package com.example.task.controller;

import com.example.task.api.ProductQuantityAuditApi;
import com.example.task.entity.ProductQuantityAudit;
import com.example.task.service.ProductQuantityAuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductQuantityAuditController implements ProductQuantityAuditApi {

    ProductQuantityAuditService productQuantityAuditService;

    public ProductQuantityAuditController(ProductQuantityAuditService productQuantityAuditService) {
        this.productQuantityAuditService = productQuantityAuditService;
    }

    @Override
    public String addHistory(ProductQuantityAudit productQuantityAudit) {
        return productQuantityAuditService.addHistory(productQuantityAudit);
    }

    @Override
    public List<ProductQuantityAudit> displayDetailsByProductId(String productId) {
        return productQuantityAuditService.getDetailsById(productId);
    }
}
