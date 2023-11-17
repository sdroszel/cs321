package cs.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;


/**
 * This is the Approval screen made using JavaFX. It will display the
 * petition data and allow the user to either accept or reject it.
 *
 * @author Victor Londono
 */
public class ApprovalScreen extends Application {

    private final SharedData sharedData;
    private Approval approval;
    private  Stage stage;
    PNW businessObject;
    Petition petition;


    /**
     * Take petition with current data.
     *
     * @param sd shared data among classes.
     */
    public ApprovalScreen(SharedData sd) {
        this.sharedData = sd;
        approval = new Approval();
        businessObject = sharedData.getBusinessObject();
    }

    @Override
    public void start(Stage stage) {

        // window title
        stage.setTitle("Immigration Application");

        // setup grind to hole data
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Create buttons
        Button acceptButton = new Button("Accept");
        acceptButton.setOnAction(e -> {

            businessObject.removeFromApproval(petition.getaNumber());

            TextInputDialog dialog = new TextInputDialog("Email");
            dialog.setTitle("Confirmation");
            dialog.setHeaderText("Petition has been submitted, enter email to receive confirmation.");
            Optional<String> result = dialog.showAndWait();
            petition = null;
            start(stage);
        });
        acceptButton.setDisable(true);

        Button rejectButton = new Button("Reject");
        rejectButton.setOnAction(e -> {
            // Handle reject action
            petition = null;
            stage.close();
        });
        rejectButton.setDisable(true);

        Button getNextButton = new Button("Load Petition");
        getNextButton.setOnAction(e -> {
            petition = businessObject.getNextFromApproval();

            Alert alert;

            if (petition == null) {
                alert = new Alert(Alert.AlertType.NONE, "No petition in queue.", ButtonType.OK);
                alert.setTitle("Error");
                alert.showAndWait();
            } else {
                // Extract info from petition
                String petFirstName = petition.getPetitionerFirstName();
                String petLastName = petition.getPetitionerLastName();
                String aNumber = petition.getaNumber();
                String benFirstName = petition.getBeneficiaryFirstName();
                String benLastName = petition.getBeneficiaryLastName();

                // Combine DOB
                String dob = petition.getDobMonth() + "/" +
                        petition.getDobDay() + "/" +
                        petition.getDobYear();

                // Create Text Objects
                Text petFNText = new Text("Petitioner First Name: " + petFirstName);
                Text petLNText = new Text("Petitioner Last Name: " + petLastName);
                Text aNumText = new Text("A-Number: " + aNumber);
                Text benFNText = new Text("Beneficiary First Name: " + benFirstName);
                Text benLNText = new Text("Beneficiary Last Name: " + benLastName);
                Text dobText = new Text("Date of Birth: " + dob);

                // add labels and text-fields to the grid
                grid.add(petFNText, 0, 0);
                grid.add(petLNText, 0, 1);
                grid.add(aNumText, 0, 2);
                grid.add(benFNText, 0, 3);
                grid.add(benLNText, 0, 4);
                grid.add(dobText, 0, 5);

                acceptButton.setDisable(false);
                rejectButton.setDisable(false);
                getNextButton.setDisable(true);

            }


        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            MenuScreen menuScreen = new MenuScreen();
            menuScreen.start(stage);
        });


        // create horizontal box to hold buttons
        VBox buttonBox1 = new VBox(10);
        buttonBox1.getChildren().addAll(getNextButton, acceptButton, rejectButton, backButton);
        grid.add(buttonBox1, 0, 6);

        grid.setBackground(Background.fill(Color.IVORY));

        Scene scene = new Scene(grid, 300, 300);
        stage.setScene(scene);
        stage.show();


    }
}
