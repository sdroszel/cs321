package cs.project;

/**
 * The DataEntry class is responsible for checking the database for existing workers and entering petition data for
 * new non-immigrant workers.
 *
 * @author Scott Roszel
 */
public class DataEntry {
    private Petition newPetition;

    /**
     * Default constructor
     */
    public DataEntry() {
        newPetition = new Petition();
    }

    /**
     * The function stores the petitioner first name from the entry field
     * into the petition object.
     */
    private void createNewPetition() {
        this.newPetition = new Petition();
    }

    /**
     * The function stores the petitioner first name from the entry field
     * into the petition object.
     *
     * @param firstName Holds the petitioner first name
     */
    public void setPetitionerFirstName(String firstName) {
        newPetition.setPetitionerFirstName(firstName);
    }

    /**
     * The function stores the petitioner last name from the entry field
     * into the petition object.
     *
     * @param lastName Holds the petitioner last name
     */
    public void setPetitionerLastName(String lastName) {
        newPetition.setPetitionerLastName(lastName);
    }

    /**
     * The function stores the A-Number from the entry field
     * into the petition object.
     *
     * @param aNumber Holds the A-Number
     */
    public void setANumber(String aNumber) {
        newPetition.setANumber(aNumber);
    }

    /**
     * The function stores the beneficiary first name from the entry field
     * into the petition object.
     *
     * @param firstName Holds the beneficiary first name
     */
    public void setBeneficiaryFirstName(String firstName) {
        newPetition.setBeneficiaryFirstName(firstName);
    }

    /**
     * The function stores the beneficiary last name from the entry field
     * into the petition object.
     *
     * @param lastName Holds the beneficiary last name
     */
    public void setBeneficiaryLastName(String lastName) {
        newPetition.setBeneficiaryLastName(lastName);
    }

    /**
     * The function stores the DOB year from the entry field
     * into the petition object.
     *
     * @param year Holds the DOB year
     */
    public void setDobYear(String year) {
        if (year.isEmpty()) {
            return;
        }

        newPetition.setDobYear(Integer.parseInt(year));
    }

    /**
     * The function stores the DOB month from the entry field
     * into the petition object.
     *
     * @param month Holds the DOB month
     */
    public void setDobMonth(String month) {
        if (month.isEmpty()) {
            return;
        }

        newPetition.setDobMonth(Integer.parseInt(month));
    }

    /**
     * The function stores the DOB day from the entry field
     * into the petition object.
     *
     * @param day holds the DOB day
     */
    public void setDobDay(String day) {
        if (day.isEmpty()) {
            return;
        }

        newPetition.setDobDay(Integer.parseInt(day));
    }

    public Petition getPetition() {
        return this.newPetition;
    }

    /**
     *  This function clears the screen
     */
    public void clearScreen() {
        createNewPetition();
    }
}
