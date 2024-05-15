/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import build.Ingredient;
import build.Beverage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lenovo
 */
public class Control {
    public static boolean checkInt (String inp) {
        try {
            Integer.parseInt(inp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean checkBoolean(String inp){
        try {
            Double.parseDouble(inp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double inputDouble(String str){
        Scanner sc = new Scanner(System.in);
        System.out.print(str + ": ");
        String input = sc.nextLine();
        while(!checkBoolean(input)){
            System.err.println("Please retype.");
            input = sc.nextLine();
        }
        return Double.parseDouble(input);
    }
    
    public static boolean checkIngredientID (String input) {
        Pattern p;
        p = Pattern.compile("^[P]\\d{3}$");
        return p.matcher(input).matches();
    }
    
    public static String inputxIngredientID(List<Ingredient> ingredients) {
        int maxID = 0;
        for (Ingredient ingredient : ingredients) {
            String ingredientID = ingredient.getIngredient_ID();
            int id = Integer.parseInt(ingredientID.substring(1));
            if (id > maxID) {
                maxID = id;
            }
        }
        int newID = maxID + 1;

        return "P" + String.format("%03d", newID);
    }
    
    public static boolean checkBeverageID (String input) {
        Pattern p;
        p = Pattern.compile("^[B]\\d{3}$");
        return p.matcher(input).matches();
    }
    
    public static String inputxBeverageID(List<Beverage> menuCoffees) {
        int maxID = 0;
        for (Beverage menuCoffee : menuCoffees) {
            String  beverage_ID = menuCoffee.getBeverage_ID();
            int id = Integer.parseInt(beverage_ID.substring(1));
            if (id > maxID) {
                maxID = id;
            }
        }
        int newID = maxID + 1;

        return "B" + String.format("%03d", newID);
    }
    
    public static String inputIngredientID(List<Ingredient> ingredients) {
        Scanner sc = new Scanner(System.in);
        String id_Ingredient;
        do {
            System.out.print("Input Ingredient ID: ");
            id_Ingredient = sc.nextLine().trim();
            if (!checkIngredientID(id_Ingredient)) {
                System.out.println("Wrong Format.");
            } else {
                boolean hasID = false;
                for (Ingredient ingredient : ingredients) {
                    if (ingredient.getIngredient_ID().equals(id_Ingredient)) {
                        hasID = true;
                        break;
                    }
                }
                if (!hasID) {
                    System.out.println("Ingredient ID does not exsit.");
                    id_Ingredient = null;
                }
            }
        } while (!checkIngredientID(id_Ingredient) || id_Ingredient == null);

        return id_Ingredient;
    }
    
    public static String inputBeverageID(List<Beverage> beverages) {
        Scanner sc = new Scanner(System.in);
        String id_Beverage;

        do {
            System.out.print("Input Beverage ID: ");
            id_Beverage = sc.nextLine().trim();

            if (!checkBeverageID(id_Beverage)) {
                System.out.println("Wrong Format.");
            } else {
                boolean hasID = false;
                for (Beverage beverage : beverages) {
                    if (beverage.getBeverage_ID().equals(id_Beverage)) {
                        System.out.println("Found Id.");
                        hasID = true;
                        break;
                    }
                }
                if (!hasID) {
                    System.out.println("Beverage ID does not exsit.");
                    id_Beverage = null;
                }
            }
        } while (!checkBeverageID(id_Beverage) || id_Beverage == null);

        return id_Beverage;
    }
        
    public static int inputInt(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print(str + ": ");
        String choice = sc.nextLine();
        while(!checkInt(choice)) {
            System.err.println("Please enter an integer number!!");
            System.out.print(str + ": ");
            choice = sc.nextLine();
        }
        return Integer.parseInt(choice);
    }
    
    public static String inputString(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print(str + ": ");
        String input = sc.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Input is invalid.");
            return inputString(str);
        }
        return input;   
    }
    
    public static Date inputDate(String content) {
        String dateStr = inputString(content);
        if (!checkDate(dateStr)) {
            System.err.println("Invalid Date Format. Please retype.");
            return inputDate(content);
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
        } catch (ParseException e) {
            System.err.println("Invalid Date format. Please retype.");
            return inputDate(content);
        }
    }
    
    public static boolean checkDate (String input) {
        Pattern p;
        p = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
        return p.matcher(input).matches();
    }

    public static String formatDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
    
    public static Date dateParse(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = dateFormat.parse(strDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String updateInputString(String prompt, String defaultValue) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    public static double updateInputDouble(String prompt, double defaultValue) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        return input.isEmpty() ? defaultValue : Double.parseDouble(input);
    }
    
    public static Date updateInputDate(String prompt, Date defaultValue) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); 

        System.out.print(prompt);
        String input = sc.nextLine().trim();

        try {
            return input.isEmpty() ? defaultValue : dateFormat.parse(input);
        } catch (ParseException e) {
            System.out.println("Wrong Format. Please Retype.");
            return updateInputDate(prompt, defaultValue);
        }
    }   
}
