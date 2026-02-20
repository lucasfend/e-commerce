package com.ecommerce.shop.modules.inventory.dto.suppliesDTOs;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SuppliesRequest(
        @NotNull String name,
        @Min(0) double kilos,
        @Min(0) double price,
        @Min(0) double recipeUseInGrams,
        @NotNull LocalDate purchaseDate) {
}
