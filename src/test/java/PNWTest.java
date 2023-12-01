import cs.project.Database;
import cs.project.PNW;
import cs.project.Petition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a test class for the cs321.PNW object.
 *
 * @author Scott Roszel & Victor Londono
 */
public class PNWTest {
    PNW pnw;
    Petition petition;
    Database database;

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
     * @author Scott Roszel
     */
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

    /**
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
     * @author Scott Roszel
     */
    @Test
    public void testCheckDatabaseEmptyDatabase() {

        Boolean result = pnw.checkDatabase("003");

        assertFalse(result);
    }

    /**
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
}
