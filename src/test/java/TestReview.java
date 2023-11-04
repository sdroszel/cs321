import cs.project.Petition;
import cs.project.Review;
import cs.project.Workflow;
import org.junit.Before;

import java.util.Scanner;
//import java.io;


public class TestReview {

	private Review review_obj;
	private Workflow workflow;
	private Petition petition1;
	private Petition petition2;
	private Petition petition3;
  

    /**
     * Before each test, create a review and workflow object
     */
    @Before
    public void createObjectsForTests() {
    Scanner scnr = new Scanner(System.in);
		//review_obj = newReview(scnr);
		workflow = new Workflow();
		
		
		  petition1 = new Petition();

        petition1.setBeneficiaryFirstName("John");
        petition1.setBeneficiaryLastName("Doe");
        petition1.setANumber("001");
        petition1.setPetitionerFirstName("Jane");
        petition1.setPetitionerLastName("Doe");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		
		
		
		petition2 = new Petition();

        petition2.setBeneficiaryFirstName("Mike");
        petition2.setBeneficiaryLastName("Brown");
        petition2.setANumber("002");
        petition2.setPetitionerFirstName("Suzie");
        petition2.setPetitionerLastName("Westbrook");
        petition2.setDobMonth(6);
        petition2.setDobDay(13);
        petition2.setDobYear(2000);
         
		 
		 
		petition3 = new Petition();

        petition3.setBeneficiaryFirstName("Bob");
        petition3.setBeneficiaryLastName("Green");
        petition3.setANumber("003");
        petition3.setPetitionerFirstName("Maria");
        petition3.setPetitionerLastName("Gonzalez");
        petition3.setDobMonth(7);
        petition3.setDobDay(33);
        petition3.setDobYear(1978);


		workflow.addToReviewQueue(petition1.getaNumber());
		workflow.addToReviewQueue(petition2.getaNumber());
		workflow.addToReviewQueue(petition3.getaNumber());
   
    }
     
    /**
     *  This tests if the current petition that is removed from the 
	   *  workflow class method called removeFromReviewQueue is stored into getNextFromWF 
	   *  method in the review class
     */
    /*
    @Test
    public void () {
	    String current_petition = workflow.removeFromReviewQueue();
		
		while(current_petition != null){
        assertEquals(current_petition.getaNumber(), review_obj.getNextFromWF(current_petition).getaNumber());
		  }

    }
	*/
	
	
	 /**
     *  This tests if a proper year has been re-entered by the user
	   *  editYear method in review class
     */
	 /*
    @Test
    public void () {
	 	
		String expectedResult = "1989";
        InputputStream in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(1989, review_obj.editYear(petition1));
		
		
	    expectedResult = "2000";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(2000, review_obj.editYear(petition2));
		
		expectedResult = "1978";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(1978, review_obj.editYear(petition3));
		
    }
	
	*/
	
	 /**
     *  This tests if a proper month has been re-entered by the user in the format specified in 
	   *  editmonth method in review class
     */
    /*
     @Test
    public void () {
	    
		String expectedResult = "5";
        InputputStream in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(5, review_obj.editMonth(petition1));
		
		
	     expectedResult = "6";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(6, review_obj.editMonth(petition2));
		
		expectedResult = "7";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(7, review_obj.editMonth(petition3));
		
    }
	*/
	
	
	
	 /**
     *  This tests if a proper day has been re-entered by the user in the format specified in 
	   *  editday method in review class
     */
    /*
     @Test
    public void () {
	
	    String expectedResult = "16";
        InputputStream in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(16, review_obj.editDay(petition1));
		
		
	     expectedResult = "13";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(13, review_obj.editDay(petition2));
		
		expectedResult = "33";
        in = new ByteArrayInputStream(expectedResult.getBytes());
        System.setIn(in);
        assertEquals(33, review_obj.editDay(petition3));
	
    }
	*/
	
	 /**
     *  This tests if the editWorkflowStatus method updates the status of the petition 
	 *  for approval
     */
    /*
     @Test
    public void () {
	   
		
    assertEquals(1, review_obj.editWorkflowStatus(petition1).getWorkflowStatus());
		assertEquals(1, review_obj.editWorkflowStatus(petition2).getWorkflowStatus());
		assertEquals(1, review_obj.editWorkflowStatus(petition3).getWorkflowStatus()); 
		
    }
*/
} 
