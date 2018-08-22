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
import javafx.stage.Stage;

/**
 *
 * @author tdenton
 */
public class ControllerModifyPart implements Initializable {

    @FXML
    private javafx.scene.control.Button cancelButton;
    
    @FXML
    protected void handleModifyPartSave(ActionEvent event) {
        try {
            System.out.println("Modify Part: Save was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Part Save was pushed");
        }
    }
    
    @FXML
    protected void handleModifyPartCancel(ActionEvent event) {
        try {
            System.out.println("Modify Part: Cancel was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Part Cancel was pushed");
        }
        
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
