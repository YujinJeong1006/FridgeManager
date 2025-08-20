package com.yujin.fridge.aggregate;

import java.io.Serializable;
import java.time.LocalDate;

public class Ingredient implements Serializable {
    private int ingredientId;
    private String name;
    private int count;
    private Category category;
    private LocalDate expiryDate;

    public Ingredient() {
    }

    public Ingredient(String name, int count, Category category, LocalDate expiryDate) {
        this.name = name;
        this.count = count;
        this.category = category;
        this.expiryDate = expiryDate;
    }

    public Ingredient(int ingredientId, String name, int count, Category category, LocalDate expiryDate) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.count = count;
        this.category = category;
        this.expiryDate = expiryDate;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return  String.format("%-7s | %-5d | %s",
                name, count, expiryDate);
    }
}
