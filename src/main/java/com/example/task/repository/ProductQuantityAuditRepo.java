package com.example.task.repository;

import com.example.task.entity.ProductQuantityAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductQuantityAuditRepo extends MongoRepository<ProductQuantityAudit,String> {
    List<ProductQuantityAudit> findByProductId(String productId);
}
