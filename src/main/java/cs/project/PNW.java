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
    private final List<Petition> databaseList;
    private boolean validateReturn;

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

        for (Petition petition:
                databaseList) {
            if (petition.getaNumber().equals(aNumber)) {
                // if A-Number is found
                return true;
            }
        }

        return false;
    }

    /**
     * This function validates that the entries are not null or empty
     * and the month, day and year are within acceptable range.
     *
     * @param petition holds the petition that needs validated
     * @return returns true if petition passes validation
     */
    public Boolean validateEntry(Petition petition) {

        // check if entries are valid
        validateReturn = isNotEmptyOrNull(petition.getPetitionerFirstName())
                && isNotEmptyOrNull(petition.getPetitionerLastName())
                && isNotEmptyOrNull(petition.getaNumber())
                && isNotEmptyOrNull(petition.getBeneficiaryFirstName())
                && isNotEmptyOrNull(petition.getBeneficiaryLastName())
                && isDobInRange(Integer.parseInt(petition.getDobYear()), Integer.parseInt(petition.getDobMonth()), Integer.parseInt(petition.getDobDay()));

        // if valid, add to database and workflow
        if (validateReturn) {
            database.addToDatabase(petition);
            addToWorkflow(petition);
        }

        return validateReturn;
    }

    /**
     * This function gets a petition with matching A-Number from thew database
     *
     * @param aNumber A-Number to find entry
     * @return returns the petition with matching A-Number
     */
    public Petition getPetitionFromDatabase(String aNumber) {

        for (Petition petition:
                databaseList) {
            if (petition.getaNumber().equals(aNumber)) {
                // return petition with matching A-Number
                return petition;
            }
        }


        return null;
    }

    /**
     * This function adds the petition A-Number to the appropriate queue
     *
     * @param petition petition to add to workflow
     * @return returns true if added successfully
     */
    public Boolean addToWorkflow(Petition petition) {

        if (validateReturn) {
            if (petition.getWorkflowStatus() == 0) {
                // add to review queue
                workflow.addToReviewQueue(petition.getaNumber());
                return true;
            } else if (petition.getWorkflowStatus() == 1) {
                // add to approval queue
                workflow.addToApprovalQueue(petition.getaNumber());
                return true;
            }
        }



        return false;
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
