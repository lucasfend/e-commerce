package com.ecommerce.shop.modules.inventory.dto.suppliesDTOs;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record SuppliesRequestList(
        @NotNull List<SuppliesRequest> supplies) {
}
