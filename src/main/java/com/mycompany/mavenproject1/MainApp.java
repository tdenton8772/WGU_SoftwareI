package com.mycompany.mavenproject1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class AddPartStage {
    AddPartStage() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddPart.fxml"));
        Stage subStage = new Stage();
        subStage.setTitle("Add Part");

        Scene scene = new Scene(root, 400, 300);
        
        subStage.setScene(scene);
        subStage.show();
        
    }
}

class ModifyPartStage {
    ModifyPartStage() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ModifyPart.fxml"));
        Stage subStage = new Stage();
        subStage.setTitle("Modify Part");

        Scene scene = new Scene(root, 400, 300);
        
        subStage.setScene(scene);
        subStage.show();
        
    }
}

class AddProductStage {
    AddProductStage() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddProduct.fxml"));
        Stage subStage = new Stage();
        subStage.setTitle("Add Product");

        Scene scene = new Scene(root, 1000, 600);
        
        subStage.setScene(scene);
        subStage.show();
        
    }
}

class ModifyProductStage {
    ModifyProductStage() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ModifyProduct.fxml"));
        Stage subStage = new Stage();
        subStage.setTitle("Modify Product");

        Scene scene = new Scene(root, 1000, 600);
        
        subStage.setScene(scene);
        subStage.show();
        
    }
}

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainScreen.fxml"));
    
        Scene scene = new Scene(root, 1200, 400);
    
        stage.setTitle("");
        stage.setScene(scene);
        
        stage.show();
    }

    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
