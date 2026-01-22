package com.ecommerce.shop.modules.storage.dto;

import java.time.LocalDate;

public record ProductResponse(
        String name,
        int price,
        int stockQuantity,
        int grams,
        int packageQuantity,
        boolean isFrozen,
        LocalDate expiration_date) {
}
