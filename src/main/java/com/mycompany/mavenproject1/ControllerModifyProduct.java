/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author tdenton
 */
public class ControllerModifyProduct implements Initializable {

    @FXML
    private GridPane root;
    @FXML
    private TableView tbl_parts;

    private Product product;

    @FXML
    private TableView tbl_added_parts;

    @FXML
    private Button cancelButton;

    private List<Part> tempPartList = new ArrayList<>();

    @FXML
    private TextField txt_prodID;
    @FXML
    private TextField txt_prodName;
    @FXML
    private TextField txt_prodInv;
    @FXML
    private TextField txt_prodPrice;
    @FXML
    private TextField txt_prodMin;
    @FXML
    private TextField txt_prodMax;

    public void storeProduct(Product product) {
        this.product = product;
    }

    @FXML
    protected void handleModifyProductSearchPart(ActionEvent event) {
        try {
            System.out.println("Add Product Part Search pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Part Seach pressed");
        }
    }

    @FXML
    protected void handleModifyProductAddPart(ActionEvent event) {
        try {
            Part part = (Part) tbl_parts.getSelectionModel().getSelectedItem();

            if (tempPartList.contains(part)) {
                System.out.println("Part already on this product");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Add Part Error");
                alert.setContentText("Part already added to this BOM");
                alert.showAndWait();
            } else {
                if (part != null) {
                    tempPartList.add(part);
                }
            }
            tbl_added_parts.refresh();
            System.out.println("Add Product Add Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Add Part pressed");
        }
    }

    @FXML
    protected void handleModifyProductDelete(ActionEvent event) {
        try {
            Part part = (Part) tbl_added_parts.getSelectionModel().getSelectedItem();
            tempPartList.remove(part);
            tbl_added_parts.refresh();
            System.out.println("Add Product Delete Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Delete Part pressed");
        }
    }

    public class ValidateReturn {

        boolean validated = true;
        String messageCode = "";
    }

    private ValidateReturn ValidatePart(String name, String inv, String price, String min, String max) {
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
        return object;
    }

    @FXML
    protected void handleModifyProductSave(ActionEvent event) {

        ValidateReturn returnObject = ValidatePart(txt_prodName.getText(), txt_prodInv.getText(), txt_prodPrice.getText(), txt_prodMin.getText(), txt_prodMax.getText());

        if (returnObject.validated == false) {
            System.out.println(returnObject.messageCode);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modify Part Error");
            alert.setHeaderText("Data Validation Error");
            alert.setContentText(returnObject.messageCode);
            alert.showAndWait();

        } else {
            try {
                String prod_Name = txt_prodName.getText();
                int prod_Inv = Integer.parseInt(txt_prodInv.getText());
                Double prod_Price = Double.parseDouble(txt_prodPrice.getText());
                int prod_Min = Integer.parseInt(txt_prodMin.getText());
                int prod_Max = Integer.parseInt(txt_prodMax.getText());
                ArrayList<Part> partList = (ArrayList) this.tempPartList;

                Inventory inventory = Inventory.getInstance();
                int prod_ID = inventory.getNextProductID();
                Product product = new Product(prod_ID, prod_Name, prod_Price, prod_Inv, prod_Min, prod_Max, partList);
                inventory.addProduct(product);

                System.out.println("Add Product Save Part pressed");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                new GetMainStage();
            } catch (Exception ex) {
                System.out.println("Error: Add Product Save Part pressed");
            }
        }
    }

    @FXML
    protected void handleModifyProductCancel(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Are you sure you want to cancel?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.println("Add Part: Cancel was pushed");
                new GetMainStage();
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("User decided to not Cancel");
            }
        } catch (Exception ex) {
            System.out.println("Error: Add Product Cancel Part pressed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inventory inventory = Inventory.getInstance();
        tbl_parts.setItems(FXCollections.observableList(inventory.getPartList()));
        tbl_added_parts.setItems(FXCollections.observableList(this.tempPartList));
        
        root.sceneProperty().addListener((observable, oldValue, newValue) -> {
            txt_prodID.setText(Integer.toString(this.product.getProductID()));
            txt_prodName.setText(this.product.getName());
            txt_prodInv.setText(Integer.toString(this.product.getInStock()));
            txt_prodPrice.setText(Double.toString(this.product.getPrice()));
            txt_prodMin.setText(Integer.toString(this.product.getMin()));
            txt_prodMax.setText(Integer.toString(this.product.getMax()));
            for(Part part: this.product.getAssociatedPartList()){
                System.out.println(part);
                this.tempPartList.add(part);
            };
            tbl_added_parts.refresh();
        });
    }
}
