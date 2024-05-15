/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build;

import java.util.Date;
import logic.Control;

/**
 *
 * @author Lenovo
 */
public class Ingredient {
    private String ingredient_ID;
    private String ingredient_Name;
    private double ingredient_Available_Quantity;
    private String ingredient_Unit; 
    private double ingredient_Price;
    private Date   ingredient_Date_Of_Manufacture; // NXS
    private Date   ingredient_Expiration_Date; // HSD

    public Ingredient() {
    }

    public Ingredient(String ingredient_ID, String ingredient_Name, double ingredient_Available_Quantity, String ingredient_Unit, double ingredient_Price, Date ingredient_Date_Of_Manufacture, Date ingredient_Expiration_Date) {
        this.ingredient_ID = ingredient_ID;
        this.ingredient_Name = ingredient_Name;
        this.ingredient_Available_Quantity = ingredient_Available_Quantity;
        this.ingredient_Unit = ingredient_Unit;
        this.ingredient_Price = ingredient_Price;
        this.ingredient_Date_Of_Manufacture = ingredient_Date_Of_Manufacture;
        this.ingredient_Expiration_Date = ingredient_Expiration_Date;
    }

    public String getIngredient_ID() {
        return ingredient_ID;
    }

    public void setIngredient_ID(String ingredient_ID) {
        this.ingredient_ID = ingredient_ID;
    }

    public String getIngredient_Name() {
        return ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        this.ingredient_Name = ingredient_Name;
    }

    public double getIngredient_Available_Quantity() {
        return ingredient_Available_Quantity;
    }

    public void setIngredient_Available_Quantity(double ingredient_Available_Quantity) {
        this.ingredient_Available_Quantity = ingredient_Available_Quantity;
    }

    public String getIngredient_Unit() {
        return ingredient_Unit;
    }

    public void setIngredient_Unit(String ingredient_Unit) {
        this.ingredient_Unit = ingredient_Unit;
    }
    
    public double getIngredient_Price() {
        return ingredient_Price;
    }

    public void setIngredient_Price(double ingredient_Price) {
        this.ingredient_Price = ingredient_Price;
    }
    
    public Date getIngredient_Date_Of_Manufacture() {
        return ingredient_Date_Of_Manufacture;
    }

    public void setIngredient_Date_Of_Manufacture(Date ingredient_Date_Of_Manufacture) {
        this.ingredient_Date_Of_Manufacture = ingredient_Date_Of_Manufacture;
    }

    public Date getIngredient_Expiration_Date() {
        return ingredient_Expiration_Date;
    }

    public void setIngredient_Expiration_Date(Date ingredient_Expiration_Date) {
        this.ingredient_Expiration_Date = ingredient_Expiration_Date;
    }

    @Override
    public String toString() {
        return ingredient_ID + ", " + ingredient_Name + ", " + ingredient_Available_Quantity + ", " + ingredient_Unit 
                +", " + ingredient_Price + ", " + Control.formatDateToString(ingredient_Expiration_Date) + ", " +Control.formatDateToString(ingredient_Expiration_Date);
    }
    
}
