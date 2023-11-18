package cs.project;

import java.util.HashMap;

/**
 * The cs321.Database class represents a simple database for storing/managing petitions
 * using an ArrayList. It allows you to add and remove petitions and provides access
 * to the stored data.
 *
 * @author Scott Roszel
 */
public class Database {
    private final HashMap<String, Petition> petitionDatabase;

    /**
     * Default constructor
     */
    public Database() {
        petitionDatabase = new HashMap<>();
    }

    /**
     * This function adds a petition to the database
     *
     * @param petition petition to add
     */
    public void addToDatabase(Petition petition) {
        petitionDatabase.put(petition.getaNumber(), petition);
    }

    /**
     * This function is used to get a reference to the database
     *
     * @return the database arrayList
     */
    public HashMap<String, Petition> getDatabase() {
        return petitionDatabase;
    }
}
