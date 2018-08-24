/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 *
 * @author tdenton
 */
public class Inventory {

    private List<Part> parts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    private static Inventory single_instance = null;

//    Default constructor, no values as this starts off empty
    private Inventory() {

    }

    public List getProductList() {
        return this.products;
    }

    public List getPartList() {
        return this.parts;
    }

    public int getNextPartID() {
        int length;
        if (this.parts.size() > 0) {
            length = this.parts.size() - 1;
            System.out.println("Current Length: " + length);
            int lastID = this.parts.get(length).getPartID() + 1;
            return lastID;
        } else {
            return 1;
        }
    }

    public void addPart(Part part) {
        this.parts.add(part);
        System.out.println(this.parts);
    }

    public List<Part> lookupPart(String partName) {
        List<Part> tempPartList = new ArrayList<Part>();
        for (Part part : this.parts) {
            if (part.getName().contains(partName)) {
                tempPartList.add(part);
            }
        }
        return tempPartList;
    }

    public boolean deletePart(Part part) {
        try {
            parts.remove(part);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void updatePart(Part part) {
        parts.set(part.getPartID() - 1, part);
    }

    public int getNextProductID() {
        int length;
        if (this.products.size() > 0) {
            length = this.products.size() - 1;
            System.out.println("Current Length: " + length);
            int lastID = this.products.get(length).getProductID() + 1;
            return lastID;
        } else {
            return 1;
        }
    }

    public void addProduct(Product product) {
        this.products.add(product);
        System.out.println(this.products);
    }

    public boolean removeProduct(Product product) {
        try {
            this.products.remove(product);
            return true;
        } catch (Exception ex) {
            System.out.println("Error: Delete Part was pushed");
            return false;
        }
    }

    public List<Product> lookupProduct(String productName) {
        List<Product> tempProductList = new ArrayList<Product>();
        for (Product product : this.products) {
            if (product.getName().contains(productName)) {
                tempProductList.add(product);
            }
        }
        return tempProductList;
    }

    public void updateProduct(Product product) {
        this.products.set(product.getProductID() - 1, product);
    }

//    turns inventory into a singleton
    public static Inventory getInstance() {
        if (single_instance == null) {
            single_instance = new Inventory();
        }

        return single_instance;
    }
}
