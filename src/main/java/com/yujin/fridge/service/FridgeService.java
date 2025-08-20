package com.yujin.fridge.service;

import com.yujin.fridge.aggregate.Ingredient;
import com.yujin.fridge.repository.FridgeRepository;

import java.util.ArrayList;

public class FridgeService {
    private final FridgeRepository ingredientRepository;

    public FridgeService() { ingredientRepository = new FridgeRepository(); }

    public void findAllIngredients() {
        ArrayList<Ingredient> result = ingredientRepository.findAllIngredients();

        if(!result.isEmpty()) {
            System.out.println("\n-----------------------------------");
            System.out.printf("%-7s | %-5s | %s", "이름", "수량", "유통/소비기한\n");
            System.out.println("----------+-------+----------------");
            for(Ingredient ingredient : result) {
                System.out.println(ingredient);
            }
            System.out.println();
        } else {
            System.out.println("냉장고가 텅텅 비었습니다.");
        }
    }
}
