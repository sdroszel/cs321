package cs.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {

    private final SharedData sharedData;
    private PNW businessObject;

    public Test(SharedData shared) {
        this.sharedData = shared;
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a button
        Button checkDatabaseButton = new Button("Check Database");

        // Event handler for button click
        checkDatabaseButton.setOnAction(e -> {
            // Replace this with your database checking logic
            System.out.println("Checking the database...");
            // You can put your database checking code here
        });

        // Create a layout and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(checkDatabaseButton);

        // Create a scene
        Scene scene = new Scene(root, 300, 250);

        // Set the scene to the stage and display the stage
        primaryStage.setTitle("Check Database");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
