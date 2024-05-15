/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDList;

/**
 *
 * @author Phan Văn Dõi
 */
public class CDHouse {
    private String CollectionName ;
    private String type;
    private String title;
    private double price;
    private String id;
    private int publishingYear;

    public CDHouse(String id, String title, String CollectionName, String type, double price, int publishingYear) {
        this.CollectionName = CollectionName;
        this.type = type;
        this.title = title;
        this.price = price;
        this.id = id;
        this.publishingYear = publishingYear;
    }

   

    public String getCollectionname() {
        return CollectionName;
    }

    public void setCollectionName(String CollectionName) {
        this.CollectionName = CollectionName;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    
    
   @Override
   public String toString () {
       return id + "," + title + "," + CollectionName  + "," +  type + "," +  price + "," + publishingYear ;
   }
   
   
}

