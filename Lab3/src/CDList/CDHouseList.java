/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDList;

import Tool.MyTool;
import static Tool.MyTool.sc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author Phan Văn Dõi
 */
public class CDHouseList {
    
    private ArrayList<CDHouse> list = new ArrayList();
    private ArrayList<CDHouse> listFile = new ArrayList();
    
     public void readDataFromFile()  {
         try {
         FileReader fr = new FileReader("CD.dat");
         BufferedReader bf = new BufferedReader(fr);
         String details;
         while ((details = bf.readLine()) != null) {
             StringTokenizer stk = new StringTokenizer (details, ",");
             String id = stk.nextToken();
             String title = stk.nextToken();
             String CollectionName = stk.nextToken();
             String type = stk.nextToken();
             double price = Double.parseDouble(stk.nextToken());
             int publishingYear = Integer.parseInt(stk.nextToken());
             list.add(new CDHouse(id, title, CollectionName, type, price, publishingYear));
         }
         bf.close();
         fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    public void addCD() {
        String id, title, type, CollectionName;
        double price;
        int publishingYear;
        boolean checktitle;
         boolean checkid;
        System.out.println("Enter CD collection name (Game/Movie/Music): ");
        CollectionName = sc.nextLine().trim().toUpperCase();
        System.out.println("Enter CD type  (Audio/Video): ");
        type = sc.nextLine().trim().toUpperCase();
        do {
        checktitle = false;
        System.out.println("Enter title: ");
        title = sc.nextLine().trim().toUpperCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equalsIgnoreCase(title)) {
                checktitle = true;
            }
        } 
        if (checktitle == true) {
            System.out.println(" CD title is duplicated.Input again!");
        }
        } while (checktitle == true);
        
        do {
        checkid = false;
        System.out.println("Enter CD ID: ");
        id = sc.nextLine().trim().toUpperCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                checkid = true;
            }
        } 
        if (checkid == true) {
            System.out.println(" CD ID is duplicated.Input again!");
        }
        } while (checktitle == true);
        System.out.println("Enter publishing year: ");
        publishingYear = Integer.parseInt(sc.nextLine());
        System.out.println("Enter price: ");
        price = Double.parseDouble(sc.nextLine());
        list.add(new CDHouse(id, title, CollectionName, type, price, publishingYear));
        System.out.println("Information CD have been added to the list.");
        }
    
    
    public void searchCD() {
        ArrayList<CDHouse> listSP = new ArrayList();
        boolean flag = false;
        String title = MyTool.getString("Ener title:", "Not blank or empty.");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                listSP.add(list.get(i));
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Have no any CD. ");
            return;
        }
        System.out.println("HERE IS INFORMATION OF CD SEARCH: ");
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        System.out.println("|    ID    |          TITLE          |    COLLECTIONNAME  |   TYPE   |   PRICE  |   PUBLISHINGYEAR   |");
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        for (int i = 0; i < listSP.size(); i++) {
            System.out.printf("|%-10s|%-25s|%-20s|%-10s|%-10s|%-20s|\n",listSP.get(i).getId(), listSP.get(i).getTitle(), listSP.get(i).getCollectionname(),
                                      listSP.get(i).getType(), listSP.get(i).getPrice(), listSP.get(i).getPublishingYear()); 
        }
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
    }
    public void displayCD() {
        if (list.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
        } else {
        System.out.println("HERE IS INFORMATION OF LIST CD: ");
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        System.out.println("|    ID    |          TITLE          |    COLLECTIONNAME  |   TYPE   |   PRICE  |   PUBLISHINGYEAR   |");
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%-10s|%-25s|%-20s|%-10s|%-10s|%-20s|\n",list.get(i).getId(), list.get(i).getTitle(), list.get(i).getCollectionname(),
                                      list.get(i).getType(), list.get(i).getPrice(), list.get(i).getPublishingYear()); 
        }
        System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        }
    }

    
    public void updateCD() {
        int choice = MyTool.getAnInteger("Enter your choice(1.Update CD OR 2.Delete CD): ", "Just 1 or 2.", 1, 2);
        boolean checkUpdate = false;
        if ( choice == 1) {
            String id = MyTool.getString("Enter ID CD: ", "Not blank or empty.");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    boolean check;
                    String NewTitle;
                    do {
                        check = true;
                        NewTitle = MyTool.updatString("Enter New Title: ", list.get(i).getTitle());
                        if (!NewTitle.isEmpty()) {
                            System.out.println("Update Title Not Successful!");
                            check = false;
                        }
                    } while (check == false);
                    String NewCollectionName = MyTool.updatString("Enter New Collection Name: ", list.get(i).getCollectionname());
                    String Newtype = MyTool.updatString("Enter New Type: ", list.get(i).getType());
                    double NewPrice = MyTool.updateADoule("Enter New Price: ", 0, list.get(i).getPrice());
                    int NewPublishingYear = MyTool.updatAnInteger("Enter New Publishing Year: ",list.get(i).getPublishingYear());
                    list.get(i).setTitle(NewTitle);
                    list.get(i).setCollectionName(NewCollectionName);
                    list.get(i).setType(Newtype);
                    list.get(i).setPrice(NewPrice);
                    list.get(i).setPublishingYear(NewPublishingYear);
                    System.out.println("The CD's information has been updated..Successfully.");
                    checkUpdate = true;
                } 
                 
            }
            if (checkUpdate == false) {
                System.out.println("CD name dose not exist!");
            }
        } else {
            boolean checkDelete = false;
            String id = MyTool.getString("Enter ID CD: ", "Not blank or empty.");
            for (int i =0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    list.remove(i);
                    System.out.println("The CD's information has been deleted..Successfully. ");
                    checkDelete = true;
                }
            }
            if (checkDelete == false) {
                System.out.println("CD name does not exist!");
            }   
        }
    }
    
    public void saveToFile()  {
        try { 
            File f = new File ("CD.dat");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i).toString());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            System.out.println("Save to file Successfully!");
        
    }
    
    public void printlistCDsfromfile() {
        listFile.clear();
        try {
            FileReader fr = new FileReader("CD.dat");
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer (details, ",");
             String id = stk.nextToken();
             String title = stk.nextToken();
             String CollectionName = stk.nextToken();
             String type = stk.nextToken();
             double price = Double.parseDouble(stk.nextToken());
             int publishingYear = Integer.parseInt(stk.nextToken());
             listFile.add(new CDHouse(id, title, CollectionName, type, price, publishingYear));
         }
         bf.close();
         fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (listFile.isEmpty()) {
            System.out.println("Not exist CD in list");
            } else {
            Collections.sort(listFile, (o1, o2) -> {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
        });
            System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
            System.out.println("|    ID    |          TITLE          |    COLLECTIONNAME  |   TYPE   |   PRICE  |   PUBLISHINGYEAR   |");
            System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
            for (int i = 0; i < listFile.size(); i++) {
                System.out.printf("|%-10s|%-25s|%-20s|%-10s|%-10s|%-20s|\n", listFile.get(i).getId(), listFile.get(i).getTitle(), listFile.get(i).getCollectionname(),
                                      listFile.get(i).getType(), listFile.get(i).getPrice(), listFile.get(i).getPublishingYear());
            }
            System.out.println("+----------+-------------------------+--------------------+----------+----------+--------------------+");
        
        }
    }
}

  

        
        
        
        

 
        
        
        
        
        
        
        
        
        
    
        
    
                 
                 
                 
             
         
         
     
    

