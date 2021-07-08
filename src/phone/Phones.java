/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone;

/**
 *
 * @author Tuan
 */
public class Phones {
    private String model, cpu, color, brand;
    private int ram;
    private double primaryCamera, screenSize, price;
    
    public Phones(){
    }
    
    public Phones(String model, String cpu, String color, String brand, int ram,
            double primaryCamera, double screenSize, double price){
        this.model = model;
        this.color = color;
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
        this.primaryCamera = primaryCamera;
        this.screenSize = screenSize;
        this.price = price;
    }    

    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public double getPrimaryCamera() {
        return primaryCamera;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setPrimaryCamera(double primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MODEL\t\t " + " CPU\t\t " + " COLOR\t\t " + " BRAND\t\t " + " RAM\t\t" + " PRIMARYCAMERA\t\t " + " SCREENSIZE\t\t " + " PRICE\t\n "
                + model + "\t\t" + cpu + "\t\t" + color + "\t\t" + brand + "\t\t" + ram + "GB\t\t" + primaryCamera + "MP\t\t" + screenSize + "\t\t" + price;
    }
    
}
