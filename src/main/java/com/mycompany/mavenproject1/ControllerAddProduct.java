/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;

/**
 *
 * @author tdenton
 */
public class ControllerAddProduct implements Initializable {
    @FXML
    protected void handleAddProductSearchPart(ActionEvent event) {
        try {
            System.out.println("Add Product Part Search pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Part Seach pressed");
        }
    }
    
    @FXML
    protected void handleAddProductAddPart(ActionEvent event) {
        try {
            System.out.println("Add Product Add Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Add Part pressed");
        }
    }

    @FXML
    protected void handleAddProductDelete(ActionEvent event) {
        try {
            System.out.println("Add Product Delete Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Delete Part pressed");
        }
    }

    @FXML
    protected void handleAddProductSave(ActionEvent event) {
        try {
            System.out.println("Add Product Save Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Save Part pressed");
        }
    }

    @FXML
    protected void handleAddProductCancel(ActionEvent event) {
        try {
            System.out.println("Add Product Cancel Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Cancel Part pressed");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
