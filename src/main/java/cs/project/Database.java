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
    private static ArrayList<Petition> database;

    /**
     * Default constructor
     */
    public Database() {
        database = new ArrayList<Petition>();
    }

    /**
     * This function adds a petition to the database
     *
     * @param petition petition to add
     */
    public boolean addToDatabase(Petition petition) {
        return database.add(petition);
    }

    /**
     * This function removes a petition from the database
     *
     * @param petition petition to remove
     * @return returns true if removed
     */
    public boolean removeFromDatabase(Petition petition) {
        return database.remove(petition);
    }

    /**
     * This function is used to get a reference to the database
     *
     * @return the database arrayList
     */
    public List<Petition> getDatabase() {
        return database;
    }
}
