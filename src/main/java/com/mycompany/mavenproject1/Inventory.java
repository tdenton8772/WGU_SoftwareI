/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author tdenton
 */
public class Inventory {
    private List<Part> parts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    
    private static Inventory single_instance = null; 
    
//    Default constructor, no values as this starts off empty
    private Inventory(){
        
    }
    
    public List getPartList(){
        return this.parts;
    }
    
    public int getNextPartID(){
        int length;
        if(this.parts.size() > 0){
        length = this.parts.size() - 1;
        System.out.println("Current Length: " + length);
        int lastID = this.parts.get(length).getPartID() + 1;
        return lastID;
        } else {
            return 1;
        }
    }
    
    public void addPart(Part part){
        this.parts.add(part);
        System.out.println(this.parts);
    }
    
    public Part lookupPart(int index){
        Part part = this.parts.get(index);
        return part;
    }
    
    public boolean deletePart(Part part){
        try {
            parts.remove(part);
            return true;
        } catch(Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public void updatePart(Part part){
        parts.set(part.getPartID()-1, part);
    }
    
    
    public int getNextProductID(){
        int length;
        if(this.products.size() > 0){
        length = this.products.size() - 1;
        System.out.println("Current Length: " + length);
        int lastID = this.parts.get(length).getPartID() + 1;
        return lastID;
        } else {
            return 1;
        }
    }
        
    public void addProduct(Product product){
        this.products.add(product);
        System.out.println(this.products);
    }
    
    public void removeProduct(int index){
     this.products.remove(index);
     System.out.println(this.products);
    }
    
    public Product lookupProduct(int index){
        Product product = this.products.get(index);
        return product;
    }
    
    public void updateProduct(int index){
//        I have no idea how this is supposed to work with only int for its value
    }
    
//    turns inventory into a singleton
    public static Inventory getInstance()
    {
        if (single_instance == null)
            single_instance = new Inventory();
 
        return single_instance;
    }
}
