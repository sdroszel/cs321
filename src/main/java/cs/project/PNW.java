package cs.project;

import java.util.*;

/**
 * This is the main business object class. It holds the workflow and database objects and is responsible for
 * adding and retrieving from the workflow and database as well as validating that the data is correct.
 *
 * @author Scott Roszel
 */
public class PNW {

    private final Workflow workflow;
    private final Database database;
    private final HashMap<String, Petition> databaseList;

    /**
     * Default constructor
     */
    public PNW() {
        this.workflow = new Workflow();
        this.database = new Database();
        this.databaseList = database.getDatabase();
    }

    /**
     * This function checks to see if the A-Number already
     * exists in the database.
     *
     * @param aNumber holds the A-Number to check
     * @return true if found, false if not found
     */
    public Boolean checkDatabase(String aNumber) {
        return databaseList.containsKey(aNumber);
    }

    /**
     * This function validates that the entries are not null or empty
     * and the month, day and year are within acceptable range.
     *
     * @param petition holds the petition that needs validated
     * @return returns true if petition passes validation
     */
    public String validateEntry(Petition petition) {

        String textFields = checkIfStringsNullOrEmpty(petition);
        if (textFields != null) return textFields;

        String inputStrings = checkIfStringsContainNonAlphabetic(petition);
        if (inputStrings != null) return inputStrings;

        String aNumber = checkIfStringContainsOnlyDigits(petition);
        if (aNumber != null) return aNumber;

        String dobString = checkDob(petition);
        if (dobString != null) return dobString;


        // if valid, add to database and workflow
        if (!checkDatabase(petition.getaNumber())) {
            database.addToDatabase(petition);
        }

        addToWorkflow(petition);


        return null;
    }

    private String checkDob(Petition petition) {
        if (Boolean.FALSE.equals(isDobInRange(Integer.parseInt(petition.getDobYear()), Integer.parseInt(petition.getDobMonth()), Integer.parseInt(petition.getDobDay())))) {
            return "Invalid Date of Birth";
        }
        return null;
    }

    private static String checkIfStringContainsOnlyDigits(Petition petition) {
        char[] string;
        string = petition.getaNumber().toCharArray();

        for (char c : string) {
            if (!Character.isDigit(c)) {
                return "Invalid A-Number. Can only contain numbers.";
            }
        }
        return null;
    }

    private static String checkIfStringsContainNonAlphabetic(Petition petition) {
        char[] string;
        string = petition.getPetitionerFirstName().toCharArray();

        for (char c: string) {
            if (!Character.isAlphabetic(c)) {
                return "Invalid Petitioner First Name. Can only contain alphabetic characters.";
            }
        }

        string = petition.getPetitionerLastName().toCharArray();

        for (char c: string) {
            if (!Character.isAlphabetic(c)) {
                return "Invalid Petitioner Last Name. Can only contain alphabetic characters.";
            }
        }

        string = petition.getBeneficiaryFirstName().toCharArray();

        for (char c: string) {
            if (!Character.isAlphabetic(c)) {
                return "Invalid Beneficiary First Name. Can only contain alphabetic characters.";
            }
        }

        string = petition.getBeneficiaryLastName().toCharArray();

        for (char c: string) {
            if (!Character.isAlphabetic(c)) {
                return "Invalid Beneficiary Last Name. Can only contain alphabetic characters.";
            }
        }
        return null;
    }

    private String checkIfStringsNullOrEmpty(Petition petition) {
        if (Boolean.FALSE.equals(isNotEmptyOrNull(petition.getPetitionerFirstName()))) {
            return "Invalid Petitioner First Name";
        }

        if (Boolean.FALSE.equals(isNotEmptyOrNull(petition.getPetitionerLastName()))) {
            return "Invalid Petitioner Last Name";
        }

        if (Boolean.FALSE.equals(isNotEmptyOrNull(petition.getaNumber()))) {
            return "Invalid A-Number";
        }

        if (Boolean.FALSE.equals(isNotEmptyOrNull(petition.getBeneficiaryFirstName()))) {
            return "Invalid Beneficiary First Name";
        }

        if (Boolean.FALSE.equals(isNotEmptyOrNull(petition.getBeneficiaryLastName()))) {
            return "Invalid Beneficiary Last Name";
        }

        return null;
    }

    /**
     * This function gets a petition with matching A-Number from thew database
     *
     * @param aNumber A-Number to find entry
     * @return returns the petition with matching A-Number
     */
    public Petition getPetitionFromDatabase(String aNumber) {
        return databaseList.get(aNumber);
    }

    /**
     * This function adds the petition A-Number to the appropriate queue
     *
     * @param petition petition to add to workflow
     * @return returns true if added successfully
     */
    public Boolean addToWorkflow(Petition petition) {

        // Temporarily bypassing logic to test approval screen

//            if (petition.getWorkflowStatus() == 0) {
//                // add to review queue
//                workflow.addToReviewQueue(petition.getaNumber());
//                return true;
//            } else if (petition.getWorkflowStatus() == 1) {
//                // add to approval queue
//                workflow.addToApprovalQueue(petition.getaNumber());
//                return true;
//            }

        // Temporary code until Review Screen is connected to Menu Screen
        // Feel free to change it back once Review Screen is set up
        workflow.addToReviewQueue(petition.getaNumber());
        workflow.addToApprovalQueue(petition.getaNumber());

        return false;
    }

    /**
     * Peeks at next petition in approval queue without removing it.
     *
     * @return the next petition from the queue, or null if none.
     */
    public Petition getNextFromApproval() {
        String aNum = workflow.peekApprovalQueue();

        if (aNum == null) {
            return null;
        }

        return databaseList.get(aNum);
    }

    /**
     * Removes petition from approval queue after verifying it's the
     * correct one.
     *
     * @param aNum the A-Number of the petition to be removed.
     */
    public void removeFromApproval(String aNum) {
        if (workflow.peekApprovalQueue().equals(aNum)) {
            workflow.removeFromApprovalQueue();
        }
    }

    /**
     * This function checks if a string data field is empty or null
     *
     * @param string string to check
     * @return returns true if not null or empty
     */
    private Boolean isNotEmptyOrNull(String string) {
        return string != null && !string.isEmpty();
    }

    /**
     * This function checks if the entered date is within range
     * based on the provided year and month
     *
     * @param year holds year value
     * @param month holds month value
     * @param day holds day value
     * @return returns true if year, month and day are within range
     */
    private Boolean isDobInRange(int year, int month, int day) {

        if (year < 1920 || year > 2007 || month < 0 || month > 12) {
            // month or year out of range
            return false;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            // month with 31 days
            return day > 0 && day <= 31;

        } else if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                // February leap year
                return day > 0 && day <= 29;
            }
            else {
                // February not leap year
                return day > 0 && day <= 28;
            }
        }
        else {
            // month with 30 days
            return day > 0 && day <= 30;
        }
    }
}
