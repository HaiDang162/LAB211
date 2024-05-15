/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import CDList.CDHouseList;
import Tool.MyTool;

/**
 *
 * @author Phan Văn Dõi
 */
public class Main {
    public static void  main(String[] args)  {
        CDHouseList CDList =  new CDHouseList();
        CDList.readDataFromFile();
        int choice = 0;
        do {
            System.out.println("****** Welcome to CD HOUSE *****");
            System.out.println("1-Add CD to the catalog");
            System.out.println("2-Search CD by title");
            System.out.println("3-Display the catalog");
            System.out.println("4-Update CD");
            System.out.println("5-Save the catalog to file");
            System.out.println("6-Print list CDs from file");
            System.out.println("7-Exit...");
            
            choice = MyTool.getAnInteger("Enter your choice[1..7]:", "Just from 1 to 7", 1, 7);
            switch (choice) {
                case 1:
                    CDList.addCD();
                    break;
                case 2:
                    CDList.searchCD();
                    break;
                case 3:
                    CDList.displayCD();
                    break;
                case 4:
                    CDList.updateCD();
                    break;
                case 5:
                    CDList.saveToFile();
                    break;
                case 6:
                    CDList.printlistCDsfromfile();
                    break;
                case 7:
                    System.out.println("Exit Program");
                    break;
            }
        } while (choice !=7); 
    }  
}
    

