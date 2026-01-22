package com.ecommerce.shop.modules.storage.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.shop.modules.storage.domain.Product;
import com.ecommerce.shop.modules.storage.dto.ProductRequest;
import com.ecommerce.shop.modules.storage.mapper.ProductMapper;
import com.ecommerce.shop.modules.storage.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Product save(ProductRequest request) {
        Product payloadObject = mapper.toProductFromRequest(request);

        return repository.save(payloadObject);
    }

    public void update(ProductRequest request) {
        Product payloadObject = mapper.toProductFromRequest(request);

        Optional<Product> productOpt = repository.findByName(payloadObject.getName());

        if (productOpt.isPresent()) {
            Product existingProduct = productOpt.get();

            existingProduct.setName(payloadObject.getName());
            existingProduct.setPrice(payloadObject.getPrice());
            existingProduct.setStockQuantity(payloadObject.getStockQuantity());
            existingProduct.setIsFrozen(payloadObject.getIsFrozen());
            existingProduct.setExpiration_date(payloadObject.getExpiration_date());
            existingProduct.setGrams(payloadObject.getGrams());
            existingProduct.setPackageQuantity(payloadObject.getPackageQuantity());

        } else {
            throw new RuntimeException();
        }
    }

    public void delete(ProductRequest request) {
        repository.deleteById(mapper.toProductFromRequest(request).getId());
    }

}
