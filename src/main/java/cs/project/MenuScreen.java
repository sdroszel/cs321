package cs.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage;
        stage = primaryStage;
        primaryStage.setTitle("Main Menu");

        Button dataEntryButton = new Button("Data Entry");
        Button reviewButton = new Button("Review");
        Button approvalButton = new Button("Approval");

        dataEntryButton.setOnAction(event -> {
            SharedData sharedData = SharedData.getInstance();
            DataEntryScreen dataEntryScreen = new DataEntryScreen(sharedData);
            dataEntryScreen.start(stage);
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(dataEntryButton, reviewButton, approvalButton);

        buttonBox.setBackground(Background.fill(Color.IVORY));

        Scene scene = new Scene(buttonBox, 300, 100);
        primaryStage.setScene(scene);
        stage.show();
    }
}
