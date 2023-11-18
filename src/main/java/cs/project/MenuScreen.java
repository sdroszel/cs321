package cs.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

        Text title = new Text("USCIS Employee Portal");
        title.setFont(Font.font("Arial", 16));

        // setup grid to hold labels and text-fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.fill(Color.IVORY));

        grid.add(title, 0, 0, 3, 1);

        Button dataEntryButton = new Button("Data Entry");
        Button reviewButton = new Button("Review");
        Button approvalButton = new Button("Approval");

        dataEntryButton.setOnAction(event -> {
            SharedData sharedData = SharedData.getInstance();
            DataEntryScreen dataEntryScreen = new DataEntryScreen(sharedData);
            dataEntryScreen.start(stage);
        });

        reviewButton.setOnAction(event -> {
            SharedData sharedData = SharedData.getInstance();
            ReviewScreen reviewScreen = new ReviewScreen(sharedData);
            reviewScreen.start(stage);
        });

        approvalButton.setOnAction(event -> {
            SharedData sd = SharedData.getInstance();
            ApprovalScreen as = new ApprovalScreen(sd);
            as.start(stage);
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(dataEntryButton, reviewButton, approvalButton);

        grid.add(buttonBox, 0, 2);

        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);
        stage.show();
    }
}
