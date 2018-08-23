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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button cancelButton;

    public void opt_source_action(ActionEvent action) {
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
    protected void handleAddPartSave(ActionEvent event) {
        try {
            String part_Name = txt_partName.getText();
            int part_Inv = Integer.parseInt(txt_partInv.getText());
            Double part_Price = Double.parseDouble(txt_partPrice.getText());
            int part_Min = Integer.parseInt(txt_partMin.getText());
            int part_Max = Integer.parseInt(txt_partMax.getText());
            String part_CompName = txt_partCompanyName.getText();

            Inventory inventory = Inventory.getInstance();
            int part_ID = inventory.getNextPartID();

//            Need to add MachineID, this is missing the whole way through
            int part_MachineID = 1;

            String opt_selected = ((RadioButton) opt_source.getSelectedToggle()).getText();

            if (opt_selected.equalsIgnoreCase("In-House")) {
                InHouse part = new InHouse(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_MachineID);
                inventory.addPart(part);

            } else if (opt_selected.equalsIgnoreCase("OutSourced")) {
                Outsourced part = new Outsourced(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_CompName);
                inventory.addPart(part);
            } else {

            }
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
            new GetMainStage();
        } catch (Exception ex) {
            System.out.println("Error: Add Part Save was pushed: " + ex.getLocalizedMessage());
        }
    }

    @FXML
    protected void handleAddPartCancel(ActionEvent event) {
        try {
            System.out.println("Add Part: Cancel was pushed");
            new GetMainStage();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            System.out.println("Error: Add Part Cancel was pushed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
