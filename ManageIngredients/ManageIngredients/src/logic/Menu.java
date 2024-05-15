/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Lenovo
 */
public class Menu {
    public void MainMenu(){
        System.out.println("====== Management Coffee Store ======");
        System.out.println("[1] Manage ingredients.");
        System.out.println("[2] Manage beverage recipes.");
        System.out.println("[3] Dispensing beverages.");
        System.out.println("[4] Report.");
        System.out.println("[0] Exit.");
        System.out.println("=====================================");
    }
    
    public void ManageIngredient(){
        System.out.println("========= Manage Ingredients ==========");
        System.out.println("[1] Add an ingredient.");
        System.out.println("[2] Update ingredient information.");
        System.out.println("[3] Delete ingredient.");
        System.out.println("[4] Show all ingredients.");
        System.out.println("[0] Back to Main Menu.");
        System.out.println("======================================");
    }
    
    public void Manage_Beverage_Recipes(){
        System.out.println("============ Manage Beverage Recipes ===========");
        System.out.println("[1] Add the drink to menu.");
        System.out.println("[2] Update the drink information.");
        System.out.println("[3] Delete the drink from menu.");
        System.out.println("[4] Show menu.");
        System.out.println("[0] Back to Main Menu.");
        System.out.println("===============================================");
    }
    
    public void  Dispensing_Beverages(){
        System.out.println("=========== Dispensing Beverages ===========");
        System.out.println("[1] Dispensing the drink.");
        System.out.println("[2] Update the dispensing drink.");
        System.out.println("[0] Back to Main Menu.");
        System.out.println("============================================");
    }
    
    public void Report(){
        System.out.println("=============================== Report ============================");
        System.out.println("[1] The ingredients are available.");
        System.out.println("[2] The drinks for which the store is out of ingredients.");
        System.out.println("[3] Show all the dispensing drink.");
        System.out.println("[0] Back to Main Menu.");
        System.out.println("==================================================================");
    }
}

