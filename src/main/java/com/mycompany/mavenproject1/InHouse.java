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
public class InHouse extends Part{
    private int machineID;
    
    public InHouse(int partID, String name, Double price, int inStock, int min, int max, int machineID){
        this.setPartID(partID);
        this.setName(name);
        this.setPrice(price);
        this.setInStock(inStock);
        this.setMin(min);
        this.setMax(max);
        this.setMachineID(machineID);
    }
    
    public void setMachineID(int machineID){
        this.machineID = machineID;
    }
    
    public int getMachineID(){
        return this.machineID;
    }
    
}
