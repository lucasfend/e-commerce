package com.ecommerce.shop.modules.inventory.dto.suppliesDTOs;

import jakarta.validation.constraints.NotNull;

public record RecipePayload(
        @NotNull String productName,
        @NotNull SuppliesRequestList dough,
        @NotNull SuppliesRequestList filling,
        @NotNull double grams,
        @NotNull double profitPercentage) {
}
