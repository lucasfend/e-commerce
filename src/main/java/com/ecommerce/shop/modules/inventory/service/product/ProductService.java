package com.ecommerce.shop.modules.inventory.service.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.shop.modules.inventory.domain.Product;
import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductRequest;
import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductResponse;
import com.ecommerce.shop.modules.inventory.mapper.ProductMapper;
import com.ecommerce.shop.modules.inventory.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse save(ProductRequest request) {
        Product payloadObject = mapper.toProductFromRequest(request);
        repository.save(payloadObject);

        return mapper.toProductResponse(payloadObject);
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

            System.out.println("Product " + payloadObject.getName() + " successfully updated");

        } else {
            System.out.println("Product not found.");
        }
    }

    public void delete(UUID payloadId) {
        repository.deleteById(payloadId);
    }

}
