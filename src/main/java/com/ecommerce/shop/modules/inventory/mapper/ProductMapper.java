package com.ecommerce.shop.modules.inventory.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ecommerce.shop.modules.inventory.domain.Product;
import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductRequest;
import com.ecommerce.shop.modules.inventory.dto.productDTOs.ProductResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product toProductFromResponse(ProductResponse product);

    Product toProductFromRequest(ProductRequest product);

    ProductResponse toProductResponse(Product product);

    ProductRequest toProductRequest(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}
