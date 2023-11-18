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




/**
 * This is the Review screen using JavaFX. It
 * allows a user to first Review their data and then re-validate all data
 * @author Rashida Mohamed
 */

public class ReviewScreen extends Application {

	private final SharedData sharedData;
	private PNW businessObject;
	private Petition currentPetition;
	private Petition petition1;
	
	private Stage stage;
    private Scene firstScene;
    private Scene secondScene;
    private Scene thirdScene;
	private Scene fourthScene;
	
	
	//Labels to indicate status for each field
	private Label StatusPFN = new Label();
	private Label StatusPLN = new Label();
	private Label StatusBFN = new Label();
	private Label StatusBLN = new Label();
	private Label StatusDOB = new Label();


	/**
	 * Main method to create new BO and petition objects
	 * @param args default arguments
	 */
	public static void main(String[] args) {

		//javafx.application.Application.
		launch(args);

	}

	public ReviewScreen(SharedData shared) {
		this.sharedData = shared;
	}

	@Override
	public void start(Stage primaryStage) {
		businessObject = sharedData.getBusinessObject();
		// window title
		stage = primaryStage;

		stage.setTitle("Review and re-validate Immigration Application");


		String month = "";
		boolean result = true;
		Label dataverified = new Label("Data Verified");
		TextField aNumber = new TextField();
		String currentaN = aNumber.getText();



		// setup grid to hold labels and text-fields, first scene is the first screen that will appear to user
		GridPane grid1 = new GridPane();
		grid1.setAlignment(Pos.BASELINE_CENTER);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid1.setPadding(new Insets(25, 25, 25, 25));
		//grid1.add(new Label("Enter your A-Number to review your current data:"), 0, 0);
		//grid1.add(aNumber, 0, 1);

		//Button checkDatabaseButton = new Button("Check Database");
		//Button ReviewDataButton = new Button("Click here to review data");
		Button getNextFromWorkflow = new Button("Get from workflow");
		Button backButton = new Button("Back");





		getNextFromWorkflow.setOnAction(event -> {
			currentPetition = businessObject.getPetitionFromDatabase(businessObject.getWorkflow().removeFromReviewQueue());

			if (businessObject.getWorkflow().getReviewQueue().isEmpty()) {
				getNextFromWorkflow.setDisable(true);
			}

			switchToSecondScreen();
		});

		backButton.setOnAction(event -> {
			MenuScreen menuScreen = new MenuScreen();
			menuScreen.start(stage);
		});
/*
		// checkDatabase button click event
		checkDatabaseButton.setOnAction(event -> {

			// variable to hold result of database check

			boolean result1 = businessObject.checkDatabase(aNumber.getText());


			Alert alert1;

			// check if A-Number is empty
			if (aNumber.getText().isEmpty()) {
				alert1 = new Alert(Alert.AlertType.NONE, "A-Number field is empty. Please enter a valid A-Number", ButtonType.OK);
				ReviewDataButton.setDisable(true);
				alert1.showAndWait();

			}
			// check if A-Number exists in Database
			else if(result1){

				currentPetition = businessObject.getPetitionFromDatabase(aNumber.getText());
				ReviewDataButton.setDisable(false);

			}

			else {

				alert1 = new Alert(Alert.AlertType.NONE, "A-Number not found in database. Please enter a valid A-Number.", ButtonType.OK);
				ReviewDataButton.setDisable(true);
				alert1.showAndWait();
				aNumber.clear();

			}


		});
*/
/*

		// revalidate data button click event
		ReviewDataButton.setOnAction(event -> {

			switchToSecondScreen();
		});

 */
// create horizontal box to hold buttons
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(getNextFromWorkflow, backButton);
		grid1.add(buttonBox, 2, 0);
		grid1.setBackground(Background.fill(Color.IVORY));

		firstScene = new Scene(grid1, 700, 300);
		stage.setScene(firstScene);
		stage.show();
	}

	 String month = "";
     boolean result = true;
	
