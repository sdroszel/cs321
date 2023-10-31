package cs.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class DataEntryScreen extends Application {

    static PNW businessObject;
    static DataEntry dataEntry;

    public static void main(String[] args) {
        businessObject = new PNW();
        dataEntry = new DataEntry();

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Immigration Application");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Input Fields
        TextField petitionerFirstName = new TextField();
        TextField petitionerLastName = new TextField();
        TextField aNumber = new TextField();
        TextField beneficiaryFirstName = new TextField();
        TextField beneficiaryLastName = new TextField();
        TextField dobDay = new TextField();
        TextField dobMonth = new TextField();
        TextField dobYear = new TextField();

        grid.add(new Label("Petitioner First Name:"), 0, 0);
        grid.add(petitionerFirstName, 1, 0);
        grid.add(new Label("Petitioner Last Name:"), 0, 1);
        grid.add(petitionerLastName, 1, 1);
        grid.add(new Label("A-Number:"), 0, 2);
        grid.add(aNumber, 1, 2);
        grid.add(new Label("Beneficiary First Name:"), 0, 3);
        grid.add(beneficiaryFirstName, 1, 3);
        grid.add(new Label("Beneficiary Last Name:"), 0, 4);
        grid.add(beneficiaryLastName, 1, 4);
        grid.add(new Label("Date of Birth (DD MM YYYY):"), 0, 5);
        grid.add(dobDay, 1, 5);
        grid.add(dobMonth, 2, 5);
        grid.add(dobYear, 3, 5);

        // Buttons
        Button checkDatabaseButton = new Button("Check Database");
        Button submitButton = new Button("Submit");

        checkDatabaseButton.setOnAction(e -> {

           boolean result = businessObject.checkDatabase(aNumber.getText());

           if (aNumber.getText().isEmpty()) {
               Alert alert = new Alert(Alert.AlertType.NONE, "A-Number field is empty. Please enter a valid A-Number", ButtonType.OK);
               alert.show();
           }
           else if (result) {
               Alert alert = new Alert(Alert.AlertType.NONE, "A-Number already exists. Cannot process petition.", ButtonType.OK);
               alert.show();
               for (TextField textField : Arrays.asList(petitionerFirstName, petitionerLastName, aNumber, beneficiaryFirstName, beneficiaryLastName, dobDay, dobMonth, dobYear)) {
                   textField.clear();
               }
           }
           else {
               Alert alert = new Alert(Alert.AlertType.NONE, "A-Number not found in database. Proceed to submit petition.", ButtonType.OK);
               alert.show();
               submitButton.setDisable(false);
           }
        });

        submitButton.setOnAction(e -> {
            dataEntry.setPetitionerFirstName(petitionerFirstName.getText());
            dataEntry.setPetitionerLastName(petitionerLastName.getText());
            dataEntry.setANumber(aNumber.getText());
            dataEntry.setBeneficiaryFirstName(beneficiaryFirstName.getText());
            dataEntry.setBeneficiaryLastName(beneficiaryLastName.getText());
            dataEntry.setDobDay(dobDay.getText());
            dataEntry.setDobMonth(dobMonth.getText());
            dataEntry.setDobYear(dobYear.getText());

            String result = businessObject.validateEntry(dataEntry.getPetition());

            Alert alert;
            if (result.isEmpty()) {
                alert = new Alert(Alert.AlertType.NONE, "Petition added to the database and workflow.", ButtonType.OK);

                for (TextField textField : Arrays.asList(petitionerFirstName, petitionerLastName, aNumber, beneficiaryFirstName, beneficiaryLastName, dobDay, dobMonth, dobYear)) {
                    textField.clear();
                }

                dataEntry.clearScreen();
                submitButton.setDisable(true);
            }
            else {
                alert = new Alert(Alert.AlertType.NONE, result, ButtonType.OK);
            }
            alert.show();
        });

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(checkDatabaseButton, submitButton);
        grid.add(buttonBox, 1, 6);

        submitButton.setDisable(true);

        grid.setBackground(Background.fill(Color.IVORY));

        Scene scene = new Scene(grid, 700, 300);
        stage.setScene(scene);
        stage.show();
    }
}
