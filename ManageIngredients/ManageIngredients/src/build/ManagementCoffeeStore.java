/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ManagementCoffeeStore implements Serializable{
    private List<Ingredient> ingredients;
    private List<Beverage> menuCoffee;
    private List<Beverage> menuCoffeeOrder;
    
    public ManagementCoffeeStore(){
        ingredients = new ArrayList<>();
        menuCoffee = new ArrayList<>();
        menuCoffeeOrder = new ArrayList<>();
    }

    public ManagementCoffeeStore(List<Ingredient> ingredients, List<Beverage> menuCoffee, List<Beverage> menuCoffeeOrder) {
        this.ingredients = ingredients;
        this.menuCoffee = menuCoffee;
        this.menuCoffeeOrder = menuCoffeeOrder;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Beverage> getMenuCoffee() {
        return menuCoffee;
    }

    public void setMenuCoffee(List<Beverage> menuCoffee) {
        this.menuCoffee = menuCoffee;
    }

    public List<Beverage> getMenuCoffeeOrder() {
        return menuCoffeeOrder;
    }

    public void setMenuCoffeeOrder(List<Beverage> menuCoffeeOrder) {
        this.menuCoffeeOrder = menuCoffeeOrder;
    }
}
