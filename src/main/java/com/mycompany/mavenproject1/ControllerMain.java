package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.AddPartStage;
import com.mycompany.mavenproject1.AddProductStage;
import com.mycompany.mavenproject1.Inventory;
import com.mycompany.mavenproject1.ModifyPartStage;
import com.mycompany.mavenproject1.ModifyProductStage;
import com.mycompany.mavenproject1.Part;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    @FXML
    TableView tbl_products;

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
    protected void handleExit(ActionEvent event) {
        try {
            System.out.println("Exit pushed");
            Platform.exit();

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
            if (tbl_parts.getSelectionModel().getSelectedItem() != null) {
                Part part = (Part) tbl_parts.getSelectionModel().getSelectedItem();
                new ModifyPartStage(part);
                Stage stage = (Stage) btn_addPart.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Nothing Selected");
            }

        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleDeletePart(ActionEvent event) {
        try {
            Inventory inventory = Inventory.getInstance();
            Part part = (Part) tbl_parts.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("You are deleting part: " + part.getName());
            alert.setContentText("Are you sure you want to do this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                boolean deleted = inventory.deletePart(part);
                System.out.println("Delete Part was pushed: " + deleted);
                updateTable();
            } else {
                System.out.println("User decided to not delete part: "+part.getName());
            }

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
