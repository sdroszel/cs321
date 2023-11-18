package cs.project;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is the workflow for the system. It holds two queues, one for review and one for approval.
 *
 * @author Scott Roszel
 */
public class Workflow {
    private final Queue<String> reviewQueue;
    private final Queue<String> approvalQueue;

    /**
     * Default constructor
     */
    public Workflow() {
        reviewQueue = new LinkedList<>();
        approvalQueue = new LinkedList<>();
    }

    /**
     * The function adds a petition to the workflow review queue
     *
     * @param aNumber Holds the petition to add
     * @return returns 1 if added successfully, 0 if not
     */
    public int addToReviewQueue(String aNumber) {
        reviewQueue.add(aNumber);
        return 0;
    }

    /**
     * The function adds a petition to the workflow approval queue
     *
     * @param aNumber Holds the petition to add
     * @return returns 1 if added successfully, 0 if not
     */
    public int addToApprovalQueue(String aNumber) {
        approvalQueue.add(aNumber);
        return 0;
    }

    /**
     * The function removes a petition from the workflow review queue
     * and passes it to the caller.
     *
     * @return returns removed petition
     */
    public String removeFromReviewQueue() {

        try {
            return reviewQueue.remove();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * The function removes a petition from the workflow approval queue
     * and passes it to the caller.
     *
     * @return returns removed petition
     */
    public String removeFromApprovalQueue() {

        try {
            return approvalQueue.remove();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * used for workflow junit test
     *
     * @return returns review queue object
     */
    public Queue<String> getReviewQueue() {
        return reviewQueue;
    }

    /**
     * used for workflow junit test
     *
     * @return returns approval queue object
     */
    public Queue<String> getApprovalQueue() {
        return approvalQueue;
    }
}
