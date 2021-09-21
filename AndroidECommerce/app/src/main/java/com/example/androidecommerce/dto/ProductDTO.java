package com.example.androidecommerce.dto;

public class ProductDTO {
    private long id;
    private String name;
    private String path;
    private double price;
    private String color;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, double price, String path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
    }

    public ProductDTO(long id, String name, double price, String path, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}