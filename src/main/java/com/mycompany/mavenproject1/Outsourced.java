/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author tdenton
 */
public class Outsourced extends Part {
    private String companyName;
    
    public Outsourced(int partID, String name, Double price, int inStock, int min, int max, String companyName){
        this.setPartID(partID);
        this.setName(name);
        this.setPrice(price);
        this.setInStock(inStock);
        this.setMin(min);
        this.setMax(max);
        this.setCompanyName(companyName);
    }
    
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    
    public String getCompanyName(){
        return this.companyName;
    }
}
