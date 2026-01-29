package com.ecommerce.shop.modules.storage.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ecommerce.shop.modules.storage.domain.Product;
import com.ecommerce.shop.modules.storage.dto.ProductRequest;
import com.ecommerce.shop.modules.storage.dto.ProductResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product toProductFromResponse(ProductResponse response);

    Product toProductFromRequest(ProductRequest request);

    ProductResponse toProductResponse(Product product);

    ProductRequest toProductRequest(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}
