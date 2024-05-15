/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

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
    
    public static int inputInt(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print(str + ": ");
        String choice = sc.nextLine();
        while(!checkInt(choice)) {
            System.out.println("Please enter an integer number!!");
            System.out.print("Choose a number: ");
            choice = sc.nextLine();
        }
        return Integer.parseInt(choice);
    }
    
    public static String inputHotelID(String id) {
        System.out.print("Input Hotel ID: ");
        
        while(!Control.checkHotelId(id)) {
            System.out.println("Wrong Fomat");
            System.out.print("Input Hotel ID: ");
            
        }
        return id;
    }
    
    public static boolean checkHotelId (String input) {
        Pattern p;
        p = Pattern.compile("^[H]\\d\\d\\d$");
        return p.matcher(input).matches();
    }
    
    public static boolean checkHotelPhone (String input) {
        Pattern p;
        p= Pattern.compile("^[0-9]{10}$");
        if (input.isEmpty()) {
            System.out.println("Hotel Phone can not be empty.");
            return false;
        }
        return p.matcher(input).matches();
    }
    
    public static String inputString(String content) {
        Scanner sc = new Scanner(System.in);
        System.out.print(content + ": ");
        String str = sc.nextLine();
        if (str.trim().isEmpty()) {
            System.out.println("Input is invalid.");
            return inputString(content);
        }
        return str;
    }
    
    public static String checkInputStringID(String content) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(content + ": ");
            input = scanner.nextLine();

            if (!checkHotelId(input)) {
                System.out.println("Wrong Format.");
            }
        } while (!checkHotelId(input));

        return input;
    }

    public static double inputDouble(String str, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double choice;

        do {
            System.out.print(str + " (" + min + "-" + max + "): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Please retype. ");
                System.out.print(str + " (" + min + "-" + max + "): ");
                sc.next(); // consume the invalid input
            }
            choice = sc.nextDouble();
            if (choice < min || choice > max) {
                System.out.println("Out Of Range. ");
            }
        } while (choice < min || choice > max);
        return choice;
    }
}