    private void switchToFirstScreen() {
        // Switch back to the first scene
        stage.setScene(firstScene);
		
    }
	
	
	 private void switchToSecondScreen() {
		 
		 
        // Switch to the second scene
		//this.businessObject = businessObject;
		//this.currentPetition = currentPetition;
		
		// setup grid to hold labels and text-fields, secondScene is the Second screen that will appear to user
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.BASELINE_CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
		grid2.add(new Label("The following is the current data associated with your petition: "), 0, 0);
		grid2.add(new Label ("aNumber: "+ this.currentPetition.getaNumber()), 0, 1);
		
		if(this.currentPetition != null){
			
			grid2.add(new Label ("Petitioner FirstName: "+ this.currentPetition.getPetitionerFirstName()), 0, 2);
			grid2.add(new Label ("Petitoner LastName: "+ this.currentPetition.getPetitionerLastName()), 0, 3);
			grid2.add(new Label ("Beneficiary FirstName: "+ this.currentPetition.getBeneficiaryFirstName()), 0, 4);
			grid2.add(new Label ("Beneficiary LastName: "+ this.currentPetition.getBeneficiaryLastName()), 0, 5);
			
			
			if(this.currentPetition.getDobMonth().equals("1")){
				month = "January";
			}
			
			if(this.currentPetition.getDobMonth().equals("2")){
				month = "February";
			}
			
			if(this.currentPetition.getDobMonth().equals("3")){
				month = "March";
			}
			
			if(this.currentPetition.getDobMonth().equals("4")){
				month = "April";
			}
			
			if(this.currentPetition.getDobMonth().equals("5")){
				month = "May";
			}
			
			if(this.currentPetition.getDobMonth().equals("6")){
				month = "June";
			}
			
			if(this.currentPetition.getDobMonth().equals("7")){
				month = "July";
			}
			
			if(this.currentPetition.getDobMonth().equals("8")){
				month = "August";
			}
			
			if(this.currentPetition.getDobMonth().equals("9")){
				month = "September";
			}
			
			if(this.currentPetition.getDobMonth().equals("10")){
				month = "October";
			}
			
			if(this.currentPetition.getDobMonth().equals("11")){
				month = "November";
			}
			
			
			if(this.currentPetition.getDobMonth().equals("12")){
				month = "December";
			}
			
			grid2.add(new Label ("Date of Birth: "+ month + ","+this.currentPetition.getDobDay()+","+this.currentPetition.getDobYear()), 0, 6);
			
		}
		
		
		
		//Button to revalidate data
		Button revalidate = new Button("Click here to re-validate data");
		
		
		
		
		// revalidate data button click event
        revalidate.setOnAction(event -> {
			
			switchToThirdScreen();
		});
		
		
		// create horizontal box to hold buttons
        HBox buttonBox2 = new HBox(10);
        buttonBox2.getChildren().addAll(revalidate);
        grid2.add(buttonBox2, 0, 7);
		grid2.setBackground(Background.fill(Color.IVORY));
        secondScene = new Scene(grid2, 1200, 600);
	
	
		
		
        stage.setScene(secondScene);
		
    }
    
