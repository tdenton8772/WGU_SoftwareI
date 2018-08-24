package com.mycompany.mavenproject1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

class GetMainStage {

    GetMainStage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainScreen.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerMain controller = fxmlLoader.getController();
        Stage subStage = new Stage();
        subStage.setTitle("");
        Scene scene = new Scene(root, 1200, 400);
        subStage.setScene(scene);
        subStage.show();
    }
}

class AddPartStage {

    AddPartStage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddPart.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerAddPart controller = fxmlLoader.getController();
        Stage subStage = new Stage();
        subStage.setTitle("Add Part");
        Scene scene = new Scene(root, 400, 300);
        subStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    new GetMainStage();
                    event.consume();
                    subStage.close();
                } catch (Exception ex) {
                    System.out.println("Error Launching main screen");
                }
            }
        });
        subStage.setScene(scene);
        subStage.show();
    }
}

class ModifyPartStage {

    ModifyPartStage(Part part) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ModifyPart.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerModifyPart controller = fxmlLoader.getController();
        controller.storePart(part);
        Stage subStage = new Stage();
        subStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    new GetMainStage();
                    event.consume();
                    subStage.close();
                } catch (Exception ex) {
                    System.out.println("Error Launching main screen");
                }
            }
        });
        subStage.setTitle("Modify Part");
        Scene scene = new Scene(root, 400, 300);
        scene.setUserData(part);
        subStage.setScene(scene);
        subStage.setUserData(part);
        subStage.show();
    }
}

class AddProductStage {

    AddProductStage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddProduct.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerAddProduct controller = fxmlLoader.getController();
        Stage subStage = new Stage();
        subStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    new GetMainStage();
                    event.consume();
                    subStage.close();
                } catch (Exception ex) {
                    System.out.println("Error Launching main screen");
                }
            }
        });
        subStage.setTitle("Add Product");
        Scene scene = new Scene(root, 1000, 600);
        subStage.setScene(scene);
        subStage.show();
    }
}

class ModifyProductStage {

    ModifyProductStage(Product product) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ModifyProduct.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ControllerModifyProduct controller = fxmlLoader.getController();
        System.out.println("Got Here");
        controller.storeProduct(product);
        
        Stage subStage = new Stage();
        subStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                try {
                    new GetMainStage();
                    event.consume();
                    subStage.close();
                } catch (Exception ex) {
                    System.out.println("Error Launching main screen");
                }
            }
        });
        subStage.setTitle("Modify Product");
        Scene scene = new Scene(root, 1000, 600);
        subStage.setScene(scene);
        subStage.show();
    }
}

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Inventory inventory = Inventory.getInstance();
        InHouse part = new InHouse(1, "Test", 1d, 1, 1, 1, 1);
        inventory.addPart(part);
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
