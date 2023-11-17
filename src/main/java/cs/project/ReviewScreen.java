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

import java.util.Queue;



/**
 * This is the Review screen using JavaFX. It
 * allows a user to first Review their data,edit data and then re-validate all data
 * @author Rashida Mohamed
 */

public class ReviewScreen extends Application {

    
	private final SharedData sharedData;
	private final Queue<String> reviewQueue;
	private Petition currentPetition;
	
	private Stage primaryStage;
    private Scene firstScene;
    private Scene secondScene;
    private Scene thirdScene;
	private Scene fourthScene;
	private int total_fields = 0;
	
	//String that represents the aNumber
	private String currentData = "";
	
	
	
	//Labels to indicate status for each field
	private Label StatusPFN = new Label();
	private Label StatusPLN = new Label();
	private Label StatusBFN = new Label();
	private Label StatusBLN = new Label();
	private Label StatusDOB = new Label();
	
	private MenuScreen menuScreen = new MenuScreen();
		
	private boolean StatusYear;
	private boolean StatusMonth;
	private boolean StatusDay;
	
	private String removedPetition = "";
		
	
	
	public ReviewScreen(SharedData sharedData){
		
		this.sharedData = sharedData;
		this.reviewQueue = this.sharedData.getBusinessObject().getWorkflow().getReviewQueue();
		this.currentPetition = new Petition();
		
	
	
	}
	
    
	
	 String month = "";
     boolean result = true;
	 
	
 
    private void switchToFirstScreen() {
        // Switch back to the first scene
        primaryStage.setScene(firstScene);
		
    }
	
	
	private void switchToSecondScreen(Petition currentPetition) {
		 
		 
        // Switch to the second scene
		this.currentPetition = currentPetition;
		
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
		
		//Button to edit and re-validate data
		Button ER = new Button("Click here to edit and re-validate data");
		
		
		
		
	
		
		// revalidate data button click event
        ER.setOnAction(event -> {
			
			switchToThirdScreen(this.currentPetition,0);
			
		});
		
		
		// create horizontal box to hold buttons
        HBox buttonBox2 = new HBox(10);
        buttonBox2.getChildren().addAll(ER);
        grid2.add(buttonBox2, 0, 7);
		grid2.setBackground(Background.fill(Color.IVORY));
        secondScene = new Scene(grid2, 1200, 600);
	
        primaryStage.setScene(secondScene);
		
	   	
    }
	
