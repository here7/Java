package com.heredh7.lab.entities;

import java.util.ArrayList;

public class Product {

    /**
     * System Product Variables
     */
    private Integer id;
    private String name;
    private String description;
    private double price;
    private ArrayList images;
    private String image;


    public Product(){

    }

    public Product(Integer id, String name, String description, double price, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }



    /**
     * Getters
     */
    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }

    public String getImage(){ return this.image; }


    /**
     * Setters
     */
    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(Double price){ this.price = price; }

    public void setImage( String image ) {
        this.image = image;
    }

    /**
     * Product Functions
     */
    @Override
    public String toString() {
        return "Product [name=" + this.name+ "]";
    }

}
