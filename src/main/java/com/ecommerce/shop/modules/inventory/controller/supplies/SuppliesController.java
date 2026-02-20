package com.ecommerce.shop.modules.inventory.controller.supplies;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.modules.inventory.dto.suppliesDTOs.RecipePayload;
import com.ecommerce.shop.modules.inventory.service.helper.FullCost;
import com.ecommerce.shop.modules.inventory.service.supplies.SuppliesPricingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("supply")
@RequiredArgsConstructor
public class SuppliesController {

    private final SuppliesPricingService service;

    @PostMapping
    public FullCost pricing(@RequestBody RecipePayload payload) {
        return service.priceMaker(payload);
    }
}
