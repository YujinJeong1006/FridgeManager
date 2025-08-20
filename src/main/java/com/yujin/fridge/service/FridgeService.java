package com.yujin.fridge.service;

import com.yujin.fridge.aggregate.Ingredient;
import com.yujin.fridge.repository.IngredientRepository;

public class FridgeService {
    private final IngredientRepository ingredientRepository;

    public FridgeService() { ingredientRepository = new IngredientRepository(); }
}
