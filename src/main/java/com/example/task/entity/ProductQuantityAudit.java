package com.example.task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class ProductQuantityAudit {
    @Id
    private String auditId;
    private String productId;
    public Integer quanity;
    private String type;
    private Integer exisingQuantity;
    private Integer updatedQuantity;
}
