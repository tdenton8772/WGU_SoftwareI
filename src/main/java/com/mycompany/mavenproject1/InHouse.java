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
    
    public void setMachineID(int machineID){
        this.machineID = machineID;
    }
    
    public int getMachineID(){
        return this.machineID;
    }
}
