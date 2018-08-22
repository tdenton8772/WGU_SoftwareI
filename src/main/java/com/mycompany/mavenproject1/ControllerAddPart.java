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
public class ControllerAddPart implements Initializable {

    @FXML
    private TextField txt_partID;
    @FXML
    private TextField txt_partName;
    @FXML
    private TextField txt_partInv;
    @FXML
    private TextField txt_partPrice;
    @FXML
    private TextField txt_partMin;
    @FXML
    private TextField txt_partMax;
    @FXML
    private TextField txt_partCompName;
    @FXML
    private ToggleGroup opt_source;

    @FXML
    private javafx.scene.control.Button cancelButton;

    @FXML
    protected void handleAddPartSave(ActionEvent event) {
        try {
            int part_ID = Integer.parseInt(txt_partID.getText());
            String part_Name = txt_partName.getText();
            int part_Inv = Integer.parseInt(txt_partInv.getText());
            Double part_Price = Double.parseDouble(txt_partPrice.getText());
            int part_Min = Integer.parseInt(txt_partMin.getText());
            int part_Max = Integer.parseInt(txt_partMax.getText());
            String part_CompName = txt_partCompName.getText();

//            Need to add MachineID, this is missing the whole way through
            int part_MachineID = 1;

            String opt_selected = ((RadioButton) opt_source.getSelectedToggle()).getText();

            if (opt_selected.equalsIgnoreCase("In-House")) {
                Inventory inventory = Inventory.getInstance();
                InHouse part = new InHouse(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_MachineID);
                inventory.addPart(part);

            } else if (opt_selected.equalsIgnoreCase("OutSourced")) {
                Inventory inventory = Inventory.getInstance();
                Outsourced part = new Outsourced(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_CompName);
                inventory.addPart(part);
            } else {

            }
            {

            }

//            System.out.println("Add Part: Save was pushed: " + part_ID);
        } catch (Exception ex) {
            System.out.println("Error: Add Part Save was pushed: " + ex.getLocalizedMessage());
        }
    }

    @FXML
    protected void handleAddPartCancel(ActionEvent event) {
        try {
            System.out.println("Add Part: Cancel was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Add Part Cancel was pushed");
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
