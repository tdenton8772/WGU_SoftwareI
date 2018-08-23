package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerMain implements Initializable {
//    test page
    @FXML
    private GridPane root;
    
    @FXML
    private TableView tbl_parts;
    
    @FXML TableView tbl_products;
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField userName;
    @FXML
    private Button btn_addPart;
    
    protected void updateTable() {
        System.out.println("Refresh Table");
        tbl_parts.refresh();
    }
    
    @FXML
    protected void handleKeyInput(ActionEvent event) {
        System.out.println("Pressed");
    }

    @FXML
    protected void handleAboutAction(ActionEvent event) {
        System.out.println("About");
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText(userName.getText());
    }
    
    
    
    @FXML
    protected void handleExit(ActionEvent event) {
        try {
            System.out.println("Exit pushed");
        } catch (Exception ex) {
            System.out.println("Error: Exit pressed");
        }
    }

    @FXML
    protected void handlePartSearch(ActionEvent event) {
        try {
            System.out.println("Pressed Part Search");
        } catch (Exception ex) {
            System.out.println("Error: Part search pressed");
        }
    }

    @FXML
    protected void handleAddPartStageAction(ActionEvent event) {
        try {
            new AddPartStage();
            Stage stage = (Stage) btn_addPart.getScene().getWindow();
            stage.close();
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleModifyPartStageAction(ActionEvent event) {
        try {
            new ModifyPartStage();
            Stage stage = (Stage) btn_addPart.getScene().getWindow();
            stage.close();
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleDeletePart(ActionEvent event) {
        try {
            Inventory inventory = Inventory.getInstance();
            Part part = (Part) tbl_parts.getSelectionModel().getSelectedItem();
            boolean deleted = inventory.deletePart(part);
            System.out.println("Delete Part was pushed: "+ deleted);
            updateTable();
        } catch (Exception ex) {
            System.out.println("Error: Delete Part was pushed");
        }
    }

    @FXML
    protected void handleProductSearch(ActionEvent event) {
        try {
            System.out.println("Pressed Product Search");
        } catch (Exception ex) {
            System.out.println("Error: Product search pressed");
        }
    }

    @FXML
    protected void handleAddProductStageAction(ActionEvent event) {
        try {
            new AddProductStage();
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleModifyProductStageAction(ActionEvent event) {
        try {
            new ModifyProductStage();
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleDeleteProduct(ActionEvent event) {
        try {
            System.out.println("Delete Product was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Delete Product was pushed");
        }
    }

    @FXML
    protected void handleModifyProductSearchPart(ActionEvent event) {
        try {
            System.out.println("Modify Product Part Search pressed");
        } catch (Exception ex) {
            System.out.println("Error: Modify Product Part Seach pressed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inventory inventory = Inventory.getInstance();
        
        tbl_parts.setItems(FXCollections.observableList(inventory.getPartList()));
        
        
    }
}
