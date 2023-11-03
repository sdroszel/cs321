package cs.project;

public class SharedData {
    private static SharedData instance;

    private final PNW businessObject;

    private SharedData() {
        // Initialize your shared data, such as the PNW object
        businessObject = new PNW();
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public PNW getBusinessObject() {
        return businessObject;
    }
}
