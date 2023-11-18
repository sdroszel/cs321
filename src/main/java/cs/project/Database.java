package cs.project;

import java.util.ArrayList;
import java.util.List;

/**
 * The cs321.Database class represents a simple database for storing/managing petitions
 * using an ArrayList. It allows you to add and remove petitions and provides access
 * to the stored data.
 *
 * @author Scott Roszel
 */
public class Database {
    private final ArrayList<Petition> petitionDatabase;

    /**
     * Default constructor
     */
    public Database() {
        petitionDatabase = new ArrayList<>();
    }

    /**
     * This function adds a petition to the database
     *
     * @param petition petition to add
     */
    public void addToDatabase(Petition petition) {
        petitionDatabase.add(petition);
    }

    /**
     * This function is used to get a reference to the database
     *
     * @return the database arrayList
     */
    public List<Petition> getDatabase() {
        return petitionDatabase;
    }
}
