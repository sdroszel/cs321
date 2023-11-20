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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * This is the Data Entry screen using JavaFX. It accepts user input and
 * allows a user to check if beneficiary already exists and submit to database and workflow.
 *
 * @author Scott Roszel
 */

public class DataEntryScreen extends Application {
    private final SharedData sharedData;
    private PNW businessObject;
    private DataEntry dataEntry;

    private  Stage stage;
    private  Scene dataEntryScene;
    private  Scene checkDatabaseScene;

    /**
     * Main method to create new BO and DataEntry objects
     * @param args default arguments
     */
    public static void main(String[] args) {


        launch(args);
    }

    public DataEntryScreen(SharedData shared) {
        this.sharedData = shared;
    }

    @Override
    public void start(Stage primaryStage) {
        businessObject = sharedData.getBusinessObject();
        dataEntry = new DataEntry();
        stage = primaryStage;
        // window title
        primaryStage.setTitle("Immigration Application");

        createCheckDatabaseScene();


        stage.setScene(checkDatabaseScene);
        stage.show();
    }

    private void createDataEntryScene(String aNum) {
        Text title = new Text("Enter Petition Data");
        title.setFont(Font.font("Arial", 16));

        // setup grid to hold labels and text-fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.fill(Color.IVORY));

        // Input Fields
        TextField petitionerFirstName = new TextField();
        TextField petitionerLastName = new TextField();
        TextField aNumber = new TextField(aNum);
        TextField beneficiaryFirstName = new TextField();
        TextField beneficiaryLastName = new TextField();
        TextField dobDay = new TextField();
        TextField dobMonth = new TextField();
        TextField dobYear = new TextField();

        aNumber.setDisable(true);

        // add labels and text-fields to the grid
        grid.add(title, 0, 0, 2, 1);
        grid.add(new Label("Petitioner First Name:"), 0, 1);
        grid.add(petitionerFirstName, 1, 1);
        grid.add(new Label("Petitioner Last Name:"), 0, 2);
        grid.add(petitionerLastName, 1, 2);
        grid.add(new Label("A-Number:"), 0, 3);
        grid.add(aNumber, 1, 3);
        grid.add(new Label("Beneficiary First Name:"), 0, 4);
        grid.add(beneficiaryFirstName, 1, 4);
        grid.add(new Label("Beneficiary Last Name:"), 0, 5);
        grid.add(beneficiaryLastName, 1, 5);
        grid.add(new Label("Date of Birth (MM DD YYYY):"), 0, 6);
        grid.add(dobMonth, 1, 6);
        grid.add(dobDay, 2, 6);
        grid.add(dobYear, 3, 6);



        // create buttons
        Button backButton = new Button("Back");
        Button submitButton = new Button("Submit");

        backButton.setOnAction(event -> stage.setScene(checkDatabaseScene));

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
            if (result == null) {
                alert = new Alert(Alert.AlertType.NONE, "Petition added to the database and workflow.", ButtonType.OK);

                // clear text-fields
                for (TextField textField : Arrays.asList(petitionerFirstName, petitionerLastName, aNumber, beneficiaryFirstName, beneficiaryLastName, dobDay, dobMonth, dobYear)) {
                    textField.clear();
                }

                // reset petition object data
                dataEntry.clearScreen();

                stage.setScene(checkDatabaseScene);
            }
            else {
                // alert displays error location
                alert = new Alert(Alert.AlertType.NONE, result, ButtonType.OK);
            }
            alert.show();
        });

        // create horizontal box to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(backButton, submitButton);
        grid.add(buttonBox, 1, 7);


        dataEntryScene = new Scene(grid, 700, 350);

    }

    private void createCheckDatabaseScene() {
        Text title = new Text("Check database for A-Number");
        title.setFont(Font.font("Arial", 16));
        // setup grid to hold labels and text-fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.fill(Color.IVORY));

        TextField aNumber = new TextField();

        grid.add(title, 0, 0, 2, 1);
        grid.add(new Label("A-Number:"), 0, 2);
        grid.add(aNumber, 1, 2);

        Button checkDatabaseButton = new Button("Check Database");
        Button backButton = new Button("Back");

        backButton.setOnAction(event -> {
            MenuScreen menuScreen = new MenuScreen();
            menuScreen.start(stage);
        });

        // checkDatabase button click event
        checkDatabaseButton.setOnAction(event -> {

            boolean nonDigit = false;

            // variable to hold result of database check
            boolean result = businessObject.checkDatabase(aNumber.getText());

            // create a new alert
            Alert alert;

            // check if A-Number is empty
            if (aNumber.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.NONE, "A-Number field is empty. Please enter a valid A-Number", ButtonType.OK);
                alert.show();
            }
            // check if A-Number already exists
            else if (result) {
                alert = new Alert(Alert.AlertType.NONE, "A-Number already exists. Cannot process petition.", ButtonType.OK);
                alert.show();
                aNumber.clear();
            }
            // A-Number not found in database
            else {
                char[] string;
                string = aNumber.getText().toCharArray();

                for (char c : string) {
                    if (!Character.isDigit(c)) {
                        alert = new Alert(Alert.AlertType.NONE, "A-Number can only contain numbers", ButtonType.OK);
                        alert.show();
                        aNumber.clear();
                        nonDigit = true;
                        break;
                    }
                }

                if (!nonDigit) {
                    createDataEntryScene(aNumber.getText());
                    aNumber.clear();
                    stage.setScene(dataEntryScene);
                }
                else {
                    aNumber.clear();
                    stage.setScene(checkDatabaseScene);
                }

            }
        });

        // create horizontal box to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(backButton, checkDatabaseButton);
        grid.add(buttonBox, 1, 3);

        checkDatabaseScene = new Scene(grid, 500, 200);
    }
}
