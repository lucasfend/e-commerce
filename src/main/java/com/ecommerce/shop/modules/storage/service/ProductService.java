package com.ecommerce.shop.modules.storage.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.shop.modules.storage.domain.Product;
import com.ecommerce.shop.modules.storage.dto.ProductRequest;
import com.ecommerce.shop.modules.storage.dto.ProductResponse;
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

    public List<ProductResponse> getAll() {
        List<Product> allProducts = repository.findAll();
        return (mapper.toResponseList(allProducts));
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
            existingProduct.setExpirationDate(payloadObject.getExpirationDate());
            existingProduct.setGrams(payloadObject.getGrams());
            existingProduct.setPackageQuantity(payloadObject.getPackageQuantity());

        } else {
            throw new RuntimeException();
        }
    }

    public void delete(UUID payloadId) {
        repository.deleteById(payloadId);
    }

}
