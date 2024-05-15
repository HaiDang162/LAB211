/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import build.ManagementCoffeeStore;
import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MenuLogic {
    Scanner sc = new Scanner(System.in);
    Control control = new Control();
    Menu menu = new Menu();
    
    public int EnterChoices () {
       int choice = Control.inputInt("Choose a number: ");
       return choice;
    }
    
    public void Manage_Ingredients_Menu(){
        ManagementCoffeeStore managementCoffeeStore = new ManagementCoffeeStore();
        managementCoffeeStore = Function.loadData(managementCoffeeStore);
        boolean isManage_Ingredient_Menu = true;
        while (isManage_Ingredient_Menu) {   
            menu.ManageIngredient();
            switch(EnterChoices()){
                case 1:
                    managementCoffeeStore = Function.addIngredient(managementCoffeeStore);
                    break;
                case 2:
                    managementCoffeeStore = Function.updateIngredient(managementCoffeeStore);
                    break;
                case 3:
                    managementCoffeeStore = Function.deleteIngredient(managementCoffeeStore);
                    break;
                case 4:
                    Function.showIngredient(managementCoffeeStore);
                    break;
                case 0:
                    isManage_Ingredient_Menu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[4]");
                    break;
            }   
        }
    }
    
    public void  Manage_Beverage_Recipes_Menu(){
        ManagementCoffeeStore managementCoffeeStore = new ManagementCoffeeStore();
        managementCoffeeStore = Function.loadData(managementCoffeeStore);
        boolean isManage_Beverage_Recipes_Menu = true;
        while (isManage_Beverage_Recipes_Menu) {   
            menu.Manage_Beverage_Recipes();
            switch(EnterChoices()){
                case 1:
                    managementCoffeeStore = Function.addBeverage(managementCoffeeStore);
                    break;
                case 2:
                    managementCoffeeStore = Function.updateBeverage(managementCoffeeStore);
                    break;
                case 3:
                    managementCoffeeStore = Function.deleteBeverage(managementCoffeeStore);
                    break;
                case 4:
                    Function.showBeverage(managementCoffeeStore);
                    break;
                case 0:
                    isManage_Beverage_Recipes_Menu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[4]");
                    break;
            }  
        }
    }
    
    public void Dispensing_Beverage_Menu(){
        ManagementCoffeeStore managementCoffeeStore = new ManagementCoffeeStore();
        managementCoffeeStore = Function.loadData(managementCoffeeStore);
        boolean isDispensing_Beverage_Menu = true;
        while (isDispensing_Beverage_Menu) {   
            menu.Dispensing_Beverages();
            switch(EnterChoices()){
                case 1:
                    managementCoffeeStore = Function.beverageOrder(managementCoffeeStore);
                    break;
                case 2:
                    
                    break;
                case 0:
                    isDispensing_Beverage_Menu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[2]");
                    break;
            }  
        }  
    }
    
    public void Report_Menu(){
        ManagementCoffeeStore managementCoffeeStore = new ManagementCoffeeStore();
        managementCoffeeStore = Function.loadData(managementCoffeeStore);
        boolean isReport_Menu = true;
        while (isReport_Menu) {   
            menu.Report();
            switch(EnterChoices()){
                case 1:
                    managementCoffeeStore = Function.ingredientAvailable(managementCoffeeStore);
                    break;
                case 2:
                    managementCoffeeStore = Function.beverage_Out_Of_Ingredient(managementCoffeeStore);
                    break;
                case 3:
                    Function.showBeverageOrder(managementCoffeeStore);
                    break;
                case 0:
                    isReport_Menu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[2]");
                    break;
            }  
        }
    }
    
    public void MainMenu(){
        boolean isMainMenu = true;
        while (isMainMenu) {
            menu.MainMenu();
            switch(EnterChoices()){
                case 1:
                    Manage_Ingredients_Menu();
                    break;
                case 2:
                    Manage_Beverage_Recipes_Menu();
                    break;
                case 3:
                    Dispensing_Beverage_Menu();
                    break;
                case 4:
                    Report_Menu();
                    break;
                case 0:
                    isMainMenu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[4]");
                    break;
            } 
        }
    }
}