    private void switchToThirdScreen(Petition currentPetition, int total_fields) {
        // Switch back to third scene
		
		 this.currentPetition = currentPetition;
		 this.total_fields = total_fields;
		 
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
		
		
		//set the text for each field
		petitionerFirstName.setText(this.currentPetition.getPetitionerFirstName());
		petitionerLastName.setText(this.currentPetition.getPetitionerLastName());
		beneficiaryFirstName.setText(this.currentPetition.getBeneficiaryFirstName());
		beneficiaryLastName.setText(this.currentPetition.getBeneficiaryLastName());
		dobDay.setText(this.currentPetition.getDobDay());
		dobMonth.setText(this.currentPetition.getDobMonth());
		dobYear.setText(this.currentPetition.getDobYear());
		
		
		
		
		
		
		// setup grid to hold labels and text-fields, first scene is the third screen that will appear to user
	    GridPane grid3 = new GridPane();
		//column and row
		grid3.add(new Label("edit or re-enter Petitioner FirstName Name:"), 0, 0);
		grid3.add(petitionerFirstName, 1, 0);
		grid3.add(confirmFName,2,0);
		grid3.add(this.StatusPFN,3,0);
        grid3.add(new Label("edit or re-enter Petitioner LastName Name:"), 0, 1);
        grid3.add(petitionerLastName, 1, 1);
		grid3.add(confirmLName,2,1);
		grid3.add(this.StatusPLN,3,1);
		
        
		grid3.add(new Label("edit or re-enter Beneficiary First Name:"), 0, 2);
        grid3.add(beneficiaryFirstName, 1, 2);
		grid3.add(confirmBFName,2,2);
		grid3.add(this.StatusBFN,3,2);
		
        
		
		grid3.add(new Label("edit or re-enter Beneficiary Last Name:"), 0, 3);
        grid3.add(beneficiaryLastName, 1, 3);
		grid3.add(confirmBLName,2,3);
		grid3.add(this.StatusBLN,3,3);
		
		
        
		grid3.add(new Label("edit or re-enter Date of Birth (DD MM YYYY):"), 0, 4);
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
			Alert alert3;

           
            if (petitionerFirstName.getText().isEmpty()) {
               alert2 = new Alert(Alert.AlertType.NONE, "Petitioner first name field is empty. Please enter name", ButtonType.OK);
			    alert2.showAndWait();
				this.StatusPFN.setText("");
			    
            }
          
            else {
				
					
			    if(checkIfStringsContainNonAlphabetic(petitionerFirstName.getText())){
			     
					this.currentPetition.setPetitionerFirstName(petitionerFirstName.getText());
					this.total_fields = this.total_fields +1;
					this.StatusPFN.setText("Data Verified");
				
				}
				
				else{
					
					 alert3 = new Alert(Alert.AlertType.NONE, "Petitioner first name field contains a non alphabetic character", ButtonType.OK);
					 petitionerFirstName.clear();
			         alert3.showAndWait();
					this.StatusPFN.setText("");
				}
			
			}

            
        });
		
		
		
		
		
		// confirmLName button click event
        confirmLName.setOnAction(event -> {
             
			 
			Alert alert3;
			
            
            if (petitionerLastName.getText().isEmpty()) {
               alert3 = new Alert(Alert.AlertType.NONE, "Petitioner last name field is empty. Please enter name", ButtonType.OK);
			   alert3.showAndWait();
			   this.StatusPLN.setText("");
			   
            }
          
            else {
				     
						 
                if(checkIfStringsContainNonAlphabetic(petitionerLastName.getText())){
					
					this.currentPetition.setPetitionerLastName(petitionerLastName.getText());
					this.total_fields = this.total_fields +1;
					this.StatusPLN.setText("Data Verified");
				
				
				}
				
				
				else{
					alert3 = new Alert(Alert.AlertType.NONE, "Petitioner last name contains non-alphabetic character", ButtonType.OK);
				    alert3.showAndWait();
					petitionerLastName.clear();
					this.StatusPLN.setText("");
				}
				
				
			}
            
        });
		
		
		// confirmBFName button click event
        confirmBFName.setOnAction(event -> {
            
			Alert alert4;
			
          
            if (beneficiaryFirstName.getText().isEmpty()) {
               alert4 = new Alert(Alert.AlertType.NONE, "Beneficiary first name field is empty. Please enter name", ButtonType.OK);
			   alert4.showAndWait();
			   this.StatusBFN.setText("");
			   
            }
			
           
            else{
				
				    
   		
		        if(checkIfStringsContainNonAlphabetic(beneficiaryFirstName.getText())){
				    

					this.currentPetition.setBeneficiaryFirstName(petitionerLastName.getText());
					this.total_fields = this.total_fields +1;
					this.StatusBFN.setText("Data Verified");
				
				
				}
				
				
				else{
					
					 alert4 = new Alert(Alert.AlertType.NONE, "Beneficiary first name contains non-alphabetic character. Please enter valid name", ButtonType.OK);
					 // show alert and clear text field
			         alert4.showAndWait();
					 beneficiaryFirstName.clear();	
					 this.StatusBFN.setText("");
				}
				
				
			}
			

        });
		
		
		// confirmBLName button click event
        confirmBLName.setOnAction(event -> {
            
			
			Alert alert5;
		
           
            if (beneficiaryLastName.getText().isEmpty()) {
               alert5 = new Alert(Alert.AlertType.NONE, "Beneficiary last name field is empty. Please enter name", ButtonType.OK);
			    alert5.showAndWait();
				this.StatusBLN.setText("");
	             
            }
            
            else {
				
				   
	
				if(checkIfStringsContainNonAlphabetic(beneficiaryLastName.getText())){
					
					this.currentPetition.setBeneficiaryLastName(beneficiaryLastName.getText());
					this.total_fields = this.total_fields +1;
					this.StatusBLN.setText("Data Verified");
				
				}
				
				
				else{
					
					 alert5 = new Alert(Alert.AlertType.NONE, "Beneficiary last name contains non-alphabetic character. Please enter valid name", ButtonType.OK);
					 // show alert and clear text field
			         alert5.showAndWait();
					 beneficiaryLastName.clear();
					 this.StatusBLN.setText("");
					 
					 
				}
				
				
			}
			
        });
	
	
		// confirmDob button click event
        confirmDob.setOnAction(event -> {
			
			Alert alert6;
           
            // check if Day is empty
            if (dobDay.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "day field is empty. Please enter day", ButtonType.OK);
			    alert6.showAndWait();
				this.StatusDay = false;
	             
            }
			
			
			// check if Month is empty
			 if (dobMonth.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "Month field is empty. Please enter Month", ButtonType.OK);
			   alert6.showAndWait();
	           this.StatusMonth = false;
            }
			
			
			// check if Year is empty
			 if (dobYear.getText().isEmpty()) {
               alert6 = new Alert(Alert.AlertType.NONE, "Year field is empty. Please enter year", ButtonType.OK);
			   alert6.showAndWait();
			   this.StatusYear = false;
	             
            }
			
			
			
            if(!(dobDay.getText().isEmpty())){
            if (checkIfStringsContainsOnlyDigits(dobDay.getText())){
				
				    if(this.sharedData.getBusinessObject().isDobInRange(2000,12,Integer.valueOf(dobDay.getText()))){
					   this.currentPetition.setDobDay(Integer.valueOf(dobDay.getText()));
				      
					   this.StatusDay = true;
				   
					}
					
					else{
						
						alert6 = new Alert(Alert.AlertType.NONE, "Day field is out of range. Please enter the valid day", ButtonType.OK);
					    // show alert and clear text field
			            alert6.showAndWait();
					    dobDay.clear();
						this.StatusDay = false;
					}
					
				   
            }


             else{
                
				
				     alert6 = new Alert(Alert.AlertType.NONE, "Day contains a non numeric digit. Please enter the valid day", ButtonType.OK);
					 // show alert and clear text field
			         alert6.showAndWait();
					 dobDay.clear();
					 this.StatusDay = false;
					 

			 }				 
			
			}
			
			
			if(!(dobMonth.getText().isEmpty())){
			
			if(checkIfStringsContainsOnlyDigits(dobMonth.getText())){
				if(this.sharedData.getBusinessObject().isDobInRange(2000,Integer.valueOf(dobMonth.getText()),1)){
					   
					   this.currentPetition.setDobMonth(Integer.valueOf(dobMonth.getText()));
				       this.StatusMonth = true;
				   
					}
					
					else{
						
						alert6 = new Alert(Alert.AlertType.NONE, "Month field is out of range. Please enter the valid month", ButtonType.OK);
					    // show alert and clear text field
			            alert6.showAndWait();
					    dobMonth.clear();
						 this.StatusMonth = false;
					
						
					}
			 
	 
			}
			
			else{
				
				
		        alert6 = new Alert(Alert.AlertType.NONE, "Month contains a non numeric character. Please enter the valid month", ButtonType.OK);
			    // show alert and clear text field
			    alert6.showAndWait();
				dobMonth.clear();
				 this.StatusMonth = false;
			}
			
			}
			
			
			if(!(dobYear.getText().isEmpty())){
			if(checkIfStringsContainsOnlyDigits(dobYear.getText())){
				
			    if(this.sharedData.getBusinessObject().isDobInRange(Integer.valueOf(dobYear.getText()),12,1)){
				       
					   this.currentPetition.setDobYear(Integer.valueOf(dobYear.getText()));
				       this.StatusYear = true;
				        
					}
					
					else{
						
						alert6 = new Alert(Alert.AlertType.NONE, "year field is out of range. Please enter the valid year", ButtonType.OK);
					    // show alert and clear text field
			            alert6.showAndWait();
					    dobYear.clear();
						 this.StatusYear = false;
						 
						
					}
					 
			}
			
			
			else{
				
				
				alert6 = new Alert(Alert.AlertType.NONE, "Year contains non-numeric character. Please enter the valid year", ButtonType.OK);
			    // show alert and clear text field
			    alert6.showAndWait();
				dobYear.clear();
				this.StatusYear = false;
			  
				
			}
			
			
			}
			
			
			if(this.StatusDay == true && this.StatusMonth == true && this.StatusYear == true){
				
			
			    this.total_fields = this.total_fields +1;
			    this.StatusDOB.setText("Data Verified");
			        
			 
					 
			}

		       if(this.StatusDay == false || this.StatusMonth == false || this.StatusYear == false){
				
			
			
			    this.StatusDOB.setText("");
			        
			 
					 
			}
		
			
        });
		
		
		
		
		// submitReview button click event
		submitReview.setOnAction(event -> {
           
		   Alert alert7;
		   
		   
		   
		  if(this.StatusPFN.getText().equals("Data Verified") && this.StatusPLN.getText().equals("Data Verified") && 
		  this.StatusBFN.getText().equals("Data Verified") && this.StatusBLN.getText().equals("Data Verified") && 
		  this.StatusDOB.getText().equals("Data Verified")){
			  
			  this.currentPetition.setWorkflowStatus(1);
			  this.sharedData.getBusinessObject().validateEntry(this.currentPetition);
			  submitReview.setDisable(false);
			  switchToFourthScreen();
			  
		  }
		  
		  else{
			 	  
			  alert7 = new Alert(Alert.AlertType.NONE, "One or more fields has not been verified, please verify all fields", ButtonType.OK);
		      submitReview.setDisable(true);
			  alert7.showAndWait();
		 
		    }
		    
		   
		});


        primaryStage.setScene(thirdScene);
	
		
    }
	
	
	 private void switchToFourthScreen() {
        // Switch back to the fourth scene
		
		// setup grid to hold labels and text-fields, first scene is the fourth screen that will appear to user
		//the message that will appear upon successfully validating data entered
		Label ReviewStatus = new Label("All data has now been verified, your petition will now be sent to approval");
		Button startScreen = new Button("Click here to navigate back to data review menu screen");
		
	    GridPane grid4 = new GridPane();
		
		grid4.add(ReviewStatus,5,0);
		grid4.add(startScreen,5,1);
		grid4.setBackground(Background.fill(Color.IVORY));
		fourthScene = new Scene(grid4,700,300);
		
        primaryStage.setScene(fourthScene);
		
		
		 startScreen.setOnAction(event -> {
		
			switchToFirstScreen();
			
		
		});
		
    }
	
	
	
	
	 private void switchToFifthScreen() {
        // Switch back to the fourth scene
		
		// setup grid to hold labels and text-fields, first scene is the fourth screen that will appear to user
		
		//the message that will appear upon successfully validating data entered
		Label ReviewStatus = new Label("All items from work flow has been reviewed");
		Button startScreen = new Button("Click here to navigate back to main menu screen");
		
	    GridPane grid4 = new GridPane();
		
		grid4.add(ReviewStatus,5,0);
		grid4.add(startScreen,5,4);
		grid4.setBackground(Background.fill(Color.IVORY));
		fourthScene = new Scene(grid4,700,300);
		
        primaryStage.setScene(fourthScene);
		
		
		 startScreen.setOnAction(event -> {
		
			
            MenuScreen menuScreen = new MenuScreen();
            menuScreen.start(primaryStage);
        
			
		});
		
    }
	
	//returns true if string contains only alphabetic characters
	private boolean checkIfStringsContainNonAlphabetic(String current_field){
		char[] string;
		string = current_field.toCharArray();
        boolean isvalid = true;
		
        for (char c: string) {
			
            if (!Character.isAlphabetic(c)) {
                 isvalid = false;
				 break;
            }
        }
		
		
		
		
		return isvalid;
		
	}
	
	
	
	//returns true if string contains only numeric characters
	
	private boolean checkIfStringsContainsOnlyDigits(String current_field){
		char[] string;
		string = current_field.toCharArray();
        boolean isvalid = true;
		
        for (char c: string) {
			
            if (!Character.isDigit(c)) {
                 isvalid = false;
				 break;
            }
        }
		
	
		return isvalid;
		
	}
	
    
    /**
     * Main method to create new BO and petition objects
     * @param args default arguments
     */
    public static void main(String[] args) {
       
        //javafx.application.Application.
		launch(args);
		
    }

    @Override
    public void start(Stage primaryStage) {
	      
        // window title
		this.primaryStage = primaryStage;
		
        this.primaryStage.setTitle("Review, edit, and re-validate Immigration Application");
		
	   

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
		
		Button getNFworkflow = new Button("Click here to review next petition from work flow");
		// create horizontal box to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(getNFworkflow);
        grid1.add(buttonBox, 2, 0);
		grid1.setBackground(Background.fill(Color.IVORY));
        firstScene = new Scene(grid1, 700, 300);
        primaryStage.setScene(firstScene);
        primaryStage.show();
	
	
		getNFworkflow.setOnAction(event -> {
			
		    
			
			
			if(this.reviewQueue.size() != 0){
				
		
		       this.currentData = this.sharedData.getBusinessObject().getWorkflow().removeFromReviewQueue();
			 
			  
			    //Allows user to review data if an item was removed from review queue
			    this.currentPetition = this.sharedData.getBusinessObject().getPetitionFromDatabase(this.currentData);
		        switchToSecondScreen(this.currentPetition);
	       
			
			}
			
			
			else if(this.reviewQueue.size() == 0){
			
			    switchToFifthScreen();
				
		    }
			
		});
		
    }
	
	
}



