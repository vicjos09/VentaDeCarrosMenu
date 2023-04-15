package com.example.mybar;

public class Carro {
    String carID;
    String brand;
    String name;
    String model;
    String numberOfCylinder;
    String price;
    String image;

    public Carro(String carID, String brand, String name, String model, String numberOfCylinder, String price, String image) {
        this.carID = carID;
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.numberOfCylinder = numberOfCylinder;
        this.price = price;
        this.image = image;
    }
    public Carro(){

    }

    public String getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getNumberOfCylinder() {
        return numberOfCylinder;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfCylinder(String numberOfCylinder) {
        this.numberOfCylinder = numberOfCylinder;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
