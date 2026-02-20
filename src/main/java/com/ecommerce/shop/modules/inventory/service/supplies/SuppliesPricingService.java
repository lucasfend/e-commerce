package com.ecommerce.shop.modules.inventory.service.supplies;

import org.springframework.stereotype.Service;

import com.ecommerce.shop.modules.inventory.dto.suppliesDTOs.RecipePayload;
import com.ecommerce.shop.modules.inventory.dto.suppliesDTOs.SuppliesRequest;
import com.ecommerce.shop.modules.inventory.dto.suppliesDTOs.SuppliesRequestList;
import com.ecommerce.shop.modules.inventory.service.helper.FullCost;
import com.ecommerce.shop.modules.inventory.service.helper.RecipeObject;

@Service
public class SuppliesPricingService {

    private static final double WATER_QUANTITY_PER_RECIPE = 1675;
    private static final double DOUGH_PERCENTAGE = 0.7;
    private static final double FILLING_PERCENTAGE = 0.3;
    private static final double OPERATIONAL_COST_PERCENTAGE = 0.2;

    public FullCost priceMaker(RecipePayload payload) {
        RecipeObject doughData = priceTaker(payload.dough(), true);
        RecipeObject fillingData = priceTaker(payload.filling(), false);

        double doughPerUnit = payload.grams() * DOUGH_PERCENTAGE;
        double fillingPerUnit = payload.grams() * FILLING_PERCENTAGE;

        double costDough = doughData.unitPrice() * doughPerUnit;
        System.out.println("Preco unit. massa apenas -> " + costDough);

        double costFilling = fillingData.unitPrice() * fillingPerUnit;
        System.out.println("Preco unit. recheio apenas -> " + costFilling);

        double finalCostProdPerUnit = (costDough + costFilling)
                + ((costDough + costFilling) * OPERATIONAL_COST_PERCENTAGE);

        System.out.println("Custo sem profit ainda -> " + finalCostProdPerUnit);

        double finalCostWithProfit = finalCostProdPerUnit + .2
                + (finalCostProdPerUnit * (payload.profitPercentage() / 100));
        System.out.println("Custo com 150% de profit -> " + finalCostWithProfit);

        return new FullCost(finalCostWithProfit, (finalCostWithProfit * 100));
    }

    public RecipeObject priceTaker(SuppliesRequestList list, boolean isDough) {
        double priceOfSupplyPerRecipe = 0;
        double yield = 0;

        for (SuppliesRequest supply : list.supplies()) {
            double valuePerKilo = supply.price() / (double) supply.kilos();

            priceOfSupplyPerRecipe += valuePerKilo * (supply.recipeUseInGrams() / 1000.0);

            if (isDough) {

                if (supply.name().equalsIgnoreCase("farinha")) {
                    double waterAmount = (supply.recipeUseInGrams() / 1000.0) * WATER_QUANTITY_PER_RECIPE;

                    yield += supply.recipeUseInGrams() + waterAmount;

                    System.out.println("calculando farinha peso -> " + String.format("$%.2f", yield));
                }
            } else {
                yield += supply.recipeUseInGrams();
                System.out.println("calculando recheio peso -> " + yield);
            }
        }

        System.out.println("Preco por grama " + priceOfSupplyPerRecipe / yield * 15.0);

        return new RecipeObject(priceOfSupplyPerRecipe, yield, priceOfSupplyPerRecipe / yield);
    }
}
