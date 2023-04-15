package com.example.mybar.db;

public class Data {
 /*   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CarID TEXT NOT NULL,"+
            "brand TEXT NOT NULL,"+
            "name TEXT NOT NULL,"+
            "model TEXT NOT NULL,"+
            "numberOfCylender TEXT NOT NULL,"+
            "price TEXT NOT NULL,"+
            "image TEXT)"*/
    private String CarID;
    private String brand;
    private String name;
    private String model;
    private String numberOfCylender;
    private String price;
    private String image;

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfCylender() {
        return numberOfCylender;
    }

    public void setNumberOfCylender(String numberOfCylender) {
        this.numberOfCylender = numberOfCylender;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Data(String carID, String brand, String name, String model, String numberOfCylender, String price, String image) {
        CarID = carID;
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.numberOfCylender = numberOfCylender;
        this.price = price;
        this.image = image;
    }
}
