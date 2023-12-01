import cs.project.Database;
import cs.project.PNW;
import cs.project.Petition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a test class for the cs321.PNW object.
 *
 * @author Scott Roszel,Victor Londono & Rashida Mohamed
 */
public class PNWTest {
    PNW pnw;
    Petition petition;
    Database database;

    /**
     * This is run before each test
     */
    @Before
    public void create() {
        pnw = new PNW();
        petition = new Petition();
        database = new Database();
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if the data entered in correct.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryCorrectData() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertNull(result);
    }

    /**
     * This test checks if the a-number is empty or null
     * @author Scott Roszel
     */
    @Test
    public void testAnumberNullOrEmpty() {
        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid A-Number", result);
    }

    /**
     * This test checks if the a-number contains non-digits
     * @author Scott Roszel
     */
    @Test
    public void testCheckIfStringContainsOnlyDigitsInvalidAnumber() {
        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("a001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid A-Number. Can only contain numbers.", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if the 29th of February is out of range for a non leap year.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryDayOutOfRangeNonLeapYear() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(2);
        petition.setDobDay(29);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if the 29th in February is in range for a leap year.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryDayInRangeLeapYear() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(2);
        petition.setDobDay(29);
        petition.setDobYear(2004);

        String result = pnw.validateEntry(petition);

        assertNull(result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if a string entry is empty.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryMissingBeneficiaryFirstName() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Beneficiary First Name", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if a string entry is empty.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryMissingBeneficiaryLastName() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Beneficiary Last Name", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if a string entry is empty.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryMissingPetitionerFirstName() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Petitioner First Name", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if a string entry is empty.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryMissingPetitionerLastName() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Petitioner Last Name", result);
    }

    /**
     * This test checks the petitioner first name for non-alphabetic characters
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryPetitionerFirstNameNonAlphabetic() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jan3");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Petitioner First Name. Can only contain alphabetic characters.", result);
    }

    /**
     * This test checks the beneficiary's first name for non-alphabetic characters
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryBeneficiaryFirstNameNonAlphabetic() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("J0hn");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Beneficiary First Name. Can only contain alphabetic characters.", result);
    }

    /**
     * This test checks if the beneficiary's last name for non-alphabetic characters
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryBeneficiaryLastNameNonAlphabetic() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("D0e");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(5);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Beneficiary Last Name. Can only contain alphabetic characters.", result);
    }

    /**
     * This test checks the return value for ValidateEntry()
     * if the month is out of range.
     * @author Scott Roszel
     */
    @Test
    public void testValidateEntryMonthOutOfRange() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(13);
        petition.setDobDay(16);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    /**
     * This tests the check database function with a valid a-number
     * @author Scott Roszel
     */
    @Test
    public void testCheckDatabaseValidEntry() {
        Petition p1 = new Petition();
        Petition p2 = new Petition();
        Petition p3 = new Petition();

        p1.setANumber("001");
        p2.setANumber("002");
        p3.setANumber("003");

        pnw.getDatabase().add(p1);
        pnw.getDatabase().add(p2);
        pnw.getDatabase().add(p3);

        Boolean result = pnw.checkDatabase("003");

        assertTrue(result);
    }

    /**
     * This tests the check database function with invalid entry
     * @author Scott Roszel
     */
    @Test
    public void testCheckDatabaseInvalidEntry() {
        Petition p1 = new Petition();
        Petition p2 = new Petition();
        Petition p3 = new Petition();

        p1.setANumber("001");
        p2.setANumber("002");
        p3.setANumber("003");

        pnw.getDatabase().add(p1);
        pnw.getDatabase().add(p2);
        pnw.getDatabase().add(p3);

        Boolean result = pnw.checkDatabase("005");

        assertFalse(result);
    }

    /**
     * This tests the check database function while it is empty
     * @author Scott Roszel
     */
    @Test
    public void testCheckDatabaseEmptyDatabase() {

        Boolean result = pnw.checkDatabase("003");

        assertFalse(result);
    }

    /**
     * This tests the get petition from database function with
     * an a-number that does not exist
     * @author Scott Roszel
     */
    @Test
    public void testGetPetitionFromDatabaseDNE() {
        Petition p1 = new Petition();
        Petition p2 = new Petition();
        Petition p3 = new Petition();

        p1.setANumber("001");
        p2.setANumber("002");
        p3.setANumber("003");

        pnw.getDatabase().add(p1);
        pnw.getDatabase().add(p2);
        pnw.getDatabase().add(p3);

        Petition result = pnw.getPetitionFromDatabase("004");

        assertNull(result);
    }

    /**
     * This test adds to the approval workflow
     * @author Scott Roszel
     */
    @Test
    public void testAddToWorkflowApproval() {
        petition.setANumber("001");
        petition.setWorkflowStatus(1);

        Boolean result = pnw.addToWorkflow(petition);

        assertTrue(result);
    }

    /**
     * This test tries to add to a workflow that does not exist
     * @author Scott Roszel
     */
    @Test
    public void testAddToWorkflowFail() {
        petition.setANumber("001");
        petition.setWorkflowStatus(2);

        Boolean result = pnw.addToWorkflow(petition);

        assertFalse(result);
    }

    @Test
    public void testValidateEntryDayOutOfRangeOddMonth() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(11);
        petition.setDobDay(40);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);

    }

    @Test
    public void testValidateEntryDayOutOfRangeEvenMonth() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(10);
        petition.setDobDay(40);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    @Test
    public void testValidateEntryYearTooLarge() {

        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(11);
        petition.setDobDay(23);
        petition.setDobYear(10000);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    @Test
    public void testValidateEntryYearTooSmall() {

        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(11);
        petition.setDobDay(23);
        petition.setDobYear(0);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    @Test
    public void testValidateEntryYearIsNegative() {

        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(11);
        petition.setDobDay(23);
        petition.setDobYear(-1800);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    @Test
    public void testValidateEntryMonthIsNegative() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(-11);
        petition.setDobDay(23);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }

    @Test
    public void testValidateEntryDayIsNegative() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("John");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("Doe");
        petition.setDobMonth(11);
        petition.setDobDay(-23);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Date of Birth", result);
    }


    @Test
    public void testValidateEntryStringContainsNonAlphabetic() {
        petition = new Petition();

        petition.setBeneficiaryFirstName("34;82");
        petition.setBeneficiaryLastName("Doe");
        petition.setANumber("001");
        petition.setPetitionerFirstName("Jane");
        petition.setPetitionerLastName("D6[[e");
        petition.setDobMonth(-11);
        petition.setDobDay(23);
        petition.setDobYear(1989);

        String result = pnw.validateEntry(petition);

        assertEquals("Invalid Petitioner Last Name. Can only contain alphabetic characters.", result);
    }

    @Test
    public void testGetPetitionFromDatabase(){
        petition = new Petition();
        database = new Database();

        petition.setANumber("001");
        pnw.getDatabase().add(petition);

        Petition result = pnw.getPetitionFromDatabase("001");

        assertEquals(petition, result);
    }
    @Test
    public void testAddToWorkflowReturnResult() {
        boolean result = pnw.addToWorkflow(petition);

        assertTrue(result);
    }

     
    /************************************
	 * UNIT TESTS FOR getWorkflow Method *
	 ************************************/
	
	
	/**
	* The following tests checks if the workflow object called by 
	* the getWorkflow method is not NULL
	*/
	
	@Test
	public void testWorkflowobjectNotNull(){
	      
		  
	   PNW pnw_obj = new PNW();
	   
	   Workflow workflow_obj = pnw_obj.getWorkflow();
	   
	   
	   assertNotNull("Workflow object has been initialized",workflow_obj);
	   
	}
	
	
	/** TestANumbersinReview1 verifies that the reviewQueue in workflow class contains all valid a-Numbers
	*  that was added from addToWorkflow method through using the getWorkflow method 
	*/
	
	@Test
	public void testANumbersinReview1(){
		
		
		/*contains list of valid a-Numbers that was added*/
		
		String [] aNumbers = {"001","002","003"};
		
		int count = 0;
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("John");
        petition1.setBeneficiaryLastName("Doe");
        petition1.setANumber("001");
        petition1.setPetitionerFirstName("Jane");
        petition1.setPetitionerLastName("Doe");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		
		Petition petition2 = new Petition();

        petition2.setBeneficiaryFirstName("Mike");
        petition2.setBeneficiaryLastName("Sanders");
        petition2.setANumber("002");
        petition2.setPetitionerFirstName("Tom");
        petition2.setPetitionerLastName("Jones");
        petition2.setDobMonth(2);
        petition2.setDobDay(8);
        petition2.setDobYear(1993);
	
		
		
		
		Petition petition3 = new Petition();

        petition3.setBeneficiaryFirstName("Suzie");
        petition3.setBeneficiaryLastName("Green");
        petition3.setANumber("003");
        petition3.setPetitionerFirstName("Bianca");
        petition3.setPetitionerLastName("Jones");
        petition3.setDobMonth(6);
        petition3.setDobDay(7);
        petition3.setDobYear(1995);
		
		
	    pnw_obj.validateEntry(petition1);
		
		pnw_obj.validateEntry(petition2);
		
		pnw_obj.validateEntry(petition3);
	
		Workflow workflow_obj = pnw_obj.getWorkflow();
		
	    for(int i = 0; i < aNumbers.length; i++){
		
		     if(aNumbers[i] == workflow_obj.removeFromReviewQueue()){
				 
				count++;
				 
			 }
	    }
		
	 
	    assertEquals(3,count);
		
	}
	
	
	/** TestANumbersinReview2 verifies that the reviewQueue in workflow class contains all valid a-Numbers
	* that was added from addToWorkflow method through using the getWorkflow method 
	*/
	
	@Test
	public void testANumbersinReview2(){
		
		
		
		String [] aNumbers = {"004","005","006"};
		
		int count = 0;
		
		
		PNW pnw_obj2 = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("Sarah");
        petition1.setBeneficiaryLastName("Wayne");
        petition1.setANumber("004");
        petition1.setPetitionerFirstName("Janet");
        petition1.setPetitionerLastName("Niles");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		
		Petition petition2 = new Petition();

        petition2.setBeneficiaryFirstName("Marco");
        petition2.setBeneficiaryLastName("Brown");
        petition2.setANumber("005");
        petition2.setPetitionerFirstName("Thomas");
        petition2.setPetitionerLastName("Callahan");
        petition2.setDobMonth(2);
        petition2.setDobDay(8);
        petition2.setDobYear(1993);
	
		
		Petition petition3 = new Petition();

        petition3.setBeneficiaryFirstName("Suzie");
        petition3.setBeneficiaryLastName("Green");
        petition3.setANumber("006");
        petition3.setPetitionerFirstName("Bianca");
        petition3.setPetitionerLastName("Jones");
        petition3.setDobMonth(6);
        petition3.setDobDay(7);
        petition3.setDobYear(1995);
		
		
	    pnw_obj2.validateEntry(petition1);
		
		pnw_obj2.validateEntry(petition2);
		
		pnw_obj2.validateEntry(petition3);
	
	
		
		
		Workflow workflow_obj2 = pnw_obj2.getWorkflow();
		
		
	    for(int i = 0; i < aNumbers.length; i++){
		
		     if(aNumbers[i].equals(workflow_obj2.removeFromReviewQueue())){
				 
				count++;
				 
			 }
	    }
		
	 
	    assertEquals(3,count);
		
		
	}
	
	
	
	/** TestANumbersinApproval1 verifies that the  Approval Queue in workflow class contains all valid a-Numbers
	*  that was added from addToWorkflow method through using the getWorkflow method 
	*/
	@Test
	public void testANumbersinApproval1(){
		System.out.println("testANumbersinApproval1 passed!");
		
		
		String [] aNumbers = {"001","002","003"};
		
		int count = 0;
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("John");
        petition1.setBeneficiaryLastName("Doe");
        petition1.setANumber("001");
        petition1.setPetitionerFirstName("Jane");
        petition1.setPetitionerLastName("Doe");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		petition1.setWorkflowStatus(1);
		
		Petition petition2 = new Petition();

        petition2.setBeneficiaryFirstName("Mike");
        petition2.setBeneficiaryLastName("Sanders");
        petition2.setANumber("002");
        petition2.setPetitionerFirstName("Tom");
        petition2.setPetitionerLastName("Jones");
        petition2.setDobMonth(2);
        petition2.setDobDay(8);
        petition2.setDobYear(1993);
		petition2.setWorkflowStatus(1);
	
		
		
		
		Petition petition3 = new Petition();

        petition3.setBeneficiaryFirstName("Suzie");
        petition3.setBeneficiaryLastName("Green");
        petition3.setANumber("003");
        petition3.setPetitionerFirstName("Bianca");
        petition3.setPetitionerLastName("Jones");
        petition3.setDobMonth(6);
        petition3.setDobDay(7);
        petition3.setDobYear(1995);
		petition3.setWorkflowStatus(1);
		
		
		pnw_obj.validateEntry(petition1);
		
		pnw_obj.validateEntry(petition2);
		
		pnw_obj.validateEntry(petition3);
	
		
		
		
		Workflow workflow_obj = pnw_obj.getWorkflow();
		
		
	    for(int i = 0; i < aNumbers.length; i++){
		
		     if(aNumbers[i] == workflow_obj.removeFromApprovalQueue()){
				 
				count++;
				 
			 }
	    }
		
	 
	    assertEquals(3,count);
		
		
	}
	
	
	
	/** TestANumbersinApproval2 verifies that the  Approval Queue in workflow class contains all valid a-Numbers
	*  that was added from addToWorkflow method through using the getWorkflow method 
	*/
	@Test
	public void testANumbersinApproval2(){
		
		
		String [] aNumbers = {"004","005","006"};
		
		int count = 0;
		
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("Sarah");
        petition1.setBeneficiaryLastName("Wayne");
        petition1.setANumber("004");
        petition1.setPetitionerFirstName("Janet");
        petition1.setPetitionerLastName("Niles");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		petition1.setWorkflowStatus(1);
		
		Petition petition2 = new Petition();

        petition2.setBeneficiaryFirstName("Marco");
        petition2.setBeneficiaryLastName("Brown");
        petition2.setANumber("005");
        petition2.setPetitionerFirstName("Thomas");
        petition2.setPetitionerLastName("Callahan");
        petition2.setDobMonth(2);
        petition2.setDobDay(8);
        petition2.setDobYear(1993);
		petition2.setWorkflowStatus(1);
	
		
		Petition petition3 = new Petition();

        petition3.setBeneficiaryFirstName("Suzie");
        petition3.setBeneficiaryLastName("Green");
        petition3.setANumber("006");
        petition3.setPetitionerFirstName("Bianca");
        petition3.setPetitionerLastName("Jones");
        petition3.setDobMonth(6);
        petition3.setDobDay(7);
        petition3.setDobYear(1995);
		petition3.setWorkflowStatus(1);
		
		
		pnw_obj.validateEntry(petition1);
		
		pnw_obj.validateEntry(petition2);
		
		pnw_obj.validateEntry(petition3);
	

		
		
		Workflow workflow_obj = pnw_obj.getWorkflow();
		
		
	    for(int i = 0; i < aNumbers.length; i++){
		
		     if(aNumbers[i] == workflow_obj.removeFromApprovalQueue()){
				 
				count++;
				 
			 }
	    }
		
	 
	    assertEquals(3,count);
		
		
	}
	
	
	/** The following tests if the getWorkflow method can be used to obtain all data associated with current petition 
	*  that needs review from the database
	*/
	@Test
	public void testgetNextWFReviewQueue1(){
		
		
		int count = 0;
		
		String [] petitionData = {"John","Doe","Jane","Doe","5","16","1989"};
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("John");
        petition1.setBeneficiaryLastName("Doe");
        petition1.setANumber("001");
        petition1.setPetitionerFirstName("Jane");
        petition1.setPetitionerLastName("Doe");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		
	
		pnw_obj.validateEntry(petition1);
		
	   
		
		//following variable stores the current aNumber from the review queue, using the getWorkflow method
		
		String currentData = pnw_obj.getWorkflow().removeFromReviewQueue();
		
		
		
		Petition currentPetition = pnw_obj.getPetitionFromDatabase(currentData);
		
		
		if(currentPetition.getBeneficiaryFirstName().equals(petitionData[0])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getBeneficiaryLastName().equals(petitionData[1])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getPetitionerFirstName().equals(petitionData[2])){
			
			count = count+1;
		}
	   
	   
	    if(currentPetition.getPetitionerLastName().equals(petitionData[3])){
			
			count = count+1;
			
		}
		
		
		
		if(currentPetition.getDobMonth().equals(petitionData[4])){
			
			count = count+1;
		}
		
		
		
		if(currentPetition.getDobDay().equals(petitionData[5])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getDobYear().equals(petitionData[6])){
			
			count = count+1;
		}
		
		
	   
		assertEquals(7,count);
		
	
	
	}
	
	
	/** The following tests if the getWorkflow method can be used to obtain all data associated with current petition 
	*  that needs review from the database
	*/
	@Test
	public void testgetNextWFReviewQueue2(){
		
		
		int count = 0;
		
		String [] petitionData = {"Sarah","Wayne","Janet","Niles","6","9","2000"};
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("Sarah");
        petition1.setBeneficiaryLastName("Wayne");
        petition1.setANumber("004");
        petition1.setPetitionerFirstName("Janet");
        petition1.setPetitionerLastName("Niles");
        petition1.setDobMonth(6);
        petition1.setDobDay(9);
        petition1.setDobYear(2000);
		
		
		pnw_obj.validateEntry(petition1);
		

		//following variable stores the current aNumber from the review queue, using the getWorkflow method
		
		String currentData = pnw_obj.getWorkflow().removeFromReviewQueue();
		
		
		
		Petition currentPetition = pnw_obj.getPetitionFromDatabase(currentData);
		
		
		if(currentPetition.getBeneficiaryFirstName().equals(petitionData[0])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getBeneficiaryLastName().equals(petitionData[1])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getPetitionerFirstName().equals(petitionData[2])){
			
			count = count+1;
		}
	   
	   
	    if(currentPetition.getPetitionerLastName().equals(petitionData[3])){
			
			count = count+1;
			
		}
		
		
		
		if(currentPetition.getDobMonth().equals(petitionData[4])){
			
			count = count+1;
		}
		
		
		
		if(currentPetition.getDobDay().equals(petitionData[5])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getDobYear().equals(petitionData[6])){
			
			count = count+1;
		}
		
		
	   
		assertEquals(7,count);
		
		
		
		
			
	}
	
	
	/** The following tests if the getWorkflow method can be used to obtain all data associated with current petition 
	*  that needs Approval from the database
	*/
	@Test
	public void testgetNextWFApprovalQueue1(){
		
		int count = 0;
		
		String [] petitionData = {"John","Doe","Jane","Doe","5","16","1989"};
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("John");
        petition1.setBeneficiaryLastName("Doe");
        petition1.setANumber("001");
        petition1.setPetitionerFirstName("Jane");
        petition1.setPetitionerLastName("Doe");
        petition1.setDobMonth(5);
        petition1.setDobDay(16);
        petition1.setDobYear(1989);
		petition1.setWorkflowStatus(1);
		
		
		pnw_obj.validateEntry(petition1);
		
	
		
		
		//following variable stores the current aNumber from the review queue, using the getWorkflow method
		
		String currentData = pnw_obj.getWorkflow().removeFromApprovalQueue();
		
		
		
		Petition currentPetition = pnw_obj.getPetitionFromDatabase(currentData);
		
		
		if(currentPetition.getBeneficiaryFirstName().equals(petitionData[0])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getBeneficiaryLastName().equals(petitionData[1])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getPetitionerFirstName().equals(petitionData[2])){
			
			count = count+1;
		}
	   
	   
	    if(currentPetition.getPetitionerLastName().equals(petitionData[3])){
			
			count = count+1;
			
		}
		
		
		if(currentPetition.getDobMonth().equals(petitionData[4])){
			
			count = count+1;
		}
		
	
		if(currentPetition.getDobDay().equals(petitionData[5])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getDobYear().equals(petitionData[6])){
			
			count = count+1;
		}
		
		
	   
		assertEquals(7,count);
		
		
		
	}
	
	
	/** The following tests if the getWorkflow method can be used to obtain all data associated with current petition 
	*  that needs Approval from the database
	*/
	
	@Test
	public void testgetNextWFpprovalQueue2(){
		
		
		int count = 0;
		
		String [] petitionData = {"Sarah","Wayne","Janet","Niles","6","9","2000"};
		
		PNW pnw_obj = new PNW();
		
		Petition petition1 = new Petition();

        petition1.setBeneficiaryFirstName("Sarah");
        petition1.setBeneficiaryLastName("Wayne");
        petition1.setANumber("004");
        petition1.setPetitionerFirstName("Janet");
        petition1.setPetitionerLastName("Niles");
        petition1.setDobMonth(6);
        petition1.setDobDay(9);
        petition1.setDobYear(2000);
		petition1.setWorkflowStatus(1);
		
		pnw_obj.validateEntry(petition1);
		

		
		//following variable stores the current aNumber from the review queue, using the getWorkflow method
		
		String currentData = pnw_obj.getWorkflow().removeFromApprovalQueue();
		
		
		
		Petition currentPetition = pnw_obj.getPetitionFromDatabase(currentData);
		
		
		if(currentPetition.getBeneficiaryFirstName().equals(petitionData[0])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getBeneficiaryLastName().equals(petitionData[1])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getPetitionerFirstName().equals(petitionData[2])){
			
			count = count+1;
		}
	   
	   
	    if(currentPetition.getPetitionerLastName().equals(petitionData[3])){
			
			count = count+1;
			
		}
		
		
		
		if(currentPetition.getDobMonth().equals(petitionData[4])){
			
			count = count+1;
		}
		
		
		
		if(currentPetition.getDobDay().equals(petitionData[5])){
			
			count = count+1;
		}
		
		
		if(currentPetition.getDobYear().equals(petitionData[6])){
			
			count = count+1;
		}
		
		
	   
		assertEquals(7,count);
		
		
	}
	
	
	
	
}
