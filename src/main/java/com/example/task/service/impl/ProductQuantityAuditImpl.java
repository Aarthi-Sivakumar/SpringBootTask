package com.example.task.service.impl;

import com.example.task.entity.Product;
import com.example.task.entity.ProductQuantityAudit;
import com.example.task.repository.ProductQuantityAuditRepo;
import com.example.task.repository.ProductRepo;
import com.example.task.service.ProductQuantityAuditService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQuantityAuditImpl implements ProductQuantityAuditService {
    ProductQuantityAuditRepo productQuantityAuditRepo;
    ProductRepo productRepo;

    public ProductQuantityAuditImpl(ProductQuantityAuditRepo productQuantityAuditRepo, ProductRepo productRepo) {
        this.productQuantityAuditRepo = productQuantityAuditRepo;
        this.productRepo = productRepo;
    }

    @Override
    public String addHistory(ProductQuantityAudit productQuantityAudit) {
        Optional<Product> byId = productRepo.findById(productQuantityAudit.getProductId());
        if(byId.isPresent()) {
            ProductQuantityAudit update = new ProductQuantityAudit();
            switch (productQuantityAudit.getType()) {
                case "CONSUME":
                    if(byId.get().getExistingQuantity()<productQuantityAudit.getQuanity()){
                        return "Not much product available";
                    }
                    update.setProductId(productQuantityAudit.getProductId());
                    update.setQuanity(productQuantityAudit.getQuanity());
                    update.setType(productQuantityAudit.getType());
                    update.setExisingQuantity(byId.get().getExistingQuantity());
                    update.setUpdatedQuantity(byId.get().getExistingQuantity()-productQuantityAudit.getQuanity());
                    byId.get().setExistingQuantity(byId.get().getExistingQuantity() - productQuantityAudit.getQuanity());
                    productRepo.save(byId.get());
                    productQuantityAuditRepo.save(update);
                    return "Update after type : " + productQuantityAudit.getType();
                case "APPEND":
                    update.setProductId(productQuantityAudit.getProductId());
                    update.setQuanity(productQuantityAudit.getQuanity());
                    update.setType(productQuantityAudit.getType());
                    update.setExisingQuantity(byId.get().getExistingQuantity());
                    update.setUpdatedQuantity(productQuantityAudit.getQuanity() + byId.get().getExistingQuantity());
                    byId.get().setExistingQuantity(byId.get().getExistingQuantity() + productQuantityAudit.getQuanity());
                    productRepo.save(byId.get());
                    productQuantityAuditRepo.save(update);
                    return "Update after type : " + productQuantityAudit.getType();
                case "REFURBISH":
                    update.setProductId(productQuantityAudit.getProductId());
                    update.setQuanity(productQuantityAudit.getQuanity());
                    update.setType(productQuantityAudit.getType());
                    update.setExisingQuantity(byId.get().getExistingQuantity());
                    update.setUpdatedQuantity(productQuantityAudit.getQuanity());
                    byId.get().setExistingQuantity(productQuantityAudit.getQuanity());
                    productRepo.save(byId.get());
                    productQuantityAuditRepo.save(update);
                    return "Update after type : " + productQuantityAudit.getType();
            }
        }
        return "No product exists in this id or there may be mistake in your details";
    }

    @Override
    public List<ProductQuantityAudit> getDetailsById(String productId) {
        List<ProductQuantityAudit> byId = productQuantityAuditRepo.findByProductId(productId);
        return byId;
    }
}
