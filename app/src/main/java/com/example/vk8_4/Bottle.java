package com.example.vk8_4;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;

    public Bottle(String name, double size, double price){
        this.name=name; //tallentaa nimen name-muuttujaan
        this.size=size;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getEnergy(){
        return total_energy;
    }

    public double getPrice(){
        return price;
    }

    public double getSize(){
        return size;
    }
}
