package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.text.Text;

public class FXMLController implements Initializable {
    @FXML
    private Text actiontarget;
    
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
        actiontarget.setText("Sign in button pressed");
    }
    
    @FXML
    protected void handleAddPartStageAction(ActionEvent event) {

        try {    
            new AddPartStage();
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    @FXML
    protected void handleModifyPartStageAction(ActionEvent event) {

        try {    
            new ModifyPartStage();
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    @FXML
    protected void handleAddProductStageAction(ActionEvent event) {

        try {    
            new AddProductStage();
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    @FXML
    protected void handleModifyProductStageAction(ActionEvent event) {

        try {    
            new ModifyProductStage();
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
