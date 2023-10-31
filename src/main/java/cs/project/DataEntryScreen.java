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

/**
 * This is the Data Entry screen using JavaFX. It accepts user input and
 * allows a user to check if beneficiary already exists and submit to database and workflow.
 *
 * @author Scott Roszel
 */

public class DataEntryScreen extends Application {

    private static PNW businessObject;
    private static DataEntry dataEntry;

    /**
     * Main method to create new BO and DataEntry objects
     * @param args default arguments
     */
    public static void main(String[] args) {
        businessObject = new PNW();
        dataEntry = new DataEntry();

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // window title
        stage.setTitle("Immigration Application");

        // setup grid to hold labels and text-fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
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

        // add labels and text-fields to the grid
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

        // create buttons
        Button checkDatabaseButton = new Button("Check Database");
        Button submitButton = new Button("Submit");

        // checkDatabase button click event
        checkDatabaseButton.setOnAction(event -> {

            // variable to hold result of database check
            boolean result = businessObject.checkDatabase(aNumber.getText());

            // create a new alert
            Alert alert;

            // check if A-Number is empty
            if (aNumber.getText().isEmpty()) {
               alert = new Alert(Alert.AlertType.NONE, "A-Number field is empty. Please enter a valid A-Number", ButtonType.OK);
            }
            // check if A-Number already exists
            else if (result) {
                alert = new Alert(Alert.AlertType.NONE, "A-Number already exists. Cannot process petition.", ButtonType.OK);

                for (TextField textField : Arrays.asList(petitionerFirstName, petitionerLastName, aNumber, beneficiaryFirstName, beneficiaryLastName, dobDay, dobMonth, dobYear)) {
                    textField.clear();
                }
            }
            // A-Number not found in database
            else {
                alert = new Alert(Alert.AlertType.NONE, "A-Number not found in database. Proceed to submit petition.", ButtonType.OK);

                submitButton.setDisable(false);
            }

            // show alert
            alert.show();
        });

        // submit button click event
        submitButton.setOnAction(event -> {

            // add text-fields to petition object
            dataEntry.setPetitionerFirstName(petitionerFirstName.getText());
            dataEntry.setPetitionerLastName(petitionerLastName.getText());
            dataEntry.setANumber(aNumber.getText());
            dataEntry.setBeneficiaryFirstName(beneficiaryFirstName.getText());
            dataEntry.setBeneficiaryLastName(beneficiaryLastName.getText());
            dataEntry.setDobDay(dobDay.getText());
            dataEntry.setDobMonth(dobMonth.getText());
            dataEntry.setDobYear(dobYear.getText());

            // store result of validation
            String result = businessObject.validateEntry(dataEntry.getPetition());

            // create alert
            Alert alert;

            // check if validation is valid
            if (result.isEmpty()) {
                alert = new Alert(Alert.AlertType.NONE, "Petition added to the database and workflow.", ButtonType.OK);

                // clear text-fields
                for (TextField textField : Arrays.asList(petitionerFirstName, petitionerLastName, aNumber, beneficiaryFirstName, beneficiaryLastName, dobDay, dobMonth, dobYear)) {
                    textField.clear();
                }

                // reset petition object data
                dataEntry.clearScreen();

                // enable submit button
                submitButton.setDisable(true);
            }
            else {
                // alert displays error location
                alert = new Alert(Alert.AlertType.NONE, result, ButtonType.OK);
            }

            alert.show();
        });

        // create horizontal box to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(checkDatabaseButton, submitButton);
        grid.add(buttonBox, 1, 6);

        // disable submit button for next petition
        submitButton.setDisable(true);

        grid.setBackground(Background.fill(Color.IVORY));

        Scene scene = new Scene(grid, 700, 300);
        stage.setScene(scene);
        stage.show();
    }
}
