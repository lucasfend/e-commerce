package com.ecommerce.shop.modules.inventory.dto.productDTOs;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotNull String name,
        @Min(0) int price,
        @Min(0) int stockQuantity,
        @Min(0) int grams,
        @Min(0) int packageQuantity,
        @NotNull boolean isFrozen,
        @NotNull LocalDate expirationDate) {
}
