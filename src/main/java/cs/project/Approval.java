package cs.project;

public class Approval {

    private Petition petition;

    public Approval() {
        petition = null;
    }

    public boolean getNextFromWorkflow() {
        return true;
    }

    public boolean approve() {
        return true;
    }

    public boolean reject() {
        return true;
    }

    private boolean sendEmail() {
        return true;
    }


}
