package com.example.task.service;

import com.example.task.entity.ProductQuantityAudit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductQuantityAuditService {
    String addHistory(ProductQuantityAudit productQuantityAudit);

    List<ProductQuantityAudit> getDetailsById(String productId);
}
