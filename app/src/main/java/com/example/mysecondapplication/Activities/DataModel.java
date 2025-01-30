package com.example.mysecondapplication.Activities;

public class DataModel {
    private String name;
    private String description;
    private int image;
    private final int id_;
    private int quantity;
    private double price;

    public DataModel(String name, String description, int image, int id_, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id_ = id_;
        this.quantity = quantity;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public void increaseQuantity() {
        this.quantity++;
    }
    public void decreaseQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }
}
