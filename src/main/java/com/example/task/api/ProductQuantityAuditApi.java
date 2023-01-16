package com.example.task.api;

import com.example.task.entity.ProductQuantityAudit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/history")
public interface ProductQuantityAuditApi {
    @PostMapping("/update")
    public String addHistory(@RequestBody ProductQuantityAudit productQuantityAudit);

    @GetMapping("/details/{productId}")
    public List<ProductQuantityAudit> displayDetailsByProductId(@PathVariable String productId);
}
