package com.leodev.calorii;

public class NutrientModel {


    private String food_name;
    private int serving_qty;
    private String serving_unit;
    private float calories;
    private float total_fat;
    private float saturated_fat;
    private float cholesterol;
    private float sodium;
    private float total_carbohydrate;
    private String sugars;
    private float protein;
    private float potassium;

    public NutrientModel(String food_name, int serving_qty, String serving_unit, float calories, float total_fat, float saturated_fat, float cholesterol, float sodium, float total_carbohydrate, String sugars, float protein, float potassium) {
        this.food_name = food_name;
        this.serving_qty = serving_qty;
        this.serving_unit = serving_unit;
        this.calories = calories;
        this.total_fat = total_fat;
        this.saturated_fat = saturated_fat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.total_carbohydrate = total_carbohydrate;
        this.sugars = sugars;
        this.protein = protein;
        this.potassium = potassium;
    }

    @Override
    public String toString() {
        return "\nFood Name: " + food_name + "\n" +
                "Serving Quantity: " + serving_qty + '\n' +
                "Serving Unit: " + serving_unit + '\n' +
                "Calories: " + calories +  '\n' +
                "Total Fat: " + total_fat + "g" +  '\n' +
                "Saturated Fat: " + saturated_fat + "g" + '\n' +
                "Cholesterol: " + cholesterol + "mg" +  '\n' +
                "Sodium: " + sodium + "mg" +  '\n' +
                "Total Carbohydrate: " + total_carbohydrate + "g" + '\n' +
                "Sugars: " + sugars + "g" +'\n' +
                "Protein: " + protein + "g" + '\n' +
                "Potassium: " + potassium + "mg" +  '\n';

    }

    public NutrientModel() {
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        food_name = food_name.substring(0,1).toUpperCase() + food_name.substring(1).toLowerCase();
        this.food_name = food_name;
    }


    public int getServing_qty() {
        return serving_qty;
    }

    public void setServing_qty(int serving_qty) {
        this.serving_qty = serving_qty;
    }

    public String getServing_unit() {
        return serving_unit;
    }

    public void setServing_unit(String serving_unit) {
        this.serving_unit = serving_unit;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(float total_fat) {
        this.total_fat = total_fat;
    }

    public float getSaturated_fat() {
        return saturated_fat;
    }

    public void setSaturated_fat(float saturated_fat) {
        this.saturated_fat = saturated_fat;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public float getTotal_carbohydrate() {
        return total_carbohydrate;
    }

    public void setTotal_carbohydrate(float total_carbohydrate) {
        this.total_carbohydrate = total_carbohydrate;
    }

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getPotassium() {
        return potassium;
    }

    public void setPotassium(float potassium) {
        this.potassium = potassium;
    }
}

