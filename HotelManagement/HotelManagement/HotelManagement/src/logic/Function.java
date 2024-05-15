/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import build.Hotel;
import build.HotelManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Function {

    Scanner sc = new Scanner(System.in);
    Control control = new Control();

    public static HotelManager LoadData(HotelManager hotelManager) {
        hotelManager.setHotels(loadHotel());
        return hotelManager;
    }

    public static List<Hotel> loadHotel() {
        List<Hotel> hotel = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src//Data//Hotel.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] components = line.split(",");
                if (components.length == 6) {
                    String hotel_ID = components[0];
                    String hotel_Name = components[1];
                    int hotel_Room_Available = Integer.parseInt(components[2].trim());
                    String hotel_Address = components[3];
                    String hotel_Phone = components[4];
                    double hotel_Rating = Double.parseDouble(components[5]);
                    hotel.add(new Hotel(hotel_ID, hotel_Name, hotel_Room_Available, hotel_Address, hotel_Phone, hotel_Rating));
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return hotel;
    }

    public static void SaveData(HotelManager hotelManager) {
        saveHotel(hotelManager.getHotels());
    }

    public static void saveHotel(List<Hotel> hotel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//Data//Hotel.dat", false))) {
            for (Hotel p : hotel) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static String inputNewHotelID(List<Hotel> hotels) {
        String id = Control.checkInputStringID("Input Hotel ID: ");
        for (Hotel p : hotels) {
            if (p.getHotel_ID().equals(id)) {
                System.out.println("Hotel ID already existed");
                System.out.println("Add Fail. ");
                return inputNewHotelID(hotels);
            }
        }
        return id;
    }

    public static String inputHotelID(List<Hotel> hotels) {
        boolean hasID = false;
        String id_Hotel = Control.checkInputStringID("Input Hotel ID: ");
        while (!Control.checkHotelId(id_Hotel)) {
            System.out.println("Wrong Fomat.");
            id_Hotel = Control.checkInputStringID("Input Hotel ID: ");
        }
        for (Hotel p : hotels) {
            if (p.getHotel_ID().equals(id_Hotel)) {
                hasID = true;
                break;
            }
        }
        if(!hasID){
            System.out.println("Not Found Hotel To Uppdate");
            System.out.println("Updating Fail.");
            return null;
        }
        return id_Hotel;
    }

    public static HotelManager addHotel(HotelManager hotelManager) {
        Scanner sc = new Scanner(System.in);
        boolean continueAdding = true;
        do {
            String id_Hotel = inputNewHotelID(hotelManager.getHotels());
            String name_Hotel = Control.inputString("Input Hotel Name: ");
            int hotel_Room_Available = Control.inputInt("Input Hotel Room Available: ");
            String hotel_Address = Control.inputString("Input Hotel Address: ");
            String hotel_Phone = Control.inputString("Input Hotel Phone: ");
            double hotel_Rating = Control.inputDouble("Input Hotel Rating", 0, 5);
            List<Hotel> hotels = hotelManager.getHotels();
            hotels.add(new Hotel(id_Hotel, name_Hotel, hotel_Room_Available, hotel_Address, hotel_Phone, hotel_Rating));
            hotelManager.setHotels(hotels);
            SaveData(hotelManager);
            System.out.println("Add Successfully. ");
            System.out.print("Do you want to continue adding hotel (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            continueAdding = choice.equals("Y");
        }while(continueAdding);
        return hotelManager;
    }

    public static HotelManager checkHotel(HotelManager hotelManager) {
        Scanner sc = new Scanner(System.in);
        boolean continueChecking;
        do {
            String id_Hotel = Control.checkInputStringID("Input Hotel ID: ");
            boolean hotelFound = false;
            for (Hotel hotel : hotelManager.getHotels()) {
                if (hotel.getHotel_ID().equals(id_Hotel)) {
                    System.out.println("Exist Hotel.");
                    hotelFound = true;
                    break; 
                }
            }
            if (!hotelFound) {
                System.out.println("No Hotel Found!");
            }
            System.out.print("Do you want to back main menu (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            continueChecking = choice.equals("Y");

        } while (!continueChecking);
        return hotelManager;
    }

    public static HotelManager updateHotel(HotelManager hotelManager) {
        String id_Hotel = inputHotelID(hotelManager.getHotels());
        if(id_Hotel!= null){
        String name_Hotel = Control.inputString("Input Hotel Name: ");
        int hotel_Room_Available = Control.inputInt("Input Hotel Room Available: ");
        String hotel_Address = Control.inputString("Input Hotel Address: ");
        String hotel_Phone = Control.inputString("Input Hotel Phone: ");
        double hotel_Rating = Control.inputDouble("Input Hotel Rating", 0, 5);

        List<Hotel> hotels = hotelManager.getHotels();
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getHotel_ID().equals(id_Hotel)) {
                hotels.set(i, new Hotel(id_Hotel, name_Hotel, hotel_Room_Available, hotel_Address, hotel_Phone, hotel_Rating));
                break;
            }
        }
        hotelManager.setHotels(hotels);
        SaveData(hotelManager);
        System.out.println("Update Hotel Successfully. ");}
        return hotelManager;
    }

    public static HotelManager deleteHotel(HotelManager hotelManager) {
        String id = inputHotelID(hotelManager.getHotels());
        List<Hotel> hotels = hotelManager.getHotels();
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getHotel_ID().equals(id)) {
                hotels.remove(i);
                break;
            }
        }
        System.out.println("Delele Hotel Successfully. ");
        hotelManager.setHotels(hotels);
        SaveData(hotelManager);
        return hotelManager;
    }

    public static HotelManager searchByHotelID(HotelManager hotelManager) {
        String id_Hotel = Control.checkInputStringID("Input Hotel ID: ");
        boolean check = false;
        for (Hotel hotel : hotelManager.getHotels()) {
            if (hotel.getHotel_ID().equals(id_Hotel)) {
                System.out.println("Exist Hotel.");
                System.out.println(hotel);
                check = true;
                break;
            }
        }
        if(check == false){
            System.out.println("No Hotel Found!");
        }
        return hotelManager;
    }

    public static HotelManager searchByHotelName(HotelManager hotelManager) {
        String name_Hotel = Control.inputString("Input Hotel Name: ");
        boolean check = false;
        for (Hotel hotel : hotelManager.getHotels()) {
            if (hotel.getHotel_Name().trim().equals(name_Hotel)) {
                System.out.println("Exist Hotel.");
                System.out.println(hotel);
                check = true;
                break;
            }
        } 
        if(check == false){
            System.out.println("No Hotel Found!");
            System.out.println("Searching Fail.");
        }
        return hotelManager;
    }

    public static void showHotelList(HotelManager hotelManager) {
        List<Hotel> hotels = hotelManager.getHotels();

        if (hotels != null) {
            for (Hotel hotel : hotels) {
                System.out.println(hotel);
            }
        }
    }

    public static void shơHotelListByHotelName(HotelManager hotelManager) {
        List<Hotel> hotels = hotelManager.getHotels();
        Collections.sort(hotels, (hotel1, hotel2) -> hotel1.getHotel_Name().compareTo(hotel2.getHotel_Name()));
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

}
