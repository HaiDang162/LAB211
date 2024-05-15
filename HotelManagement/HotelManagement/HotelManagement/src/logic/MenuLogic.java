/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import build.HotelManager;
import java.util.List;
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
        System.out.print("Choose a number: ");
        String choice = sc.nextLine();

        while(!control.checkInt(choice)) {
            System.out.println("Please enter an integer number!!");
            System.out.print("Choose a number: ");
            choice = sc.nextLine();
        }
        return Integer.parseInt(choice);
    }
    
    public void MenuOfSearch(){
        HotelManager hotelManager = new HotelManager();
        hotelManager = Function.LoadData(hotelManager);
        boolean isMenuOfSearch = true;
        while(isMenuOfSearch){
            menu.MenuForSearch();
            switch (EnterChoices()){
                case 1:
                   hotelManager = Function.searchByHotelID(hotelManager);
                   break;
                case 2:
                   hotelManager = Function.searchByHotelName(hotelManager);
                   break;
                case 0:
                    isMenuOfSearch = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[2]");
                    break;
            }
        }
    }
    
    public void MainMenu() {
        HotelManager hotelManager = new HotelManager();
        hotelManager = Function.LoadData(hotelManager);
        boolean isMainMenu = true;
        while(isMainMenu) {
            menu.MainMenu();
            switch (EnterChoices()) {
                case 1:
                    hotelManager = Function.addHotel(hotelManager);
                    break;
                case 2: 
                    hotelManager = Function.checkHotel(hotelManager);
                    break;
                case 3:
                    hotelManager = Function.updateHotel(hotelManager);
                    break;
                case 4: 
                    hotelManager = Function.deleteHotel(hotelManager);
                    break;
                case 5: 
                    MenuOfSearch();
                    break;
                case 6:
                    System.out.println("============================HOTEL LIST IN FILE====================");
                    Function.showHotelList(hotelManager);
                    System.out.println("==================================================================");
                    System.out.println("============================HOTEL LIST============================");
                    Function.shơHotelListByHotelName(hotelManager);
                    break;
                case 0:
                    isMainMenu = false;
                    break;
                default:
                    System.out.println("Please enter a number from [0]-[6]");
                    break;
            }
        }
    }
}
