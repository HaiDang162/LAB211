/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import build.Ingredient;
import build.ManagementCoffeeStore;
import build.Beverage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;

/**
 *
 * @author Lenovo
 */
public class Function {

    public static ManagementCoffeeStore loadData(ManagementCoffeeStore managementCoffeeStore) {
        managementCoffeeStore.setIngredients(loadIngredient());
        managementCoffeeStore.setMenuCoffee(loadBeverage());
        managementCoffeeStore.setMenuCoffeeOrder(loadBeverage());
        return managementCoffeeStore;
    }

    public static List<Ingredient> loadIngredient() {
        List<Ingredient> ingredienlist = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src//data/Ingredients.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] compenents = line.split(",");
                if (compenents.length == 7) {
                    String ingredient_ID = compenents[0].trim();
                    String ingredient_Name = compenents[1].trim();
                    double ingredient_Available_Quantity = Double.parseDouble(compenents[2].trim());
                    String ingredient_Unit = compenents[3].trim();
                    double ingredient_Price = Double.parseDouble(compenents[4].trim());
                    Date ingredient_Date_Of_Manufacture = Control.dateParse(compenents[5].trim());
                    Date ingredient_Expiration_Date = Control.dateParse(compenents[6].trim());
                    ingredienlist.add(new Ingredient(ingredient_ID, ingredient_Name, ingredient_Available_Quantity, ingredient_Unit, ingredient_Price,
                            ingredient_Date_Of_Manufacture, ingredient_Expiration_Date));
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return ingredienlist;
    }

    public static List<Beverage> loadBeverage() {
        List<Beverage> menuCoffee = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src//data//Menu.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] compenents = line.split(",");
                if (compenents.length <= 100) {
                    String beverage_ID = compenents[0].trim();
                    String beverage_Name = compenents[1].trim();
                    double beverage_Price = Double.parseDouble(compenents[2].trim());
                    String ingredient_Name_Of_Beverage = compenents[3].trim();
                    menuCoffee.add(new Beverage(beverage_ID, beverage_Name, beverage_Price, ingredient_Name_Of_Beverage));
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return menuCoffee;
    }

    public static void saveData(ManagementCoffeeStore managementCoffeeStore) {
        saveIngredient(managementCoffeeStore.getIngredients());
        saveMenuCoffee(managementCoffeeStore.getMenuCoffee());
        saveMenuCoffeeOrder(managementCoffeeStore.getMenuCoffeeOrder());
    }

    public static void saveMenuCoffee(List<Beverage> menuCoffee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//Menu.dat", false))) {
            for (Beverage beverage : menuCoffee) {
                writer.write(beverage.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void saveMenuCoffeeOrder(List<Beverage> menuCoffeeOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//Order.dat", false))) {
            for (Beverage beverage : menuCoffeeOrder) {
                writer.write(beverage.getBeverage_ID() + ", " + beverage.getBeverage_Name() + ", " + beverage.getBeverage_Price());
                writer.newLine();
                for (Ingredient ingredient : beverage.getIngredients()) {
                    writer.write(ingredient.getIngredient_ID() + ", " + ingredient.getIngredient_Name() + ", " + ingredient.getIngredient_Available_Quantity() + ", " + ingredient.getIngredient_Unit() + ", " + ingredient.getIngredient_Price());
                    writer.newLine();
                }
                writer.write("------"); // Separator between beverages
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void saveIngredient(List<Ingredient> ingredients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//Ingredients.dat", false))) {
            for (Ingredient ingredient : ingredients) {
                writer.write(ingredient.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void saveDeleteIngredient(Ingredient deleteIngredient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//DeleteIngredient.dat", true))) {
            writer.write(deleteIngredient.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void saveDeleteBbeverage(Beverage deleteBeverage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//DeleteBeverage.dat", true))) {
            writer.write(deleteBeverage.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static ManagementCoffeeStore addIngredient(ManagementCoffeeStore managementCoffeeStore) {
        Scanner sc = new Scanner(System.in);
        boolean continueAdding = true;
        do {
            String id_Ingredient = Control.inputxIngredientID(managementCoffeeStore.getIngredients());
            String name_Ingredient = Control.inputString("Input Ingredient Name: ");
            double ingredient_Available_Quantity = Control.inputDouble("Input Ingredient Available Quantity: ");
            String ingredient_Unit = Control.inputString("Input Ingredient Unit: ");
            double ingridient_Price = Control.inputDouble("Input Ingredient Price: ");
            Date ingredient_Date_Of_Manufacture = Control.inputDate("Input Ingredient Date of Manufacture: ");
            Date ingredient_Expiration_Date = Control.inputDate("Input Ingredient Expiration Date: ");
            List<Ingredient> ingredient = managementCoffeeStore.getIngredients();
            ingredient.add(new Ingredient(id_Ingredient, name_Ingredient, ingredient_Available_Quantity, ingredient_Unit, ingridient_Price,
                    ingredient_Date_Of_Manufacture, ingredient_Expiration_Date));
            managementCoffeeStore.setIngredients(ingredient);
            saveData(managementCoffeeStore);
            System.out.println("Add Ingredient Successfully. ");
            System.out.print("Do you want to continue adding Ingredient (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            continueAdding = choice.equals("Y");
        } while (continueAdding);
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore updateIngredient(ManagementCoffeeStore managementCoffeeStore) {
        String id_Ingredient = Control.inputIngredientID(managementCoffeeStore.getIngredients());
        if (id_Ingredient != null) {
            List<Ingredient> ingredients = managementCoffeeStore.getIngredients();
            boolean found = true;
            for (int i = 0; i < ingredients.size(); i++) {
                if (ingredients.get(i).getIngredient_ID().equals(id_Ingredient)) {
                    Ingredient ingredient = ingredients.get(i);

                    String name_Ingredient = Control.updateInputString("Input Ingredient Name (" + ingredient.getIngredient_Name() + "): ", ingredient.getIngredient_Name());
                    ingredient.setIngredient_Name(name_Ingredient);

                    double ingredient_Available_Quantity = Control.updateInputDouble("Input Ingredient Available Quantity (" + ingredient.getIngredient_Available_Quantity() + "): ", ingredient.getIngredient_Available_Quantity());
                    ingredient.setIngredient_Available_Quantity(ingredient_Available_Quantity);

                    String ingredient_Unit = Control.updateInputString("Input Ingredient Unit (" + ingredient.getIngredient_Unit() + "): ", ingredient.getIngredient_Unit());
                    ingredient.setIngredient_Unit(ingredient_Unit);

                    double ingredient_Price = Control.updateInputDouble("Input Ingredient Price (" + ingredient.getIngredient_Price() + "): ", ingredient.getIngredient_Price());
                    ingredient.setIngredient_Price(ingredient_Price);

                    Date ingredient_Date_Of_Manufacture = Control.updateInputDate("Input Ingredient Date of Manufacture (" + ingredient.getIngredient_Date_Of_Manufacture() + "): ", ingredient.getIngredient_Date_Of_Manufacture());
                    ingredient.setIngredient_Date_Of_Manufacture(ingredient_Date_Of_Manufacture);

                    Date ingredient_Expiration_Date = Control.updateInputDate("Input Ingredient Expiration Date (" + ingredient.getIngredient_Expiration_Date() + "): ", ingredient.getIngredient_Expiration_Date());
                    ingredient.setIngredient_Expiration_Date(ingredient_Expiration_Date);
                    ingredients.set(i, ingredient);
                    break;
                }
            }
            if (found) {
                managementCoffeeStore.setIngredients(ingredients);
                saveData(managementCoffeeStore);
                System.out.println("Update Ingredient Successfully.");
            } else {
                System.out.println("Update Ingredient Fail.");
            }
        }
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore deleteIngredient(ManagementCoffeeStore managementCoffeeStore) {
        String ingredient_ID = Control.inputIngredientID(managementCoffeeStore.getIngredients());
        List<Ingredient> ingredients = managementCoffeeStore.getIngredients();
        boolean found = false;
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getIngredient_ID().equals(ingredient_ID)) {
                Ingredient deleleIngredient = ingredients.remove(i);
                saveDeleteIngredient(deleleIngredient);
                saveData(managementCoffeeStore);
                System.out.println("Delete Ingredient Success");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Delete Ingredient Fail.");
        }

        return managementCoffeeStore;
    }

    public static void showIngredient(ManagementCoffeeStore managementCoffeeStore) {
        List<Ingredient> ingredients = new ArrayList<>(managementCoffeeStore.getIngredients());
        System.out.printf("%-15s | %-30s | %-30s | %-15s | %-20s | %-30s | %-25s%n", "Ingredient ID",
                "Ingredient Name", "Ingredient Available Quantity", "Ingredient Unit", "Ingredient Price", "Ingredient Date Of Manufacture", "Ingredient Expiration Date");
        Collections.sort(ingredients, (ingredeint1, ingredient2) -> ingredeint1.getIngredient_Name().compareTo(ingredient2.getIngredient_Name()));
        for (Ingredient ingredient : ingredients) {
            System.out.printf("%-15s | %-30s | %-30s | %-15s | %-20s | %-30s | %-25s%n",
                    ingredient.getIngredient_ID(), ingredient.getIngredient_Name(), ingredient.getIngredient_Available_Quantity(), ingredient.getIngredient_Unit(),
                     ingredient.getIngredient_Price(), Control.formatDateToString(ingredient.getIngredient_Date_Of_Manufacture()), Control.formatDateToString(ingredient.getIngredient_Expiration_Date()));
        }
    }

    public static ManagementCoffeeStore addBeverage(ManagementCoffeeStore managementCoffeeStore) {
        Scanner sc = new Scanner(System.in);
        boolean continueAdding = true;
        do {
            String beverage_ID = Control.inputxBeverageID(managementCoffeeStore.getMenuCoffee());
            String beverage_Name = Control.inputString("Input Beverage Name: ");
            double beverage_Price = Control.inputDouble("Input Beverage Price: ");
            String ingredient_Name_Of_Beverage = Control.inputString("Input Ingredient Name: ");
            List<Beverage> beverages = managementCoffeeStore.getMenuCoffee();
            beverages.add(new Beverage(beverage_ID, beverage_Name, beverage_Price, ingredient_Name_Of_Beverage));
            managementCoffeeStore.setMenuCoffee(beverages);
            saveData(managementCoffeeStore);
            System.out.println("Add Beverage Successfully.");
            System.out.print("Do you want to continue adding Beverage (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            continueAdding = choice.equals("Y");
        } while (continueAdding);
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore updateBeverage(ManagementCoffeeStore managementCoffeeStore) {
        String id_Beverage = Control.inputBeverageID(managementCoffeeStore.getMenuCoffee());
        if (id_Beverage != null) {
            List<Beverage> beverages = managementCoffeeStore.getMenuCoffee();
            boolean found = false;
            for (int i = 0; i < beverages.size(); i++) {
                if (beverages.get(i).getBeverage_Name().equals(id_Beverage)) {
                    Beverage beverage = beverages.get(i);

                    String name_Beverage = Control.updateInputString("Input Beverage Name (" + beverage.getBeverage_Name() + "): ", beverage.getBeverage_Name());
                    beverage.setBeverage_Name(name_Beverage);

                    double beverage_Price = Control.updateInputDouble("Input Beverage Price (" + beverage.getBeverage_Price() + "): ", beverage.getBeverage_Price());
                    beverage.setBeverage_Price(beverage_Price);

                    String name_Ingredient_Of_Beverage = Control.updateInputString("Input Ingredient Name (" + beverage.getIngredient_Name_Of_Beverage() + "): ", beverage.getIngredient_Name_Of_Beverage());
                    beverage.setIngredient_Name_Of_Beverage(name_Ingredient_Of_Beverage);
                    beverages.set(i, beverage);
                    break;
                }
            }
            if (found) {
                managementCoffeeStore.setMenuCoffee(beverages);
                saveData(managementCoffeeStore);
                System.out.println("Update Beverage Successfully.");
            } else {
                System.out.println("Update Beverage Fail.");
            }
        }
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore deleteBeverage(ManagementCoffeeStore managementCoffeeStore) {
        String beverage_ID = Control.inputBeverageID(managementCoffeeStore.getMenuCoffee());
        List<Beverage> beverage = managementCoffeeStore.getMenuCoffee();
        boolean found = false;
        for (int i = 0; i < beverage.size(); i++) {
            if (beverage.get(i).getBeverage_ID().equals(beverage_ID)) {
                Beverage beverage_Delete = beverage.remove(i);
                saveDeleteBbeverage(beverage_Delete);
                saveData(managementCoffeeStore);
                System.out.println("Delete Beverage successfully.");
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Delete Beverage Fail");
            }
        }
        return managementCoffeeStore;
    }

    public static void showBeverage(ManagementCoffeeStore managementCoffeeStore) {
        List<Beverage> beverages = new ArrayList<>(managementCoffeeStore.getMenuCoffee());
        System.out.printf("%-20s | %-30s | %-15s | %-50s%n", "Beverage ID", "Beverage Name", "Beverage Price", "Ingredient Of Beverage");
        Collections.sort(beverages, (beverage1, beverage2) -> beverage1.getBeverage_Name().compareTo(beverage2.getBeverage_Name()));
        for (Beverage beverage : beverages) {
            System.out.printf("%-20s | %-30s | %-15s | %-50s%n", beverage.getBeverage_ID(), beverage.getBeverage_Name(),
                    beverage.getBeverage_Price(), beverage.getIngredient_Name_Of_Beverage());
        }
    }

    public static ManagementCoffeeStore beverageOrder(ManagementCoffeeStore managementCoffeeStore) {
        String beverage_ID = Control.inputBeverageID(managementCoffeeStore.getMenuCoffee());
        boolean beverageExist = false;
        for (Beverage beverage : managementCoffeeStore.getMenuCoffee()) {
            if (beverage.getBeverage_ID().trim().equals(beverage_ID)) {
                beverageExist = true;
                boolean ingredientAvailable = true;
                for (Ingredient ingredient : beverage.getIngredients()) {
                    if (ingredient.getIngredient_Available_Quantity() <= 0) {
                        ingredientAvailable = false;
                        break;
                    }
                }
                if (ingredientAvailable) {
                    System.out.println("Beverage exists and ingredients are available.");
                    for (Ingredient ingredient : beverage.getIngredients()) {
                        double currentQuantity = ingredient.getIngredient_Available_Quantity();
                        double usedQuantity = 1;
                        ingredient.setIngredient_Available_Quantity(currentQuantity - usedQuantity);
                    }
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Order.dat"))) {
                        outputStream.writeObject(managementCoffeeStore);
                        System.out.println("Order details saved to Order.dat");
                    } catch (IOException e) {
                        System.err.println("Error saving order details: " + e.getMessage());
                    }
                } else {
                    System.out.println("Beverage exists but some ingredients are not available.");
                }
                break;
            }
        }
        if (!beverageExist) {
            System.out.println("Beverage does not exist.");
        }
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore updateBeverageOrder(ManagementCoffeeStore managementCoffeeStore) {

        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore ingredientAvailable(ManagementCoffeeStore managementCoffeeStore) {
        List<Ingredient> ingredients = new ArrayList<>(managementCoffeeStore.getIngredients());
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getIngredient_Available_Quantity() > 0) {
                System.out.println(ingredient);
            }
        }
        return managementCoffeeStore;
    }

    public static ManagementCoffeeStore beverage_Out_Of_Ingredient(ManagementCoffeeStore managementCoffeeStore) {
        List<Beverage> beverage_Out_Of_Ingredient = new ArrayList<>();

        for (Beverage beverage : managementCoffeeStore.getMenuCoffee()) {
            boolean outOfStock = false;
            for (Ingredient ingredient : beverage.getIngredients()) {
                if (ingredient.getIngredient_Available_Quantity() <= 0) {
                    outOfStock = true;
                    break;
                }
            }
            if (outOfStock) {
                beverage_Out_Of_Ingredient.add(beverage);
            }
        }

        if (!beverage_Out_Of_Ingredient.isEmpty()) {
            System.out.println("The following beverages are out of stock:");
            for (Beverage beverage : beverage_Out_Of_Ingredient) {
                System.out.println(beverage.getBeverage_ID() + ", " + beverage.getBeverage_Name() + ", " + beverage.getBeverage_Price());
                System.out.println("Ingredients:");
                for (Ingredient ingredient : beverage.getIngredients()) {
                    System.out.println(ingredient.getIngredient_ID() + ", " + ingredient.getIngredient_Name() + ", "
                            + ingredient.getIngredient_Available_Quantity());
                }
                System.out.println();
            }
        }

        return managementCoffeeStore;
    }

    public static void showBeverageOrder(ManagementCoffeeStore managementCoffeeStore) {

    }
}
