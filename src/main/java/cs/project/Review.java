package cs.project;

import java.util.Scanner;

public class Review{
 

private Scanner scnr;
private PNW pnw_obj;


public Review(Scanner scnr){

 this.scnr = scnr;
 pnw_obj = new PNW();
 
}


/**
* The getNextFromWF method returns the current petition called by the removeFromReviewQueue method
* in the workflow class
*/
public Petition getNextFromWF(Petition current_petition){
	
	
     
	if(current_petition != null){

		if (pnw_obj.validateEntry(current_petition).isEmpty()) {
			
				
		    editYear(current_petition);

		    editDay(current_petition);
			
			editMonth(current_petition);

	    }
		
		}

		
		editWorkflowStatus(current_petition);	

		
		return current_petition;
		
			
}

/** 
* returns the year in which the user enters
*/
public int editYear(Petition current_petition){
	
	//get user input and parse it into scanner 
	
    System.out.println("Re-enter your year of birth in the following format YYYY: ");
    int year = scnr.nextInt();
	current_petition.setDobYear(year);
	
	return year;
	
}	


/** 
* returns the month in which the user enters
*/
public int editMonth(Petition current_petition){
	
	
	//get user input and parse it into field
	System.out.println("Re-enter the month in which you born in the following format Y/or YY: ");
	int Month = scnr.nextInt();
	current_petition.setDobMonth(Month);
	
	return Month;
	
}	


/** 
* returns the day in which the user enters
*/
public int editDay(Petition current_petition){
	
	
	//get user input and parse it into field
	System.out.println("Re-Enter the day you were born in the following format Y/ or YY");
	int Day = scnr.nextInt();
	current_petition.setDobDay(Day);
    
	return Day;
	
}



/** 
* updates workflow status for approval
*/
public int editWorkflowStatus(Petition current_petition){
	
	
	//change the workflow status to 1 for approval
	  current_petition.setWorkflowStatus(1);
	  
	  
	  return  current_petition.getWorkflowStatus();
	 

}


public void ClearScreen(){
	// following code would clear the screen
	//jf.getContentPane().removeAll();
}

}
