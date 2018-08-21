/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 *
 * @author tdenton
 */
public abstract class Part {

    private int partID;
    private String name = new String();
    private Double price;
    private int inStock;
    private int min;
    private int max;

    public void setName(String name) {
        this.name = name;
    }

    ;
    
    public String getName() {
        return this.name;
    }

    ;
    
    public void setPrice(double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getInStock() {
        return this.inStock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMin() {
        return this.min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return this.max;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getPartID() {
        return this.partID;
    }
}
