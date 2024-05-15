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
        System.out.println("[1] Adding new Hotel");
        System.out.println("[2] Checking exits Hotel");
        System.out.println("[3] Updating Hotel information");
        System.out.println("[4] Deleting Hotel");
        System.out.println("[5] Searching Hotel");
        System.out.println("[6] Displaying a Hotel List(Descending by Hotel Name)");
        System.out.println("[0] Quit");  
    }
    
    public void MenuForSearch(){
        System.out.println("[1] Searching by Hotel ID");
        System.out.println("[2] Search by Hotel Name");
        System.out.println("[0] Back to MainMenu");
    }
}
