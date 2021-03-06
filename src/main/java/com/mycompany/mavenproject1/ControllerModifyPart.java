/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tdenton
 */
public class ControllerModifyPart implements Initializable {

    private Part part;

    @FXML
    private GridPane root;
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
    private Text lbl_partCompanyName;
    @FXML
    private TextField txt_partMachComp;
    @FXML
    private Text lbl_partMachineID;
    @FXML
    private ToggleGroup opt_source;
    @FXML
    private RadioButton opt_InHouse;
    @FXML
    private RadioButton opt_OutSourced;
    @FXML
    private Button cancelButton;

    public void storePart(Part part) {
        this.part = part;
    }

    public void opt_source_action(ActionEvent action) {
        String opt_selected = ((RadioButton) opt_source.getSelectedToggle()).getText();
        txt_partMachComp.setText(null);
        if (opt_selected.equalsIgnoreCase("In-House")) {
            txt_partMachComp.setPromptText("Mach ID");
            lbl_partCompanyName.setVisible(false);
            lbl_partMachineID.setVisible(true);
        } else if (opt_selected.equalsIgnoreCase("OutSourced")) {
            txt_partMachComp.setPromptText("Comp Nm");
            lbl_partCompanyName.setVisible(true);
            lbl_partMachineID.setVisible(false);
        } else {

        }

    }

    public class ValidateReturn {

        boolean validated = true;
        String messageCode = "";
    }

    private ValidateReturn ValidatePart(String name, String inv, String price, String min, String max, String partType, String machComp) {
        ValidateReturn object = new ValidateReturn();
        if (name.equals("")) {
            object.validated = false;
            object.messageCode = "You must include a Name";
            return object;
        }

        try {
            Integer.parseInt(inv);
        } catch (Exception ex) {
            object.validated = false;
            object.messageCode = "Current inventory must be an integer";
            return object;
        }

        try {
            Integer.parseInt(min);
        } catch (Exception ex) {
            object.validated = false;
            object.messageCode = "Minimum inventory must be an integer";
            return object;
        }

        try {
            Integer.parseInt(max);
        } catch (Exception ex) {
            object.validated = false;
            object.messageCode = "Maximum inventory must be an integer";
            return object;
        }

        try {
            Double.parseDouble(price);
        } catch (Exception ex) {
            object.validated = false;
            object.messageCode = "Price must be a double";
            return object;
        }

        if (Integer.parseInt(min) > Integer.parseInt(max)) {
            object.validated = false;
            object.messageCode = "Minimum integer values must be less than or equal to maximum integer values";
            return object;
        }

        if (Integer.parseInt(inv) < Integer.parseInt(min) || Integer.parseInt(inv) > Integer.parseInt(max)) {
            object.validated = false;
            object.messageCode = "Inventory must be between or equal to min and max inventory values";
            return object;
        }

        System.out.println("PartType: " + partType + "MachComp: " + machComp);

        if (partType.equalsIgnoreCase("In-House")) {
            try {
                Integer.parseInt(machComp);
            } catch (Exception ex) {
                object.validated = false;
                object.messageCode = "Must have a valid Machine ID";
                return object;
            }
        } else if (partType.equalsIgnoreCase("Outsourced")) {
            try {
                if (machComp.equals("")) {
                    object.validated = false;
                    object.messageCode = "You must have a valid company name";
                    return object;
                }
            } catch (Exception ex) {
                object.validated = false;
                object.messageCode = "You must have a valid company name";
                return object;
            }
        } else {
            System.out.println(partType);
            object.validated = false;
            object.messageCode = "Dont recognize part type: " + partType;
        }

        return object;
    }

    @FXML
    protected void handleModifyPartSave(ActionEvent event
    ) {
        String opt_selected = ((RadioButton) opt_source.getSelectedToggle()).getText();

        ValidateReturn returnObject = ValidatePart(txt_partName.getText(), txt_partInv.getText(), txt_partPrice.getText(), txt_partMin.getText(), txt_partMax.getText(), opt_selected, txt_partMachComp.getText());

        if (returnObject.validated == false) {
            System.out.println(returnObject.messageCode);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Modify Part Error");
            alert.setHeaderText("Data Validation Error");
            alert.setContentText(returnObject.messageCode);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();

        } else {
            try {

                String part_Name = txt_partName.getText();
                int part_Inv = Integer.parseInt(txt_partInv.getText());
                Double part_Price = Double.parseDouble(txt_partPrice.getText());
                int part_Min = Integer.parseInt(txt_partMin.getText());
                int part_Max = Integer.parseInt(txt_partMax.getText());

                Inventory inventory = Inventory.getInstance();
                int part_ID = Integer.parseInt(txt_partID.getText());

                if (opt_selected.equalsIgnoreCase("In-House")) {
                    int part_MachineID = Integer.parseInt(txt_partMachComp.getText());
                    InHouse part = new InHouse(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_MachineID);
                    inventory.updatePart(part);

                } else if (opt_selected.equalsIgnoreCase("OutSourced")) {
                    String part_CompName = txt_partMachComp.getText();
                    Outsourced part = new Outsourced(part_ID, part_Name, part_Price, part_Inv, part_Min, part_Max, part_CompName);
                    inventory.updatePart(part);
                } else {

                }

                System.out.println("Modify Part: Save was pushed");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                new GetMainStage();
            } catch (Exception ex) {
                System.out.println("Error: Modify Part Save was pushed");
            }
        }
    }

    @FXML
    protected void handleModifyPartCancel(ActionEvent event
    ) {
        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Are you sure you want to cancel?");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.println("Modify Part: Cancel was pushed");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                new GetMainStage();
            } else {
                System.out.println("User decided to not Cancel");
            }

        } catch (Exception ex) {
            System.out.println("Error: Modify Part Cancel was pushed");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        root.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (this.part.getClass().equals(InHouse.class)) {
                System.out.println("InHouse");
                InHouse InHousePart = (InHouse) part;
                opt_InHouse.setSelected(true);
                opt_OutSourced.setSelected(false);
                lbl_partCompanyName.setVisible(false);
                lbl_partMachineID.setVisible(true);

                txt_partID.setText(Integer.toString(InHousePart.getPartID()));
                txt_partName.setText(InHousePart.getName());
                txt_partInv.setText(Integer.toString(InHousePart.getInStock()));
                txt_partPrice.setText(Double.toString(InHousePart.getPrice()));
                txt_partMin.setText(Integer.toString(InHousePart.getMin()));
                txt_partMax.setText(Integer.toString(InHousePart.getMax()));
                txt_partMachComp.setText(Integer.toString(InHousePart.getMachineID()));
            } else if (this.part.getClass().equals(Outsourced.class)) {
                System.out.println("Outsourced");
                Outsourced OutSourcedPart = (Outsourced) part;
                opt_InHouse.setSelected(false);
                opt_OutSourced.setSelected(true);
                lbl_partCompanyName.setVisible(true);
                lbl_partMachineID.setVisible(false);
                txt_partID.setText(Integer.toString(OutSourcedPart.getPartID()));
                txt_partName.setText(OutSourcedPart.getName());
                txt_partInv.setText(Integer.toString(OutSourcedPart.getInStock()));
                txt_partPrice.setText(Double.toString(OutSourcedPart.getPrice()));
                txt_partMin.setText(Integer.toString(OutSourcedPart.getMin()));
                txt_partMax.setText(Integer.toString(OutSourcedPart.getMax()));
                txt_partMachComp.setText(OutSourcedPart.getCompanyName());

            } else {
                System.out.println("Undefined Class in Parts list" + part.getClass());
            }

        });

    }
}
