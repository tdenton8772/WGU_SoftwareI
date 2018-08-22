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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tdenton
 */
public class ControllerModifyPart implements Initializable {
    @FXML
    private TextField txt_partCompanyName;
    @FXML
    private Text lbl_partCompanyName;
    @FXML
    private TextField txt_partMachineID;
    @FXML
    private Text lbl_partMachineID;
    @FXML
    private ToggleGroup opt_source;
    @FXML
    private javafx.scene.control.Button cancelButton;
    
    public void opt_source_action(ActionEvent action){
        String opt_selected = ((RadioButton) opt_source.getSelectedToggle()).getText();
        if (opt_selected.equalsIgnoreCase("In-House")) {
                lbl_partCompanyName.setVisible(false);
                txt_partCompanyName.setVisible(false);
                lbl_partMachineID.setVisible(true);
                txt_partMachineID.setVisible(true);
            } else if (opt_selected.equalsIgnoreCase("OutSourced")) {
                lbl_partCompanyName.setVisible(true);
                txt_partCompanyName.setVisible(true);
                lbl_partMachineID.setVisible(false);
                txt_partMachineID.setVisible(false);
            } else {

            }
        
    }
    
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
