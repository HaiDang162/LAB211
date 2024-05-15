/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Beverage extends Ingredient{
    private String beverage_ID;
    private String beverage_Name;
    private double beverage_Price;
    private String ingredient_Name_Of_Beverage;
    private List<Ingredient> ingredients;
    
    public Beverage(){}
    
    public Beverage(String beverage_ID, String beverage_Name, double beverage_Price, String ingredient_Name_Of_Beverage) {
        this.beverage_ID = beverage_ID;
        this.beverage_Name = beverage_Name;
        this.beverage_Price = beverage_Price;
        this.ingredient_Name_Of_Beverage = ingredient_Name_Of_Beverage;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public String getBeverage_ID() {
        return beverage_ID;
    }

    public void setBeverage_ID(String beverage_ID) {
        this.beverage_ID = beverage_ID;
    }

    public String getBeverage_Name() {
        return beverage_Name;
    }

    public void setBeverage_Name(String beverage_Name) {
        this.beverage_Name = beverage_Name;
    }

    public double getBeverage_Price() {
        return beverage_Price;
    }

    public void setBeverage_Price(double beverage_Price) {
        this.beverage_Price = beverage_Price;
    }

    public String getIngredient_Name_Of_Beverage() {
        return ingredient_Name_Of_Beverage;
    }

    public void setIngredient_Name_Of_Beverage(String ingredient_Name_Of_Beverage) {
        this.ingredient_Name_Of_Beverage = ingredient_Name_Of_Beverage;
    }
 
    @Override
    public String toString() {
        return beverage_ID + ", " + beverage_Name + ", " + beverage_Price + "\n" + "{" + ingredient_Name_Of_Beverage + "}\n";
    }
    
    
}
