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

public class ControllerMain implements Initializable {
//    test page
    @FXML private Text actiontarget;
    @FXML private TextField userName;
    
    
    
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
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleModifyPartStageAction(ActionEvent event) {
        try {
            new ModifyPartStage();
        } catch (Exception ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleDeletePart(ActionEvent event) {
        try {
            System.out.println("Delete Part was pushed");
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
        // TODO
    }
}
