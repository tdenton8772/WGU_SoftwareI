/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tdenton
 */
public class Product {
    private List<Part> associatedParts = new ArrayList<>();
    private int productID;
    private String name = new String();
    private Double price;
    private int inStock;
    private int min;
    private int max;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public Double getPrice(){
        return this.price;
    }
    
    public void setInStock(int inStock){
        this.inStock = inStock;
    }
    
    public int getInStock(){
        return this.inStock;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public int getMin(){
        return this.min;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public int getMax(){
        return this.max;
    }
    
    public void addAssociatedPart(Part part){
        
    }
    
    public boolean removeAssociatedPart(int index){
        return true;
    }
    
    public Part lookupAssociatedPart(int index){
//        Not sure what this method is supposed to do?
        Inventory inventory = Inventory.getInstance();
        Part part = inventory.lookupPart(index);
        return part;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }
    
    public int getProductID(){
        return this.productID;
    }
}
