package com.example.task.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    private String productId;
    private String productName;
    private Integer existingQuantity;
    private Float price;
}