    private void switchToThirdScreen() {
        // Switch back to third scene
		
		 //this.currentPetition = currentPetition;
		 //this.businessObject = businessObject;
		 
		//Buttons to confirm each data in third stage
        Button confirmFName = new Button("Click here to confirm Petitioner first name");
		Button confirmLName = new Button("Click here to confirm  Petitioner last name");
		Button confirmBFName = new Button("Click here to confirm Beneficiary first name");
		Button confirmBLName = new Button("Click here to confirm Beneficiary last name");
		Button confirmDob = new Button("Click here to confirm date of day of birth");
		Button submitReview = new Button("Submit review");
		
		
		
		//Labels to indicate status for each field
		Label StatusPFN = new Label();
		Label StatusPLN = new Label();
		Label StatusBFN = new Label();
		Label StatusBLN = new Label();
		Label StatusDOB = new Label();
		
		
		

		
		// Input Fields for third stage
        TextField petitionerFirstName = new TextField();
        TextField petitionerLastName = new TextField();
        TextField beneficiaryFirstName = new TextField();
        TextField beneficiaryLastName = new TextField();
        TextField dobDay = new TextField();
        TextField dobMonth = new TextField();
        TextField dobYear = new TextField();
		
		
		
		
		
		
		// setup grid to hold labels and text-fields, first scene is the third screen that will appear to user
	    GridPane grid3 = new GridPane();
		//column and row
		grid3.add(new Label("Re-enter Petitioner FirstName Name:"), 0, 0);
		grid3.add(petitionerFirstName, 1, 0);
		grid3.add(confirmFName,2,0);
		grid3.add(this.StatusPFN,3,0);
        grid3.add(new Label("Re-enter Petitioner LastName Name:"), 0, 1);
        grid3.add(petitionerLastName, 1, 1);
		grid3.add(confirmLName,2,1);
		grid3.add(this.StatusPLN,3,1);
		
        
		grid3.add(new Label("Re-enter Beneficiary First Name:"), 0, 2);
        grid3.add(beneficiaryFirstName, 1, 2);
		grid3.add(confirmBFName,2,2);
		grid3.add(this.StatusBFN,3,2);
		
        
		
		grid3.add(new Label("Re-enter Beneficiary Last Name:"), 0, 3);
        grid3.add(beneficiaryLastName, 1, 3);
		grid3.add(confirmBLName,2,3);
		grid3.add(this.StatusBLN,3,3);
		
		
        
		grid3.add(new Label("Re-enter Date of Birth (DD MM YYYY):"), 0, 4);
		grid3.add(dobDay, 1, 4);
        grid3.add(dobMonth, 2,4 );
        grid3.add(dobYear, 3, 4);
		grid3.add(confirmDob,4,4);
		grid3.add(this.StatusDOB,5,4);
		grid3.add(submitReview,0,5);
		grid3.setBackground(Background.fill(Color.IVORY));
		
		
		
		
        thirdScene = new Scene(grid3, 1200, 600);
		
		
		
		
		
		// confirmFName button click event
        confirmFName.setOnAction(event -> {

         

            Alert alert2;

           
            if (petitionerFirstName.getText().isEmpty()) {
               alert2 = new Alert(Alert.AlertType.NONE, "Petitioner first name field is empty. Please enter name", ButtonType.OK);
			    alert2.showAndWait();
			
            }
          
            else if (!(petitionerFirstName.getText().equals(this.currentPetition.getPetitionerFirstName()))){
				
				
				
			    alert2 = new Alert(Alert.AlertType.NONE, "Petitioner first name does not match initial one entered. Please enter valid name", ButtonType.OK);
				 // show alert and clear text field
                 alert2.showAndWait();
				 petitionerFirstName.clear();
            }
			
			
			else{
				
				this.StatusPFN.setText("Data Verified");
			
			}

            
        });
		
		
		
		
		
		// confirmLName button click event
        confirmLName.setOnAction(event -> {
             
			 
			Alert alert3;
			
            
            if (petitionerLastName.getText().isEmpty()) {
               alert3 = new Alert(Alert.AlertType.NONE, "Petitioner last name field is empty. Please enter name", ButtonType.OK);
			   alert3.showAndWait();
			   
            }
          
            else if (!(petitionerLastName.getText().equals(this.currentPetition.getPetitionerLastName()))){
				
				     alert3 = new Alert(Alert.AlertType.NONE, "Petitioner last name does not match one initial entered. Please enter valid name", ButtonType.OK);
				     alert3.showAndWait();
					 petitionerLastName.clear();
					 
            }
			
			
			else{
				
				this.StatusPLN.setText("Data Verified");
				
				
			}
            
        });
		
		
		
		
		
		// confirmBFName button click event
        confirmBFName.setOnAction(event -> {
            
			Alert alert4;
			
          
            if (beneficiaryFirstName.getText().isEmpty()) {
               alert4 = new Alert(Alert.AlertType.NONE, "Beneficiary first name field is empty. Please enter name", ButtonType.OK);
			   alert4.showAndWait();
			   
            }
			
           
            else if (!(beneficiaryFirstName.getText().equals(this.currentPetition.getBeneficiaryFirstName()))){
				
				     alert4 = new Alert(Alert.AlertType.NONE, "Beneficiary first name does not match one initial entered. Please enter valid name", ButtonType.OK);
					 // show alert and clear text field
			         alert4.showAndWait();
					 beneficiaryFirstName.clear();	
            }
			
			
			else{
				
				this.StatusBFN.setText("Data Verified");
				
				
			}
			

        });
		
		
		// confirmBLName button click event
        confirmBLName.setOnAction(event -> {
            
			
			Alert alert5;
		
           
            if (beneficiaryLastName.getText().isEmpty()) {
               alert5 = new Alert(Alert.AlertType.NONE, "Beneficiary last name field is empty. Please enter name", ButtonType.OK);
			    alert5.showAndWait();
	             
            }
            
            else if (!(beneficiaryLastName.getText().equals(this.currentPetition.getBeneficiaryLastName()))){
				
				     alert5 = new Alert(Alert.AlertType.NONE, "Beneficiary last name does not match one initial entered. Please enter valid name", ButtonType.OK);
					 // show alert and clear text field
			         alert5.showAndWait();
					 beneficiaryLastName.clear();
					 
            }	
			
			
			else{
				
				this.StatusBLN.setText("Data Verified");
				
				
			}
			
        });
		
		
		
		
		
		// confirmDob button click event
        confirmDob.setOnAction(event -> {
			
			Alert alert6;
           
            // check if Day is empty
            if (dobDay.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "day field is empty. Please enter day", ButtonType.OK);
			    alert6.showAndWait();
	             
            }
			
			
			// check if Month is empty
			 if (dobMonth.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "Month field is empty. Please enter Month", ButtonType.OK);
			    alert6.showAndWait();
	             
            }
			
			
			// check if Year is empty
			 if (dobYear.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "Year field is empty. Please enter year", ButtonType.OK);
			    alert6.showAndWait();
	             
            }
			
			
			
            
            if (!(dobDay.getText().equals(this.currentPetition.getDobDay()))){
				
				    
				     alert6 = new Alert(Alert.AlertType.NONE, "Day does not match initial one entered. Please enter the valid day", ButtonType.OK);
					 // show alert and clear text field
			         alert6.showAndWait();
					 dobDay.clear();
					 
            }	
			
			
			if(!(dobMonth.getText().equals(this.currentPetition.getDobMonth()))){
				
				
				alert6 = new Alert(Alert.AlertType.NONE, "Month does not match initial one entered. Please enter the valid month", ButtonType.OK);
			    // show alert and clear text field
			    alert6.showAndWait();
				dobMonth.clear();
					 
			}
			
			
			
			
			if(!(dobYear.getText().equals(this.currentPetition.getDobYear()))){
				
				
				alert6 = new Alert(Alert.AlertType.NONE, "Year does not match initial one entered. Please enter the valid year", ButtonType.OK);
			    // show alert and clear text field
			    alert6.showAndWait();
				dobYear.clear();
				
					 
			}
			
			
			
			
			if(dobDay.getText().equals(this.currentPetition.getDobDay()) && dobMonth.getText().equals(this.currentPetition.getDobMonth()) && dobYear.getText().equals(this.currentPetition.getDobYear())){
				
				
			   this.StatusDOB.setText("Data Verified");
			 
					 
			}
			
        });
		
		
		
		
		// submitReview button click event
		submitReview.setOnAction(event -> {
           /*
		   Alert alert7;
		   
		   
		   
		  if(this.StatusPFN.getText().equals("Data verified") &&  this.StatusPLN.getText().equals("Data Verified") &&  this.StatusBFN.getText().equals("Data Verified") 
		  && this.StatusBLN.getText().equals("Data Verified") &&  this.StatusDOB.getText().equals("Data Verified")){
			  
			  this.currentPetition.setWorkflowStatus(1);
			  this.businessObject.addToWorkflow(this.currentPetition);
			  submitReview.setDisable(false);
			   switchToFourthScreen();
			  
		  }
		  
		  else{
			 	  
			  alert7 = new Alert(Alert.AlertType.NONE, "One or more fields is invalid, please verify all fields", ButtonType.OK);
		      submitReview.setDisable(false);
			  alert7.showAndWait();
		 
		    }
		    */
		   currentPetition.setWorkflowStatus(1);
		   businessObject.validateEntry(currentPetition);

		   stage.setScene(firstScene);
		});
		
        stage.setScene(thirdScene);
	
		
    }
	
	
	 private void switchToFourthScreen() {
        // Switch back to the fourth scene
		
		// setup grid to hold labels and text-fields, first scene is the fourth screen that will appear to user
		
		//the message that will appear upon successfully validating data entered
		Label ReviewStatus = new Label("All data has now been verified, your petition will now be sent to approval");
		
	    GridPane grid4 = new GridPane();
		
		grid4.add(ReviewStatus,5,0);
		grid4.setBackground(Background.fill(Color.IVORY));
		fourthScene = new Scene(grid4,700,300);
		
        stage.setScene(fourthScene);
		
		
    }
}
