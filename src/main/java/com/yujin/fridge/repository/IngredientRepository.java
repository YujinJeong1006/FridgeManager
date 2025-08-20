package com.yujin.fridge.repository;

import com.yujin.fridge.aggregate.Category;
import com.yujin.fridge.aggregate.Ingredient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class IngredientRepository {
    private final ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private final File file =
            new File("src/main/java/com/yujin/fridge/db/fridgeDB.dat");

    public IngredientRepository() {
        if(!file.exists()) {
            ArrayList<Ingredient> defaultIngredientList = new ArrayList<>();
            defaultIngredientList.add(new Ingredient(1,"양파", 3, Category.VEGETABLE, LocalDate.of(2025, 8, 30)));
            defaultIngredientList.add(new Ingredient(2,"닭가슴살", 5, Category.MEAT, LocalDate.of(2025, 8, 27)));
            defaultIngredientList.add(new Ingredient(3,"계란", 12, Category.DAIRY, LocalDate.of(2025, 9, 1)));

            saveIngredients(defaultIngredientList);

        }
    }

    private void saveIngredients(ArrayList<Ingredient> ingredients) {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
