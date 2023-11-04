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
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * This is the Approval screen made using JavaFX. It will display the
 * petition data and allow the user to either accept or reject it.
 *
 * @author Victor Londono
 */
public class ApprovalScreen extends Application {

    private final SharedData sharedData;
    private PNW businessObject;
    private Approval approval;
    private Petition petition;


    public static void main(String[] args) {
        launch();
    }

    public static void launchApp(ApprovalScreen as) {

    }
    /**
     * Take petition with current data.
     *
     * @param sd shared data among classes.
     */
    public ApprovalScreen(SharedData sd) {
        this.sharedData = sd;
        approval = new Approval();
    }

    @Override
    public void start(Stage stage) {

//        petition = new Petition();
//        petition.setANumber("1234");
//        petition.setPetitionerFirstName("Victor");
//        petition.setPetitionerLastName("Londono");
//        petition.setBeneficiaryFirstName("John");
//        petition.setBeneficiaryLastName("Doe");
//        petition.setDobMonth(10);
//        petition.setDobDay(31);
//        petition.setDobYear(1983);

        businessObject = sharedData.getBusinessObject();
        petition = businessObject.getPetitionFromDatabase("0123");

        // window title
        stage.setTitle("Immigration Application");

        // setup grind to hole data
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

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

        // Create buttons
        Button acceptButton = new Button("Accept");
        acceptButton.setOnAction(e -> {
            // Handle accept action
            stage.close();
        });

        Button rejectButton = new Button("Reject");
        rejectButton.setOnAction(e -> {
            // Handle reject action
            stage.close();
        });


        // create horizontal box to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(acceptButton, rejectButton);
        grid.add(buttonBox, 0, 6);

        grid.setBackground(Background.fill(Color.IVORY));

        Scene scene = new Scene(grid, 300, 300);
        stage.setScene(scene);
        stage.show();


    }
}
