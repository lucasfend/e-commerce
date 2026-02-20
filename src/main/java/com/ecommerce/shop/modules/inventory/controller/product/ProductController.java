package com.ecommerce.shop.modules.inventory.controller.product;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductRequest;
import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductResponse;
import com.ecommerce.shop.modules.inventory.service.product.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("storage")
public class ProductController {

    private final ProductService service;

    @PostMapping("post")
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest payload) {
        return ResponseEntity.ok(service.save(payload));
    }

    @PutMapping("put")
    public ResponseEntity<Void> update(@RequestBody ProductRequest payload) {
        service.update(payload);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("get")
    public ResponseEntity<List<ProductResponse>> get() {
        return ResponseEntity.ok(service.getAll());
    }
}
