package com.yujin.fridge.repository;

import com.yujin.fridge.aggregate.Category;
import com.yujin.fridge.aggregate.Ingredient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FridgeRepository {
    private final ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private final File file =
            new File("src/main/java/com/yujin/fridge/db/fridgeDB.dat");

    public FridgeRepository() {
        if(!file.exists()) {
            ArrayList<Ingredient> defaultIngredientList = new ArrayList<>();
            defaultIngredientList.add(new Ingredient(1,"양파", 3, Category.VEGETABLE, LocalDate.of(2025, 8, 30)));
            defaultIngredientList.add(new Ingredient(2,"닭가슴살", 5, Category.MEAT, LocalDate.of(2025, 8, 27)));
            defaultIngredientList.add(new Ingredient(3,"계란", 12, Category.DAIRY, LocalDate.of(2025, 9, 1)));

            saveIngredients(defaultIngredientList);
        }

        loadIngredients();
    }

    private void loadIngredients() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (true) {
                ingredientList.add((Ingredient) ois.readObject());
            }
        } catch (EOFException e){
            System.out.println("냉장고 재료 읽기 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveIngredients(ArrayList<Ingredient> ingredients) {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for(Ingredient ingredient : ingredients) {
                oos.writeObject(ingredient);
            }
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

    public ArrayList<Ingredient> findAllIngredients() {
        ArrayList<Ingredient> returnList = new ArrayList<>();
        for(Ingredient ingredient : ingredientList) {
            returnList.add(ingredient);
        }
        return returnList;
    }

    public Ingredient findIngredientByName(String s) {
        for(Ingredient ingredient : ingredientList) {
            if(ingredient.getName().equals(s)) {
                return ingredient;
            }
        }
        return null;
    }
}
