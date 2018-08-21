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
    protected void handleAddPartSave(ActionEvent event) {
        try {
            System.out.println("Add Part: Save was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Add Part Save was pushed");
        }
    }

    @FXML
    protected void handleAddPartCancel(ActionEvent event) {
        try {
            System.out.println("Add Part: Cancel was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Add Part Cancel was pushed");
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

    @FXML
    protected void handleDeleteProduct(ActionEvent event) {
        try {
            System.out.println("Delete Product was pushed");
        } catch (Exception ex) {
            System.out.println("Error: Delete Product was pushed");
        }
    }

    @FXML
    protected void handleAddProductSearchPart(ActionEvent event) {
        try {
            System.out.println("Add Product Part Search pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Part Seach pressed");
        }
    }

    @FXML
    protected void handleAddProductAddPart(ActionEvent event) {
        try {
            System.out.println("Add Product Add Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Add Part pressed");
        }
    }

    @FXML
    protected void handleAddProductDelete(ActionEvent event) {
        try {
            System.out.println("Add Product Delete Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Delete Part pressed");
        }
    }

    @FXML
    protected void handleAddProductSave(ActionEvent event) {
        try {
            System.out.println("Add Product Save Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Save Part pressed");
        }
    }

    @FXML
    protected void handleAddProductCancel(ActionEvent event) {
        try {
            System.out.println("Add Product Cancel Part pressed");
        } catch (Exception ex) {
            System.out.println("Error: Add Product Cancel Part pressed");
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
