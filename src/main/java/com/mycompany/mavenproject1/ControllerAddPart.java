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
public class ControllerAddPart implements Initializable {

    @FXML
    protected void handleAddPartSave(ActionEvent event) {
        try {
            System.out.println("Add Part: Save was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Add Part Save was pushed");
        }
    }

    @FXML
    protected void handleAddPartCancel(ActionEvent event) {
        try {
            System.out.println("Add Part: Cancel was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Add Part Cancel was pushed");
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
