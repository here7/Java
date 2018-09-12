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


    public Product(){

    }

    public Product(Integer id, String name, String description, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public void setPrice(Double price){
        this.price = price;
    }



    /**
     * Product Functions
     */
    @Override
    public String toString() {
        return "Product [name=" + this.name+ "]";
    }

}
