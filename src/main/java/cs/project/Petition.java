package cs.project;

/**
 * The Petition class represents a data structure for storing data for a petition.
 *
 * @author Scott Roszel
 */
public class Petition {

    // Data fields for petitioner and beneficiary details, DOB, and workflow status.
    private String petitionerFirstName;
    private String petitionerLastName;
    private String aNumber;
    private String beneficiaryFirstName;
    private String beneficiaryLastName;
    private String dobMonth;
    private String dobDay;
    private String dobYear;
    private int workflowStatus;

    /**
     * Default constructor
     */
    public Petition() {
        this.petitionerFirstName = "";
        this.petitionerLastName = "";
        this.aNumber = "";
        this.beneficiaryFirstName = "";
        this.beneficiaryLastName = "";
        this.dobMonth = "";
        this.dobDay = "";
        this.dobYear = "";
        this.workflowStatus = 0;
    }

    /**
     * Setters and getters for the cs321.Petition fields.
     */

    public void setPetitionerFirstName(String petitionerFirstName) {
        this.petitionerFirstName = petitionerFirstName;
    }

    public String getPetitionerFirstName() {
        return petitionerFirstName;
    }

    public void setPetitionerLastName(String petitionerLastName) {
        this.petitionerLastName = petitionerLastName;
    }

    public String getPetitionerLastName() {
        return petitionerLastName;
    }

    public void setANumber(String aNumber) {
        this.aNumber = aNumber;
    }

    public String getaNumber() {
        return aNumber;
    }

    public void setBeneficiaryFirstName(String firstName) {
        this.beneficiaryFirstName = firstName;
    }

    public String getBeneficiaryFirstName() {
        return beneficiaryFirstName;
    }

    public void setBeneficiaryLastName(String lastName) {
        this.beneficiaryLastName = lastName;
    }

    public String getBeneficiaryLastName() {
        return beneficiaryLastName;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = String.valueOf(dobMonth);
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = String.valueOf(dobDay);
    }

    public String getDobDay() {
        return dobDay;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = String.valueOf(dobYear);
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setWorkflowStatus(int workflowStatus) {
        this.workflowStatus = workflowStatus;
    }

    public int getWorkflowStatus() {
        return workflowStatus;
    }
}
