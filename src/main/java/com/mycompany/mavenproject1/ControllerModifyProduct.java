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
public class ControllerModifyProduct implements Initializable {
    @FXML
    protected void handleModifyProductSearchPart(ActionEvent event) {
        try {
            System.out.println("Modify Product Part Search pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Part Seach pressed");
        }
    }
    
    @FXML
    protected void handleModifyProductAddPart(ActionEvent event) {
        try {
            System.out.println("Modify Product Add Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Add Part pressed");
        }
    }

    @FXML
    protected void handleModifyProductDelete(ActionEvent event) {
        try {
            System.out.println("Modify Product Delete Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Delete Part pressed");
        }
    }

    @FXML
    protected void handleModifyProductSave(ActionEvent event) {
        try {
            System.out.println("Modify Product Save Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Save Part pressed");
        }
    }

    @FXML
    protected void handleModifyProductCancel(ActionEvent event) {
        try {
            System.out.println("Modify Product Cancel Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Cancel Part pressed");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
