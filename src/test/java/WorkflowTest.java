
import static org.junit.Assert.*;

import cs.project.Petition;
import cs.project.Workflow;
import org.junit.*;


import java.util.Queue;

/**
 * This is a test class for the cs321.Workflow object.
 *
 * @author Scott Roszel
 */
public class WorkflowTest {
    private Workflow workflow;
    private Petition newPetition;

    /**
     * Before each test, create a workflow and petition object
     */
    @Before
    public void createObjectsForTests() {
        workflow = new Workflow();
        newPetition = new Petition();
    }

    /**
     *  This test stores the size before and after adding object to queue.
     *  Test fails if the new queue size does not equal the old queue size plus one.
     */
    @Test
    public void testAddToReviewQueueIncrement() {
        // get current queue size
        int currentSize = workflow.getReviewQueue().size();

        // add to the queue
        workflow.addToReviewQueue(newPetition.getaNumber());

        // get new queue size
        int newSize = workflow.getReviewQueue().size();

        // check if queue size incremented by 1
        assertEquals(currentSize + 1, newSize);
    }

    /**
     *  This test adds a petition to the workflow
     *  Test fails if not successfully dded to queue
     */
    @Test
    public void testAddToReviewQueueReturn() {
        // get function return value
        int result = workflow.addToReviewQueue(newPetition.getaNumber());

        // check return value
        assertEquals(1, result);
    }

    /**
     *  This test stores the size before and after adding object to queue.
     *  Test fails if the new queue size does not equal the old queue size plus one.
     */
    @Test
    public void testAddToApprovalQueueIncrement() {
        // get current queue size
        int currentSize = workflow.getApprovalQueue().size();

        // add to the queue
        workflow.addToApprovalQueue(newPetition.getaNumber());

        // get new queue size
        int newSize = workflow.getApprovalQueue().size();

        // check if queue size incremented by 1
        assertEquals(currentSize + 1, newSize);
    }

    /**
     *  This test adds a petition to the workflow
     *  Test fails if not successfully dded to queue
     */
    @Test
    public void testAddToApprovalQueueReturn() {
        // get queue return value
        int result = workflow.addToApprovalQueue(newPetition.getaNumber());

        // check funstion return value
        assertEquals(1, result);
    }

    /**
     *  This test adds a new petition to queue.
     *  Test fails if return from removal function is false.
     */
    @Test
    public void testRemoveFromReviewQueueReturnNotNull() {
        // add to queue
        workflow.addToReviewQueue(newPetition.getaNumber());

        // get return object
        String returnResult = workflow.removeFromReviewQueue();

        // check if returned value is null
        assertNotNull(returnResult);
    }

    /**
     *  This test adds a new petition to queue.
     *  Test fails if returned type in not a petition object.
     */
    @Test
    public void testRemoveFromReviewQueueReturnResult() {
        //add to queue
        workflow.addToReviewQueue(newPetition.getaNumber());

        // get return object
        String returnResult = workflow.removeFromReviewQueue();

        // check if returned object is a petition
        assertEquals(newPetition, returnResult);
    }

    /**
     *  This test adds a new petition to the queue.
     *  It stores the size after adding the object to the queue.
     *  removeFromReviewQueue() is called, attempting to remove item from queue.
     *  It stores the new size after attempting to remove object from queue.
     *  Test fails if new size does not equal old size minus 1.
     *  **Will not work until after add to queue function is complete**
     */
    @Test
    public void testRemoveFromReviewQueueDecrement() {
        // add to queue
        workflow.addToReviewQueue(newPetition.getaNumber());

        // get current queue size
        int currentSize = workflow.getReviewQueue().size();

        // remove from queue
        workflow.removeFromReviewQueue();

        // get new queue size
        int newSize = workflow.getReviewQueue().size();

        // check if queue size decrements by 1
        assertEquals(currentSize - 1, newSize);
    }

    /**
     *  This test adds a new petition to queue.
     *  Test fails if return from removal function is false.
     */
    @Test
    public void testRemoveFromApprovalQueueReturnNotNull() {
        // add to queue
        workflow.addToApprovalQueue(newPetition.getaNumber());

        // get return object
        String returnResult = workflow.removeFromApprovalQueue();

        // checks if return value is null
        assertNotNull(returnResult);
    }

    /**
     *  This test adds a new petition to queue.
     *  Test fails if returned type in not a petition object.
     */
    @Test
    public void testRemoveFromApprovalQueueReturnResult() {
        // add to queue
        workflow.addToApprovalQueue(newPetition.getaNumber());

        // get return object
        String returnResult = workflow.removeFromApprovalQueue();

        // check if returned type is cs321.Petition object
        assertEquals(newPetition, returnResult);
    }

    /**
     *  This test adds a new petition to the queue.
     *  It stores the size after adding the object to the queue.
     *  removeFromReviewQueue() is called, attempting to remove item from queue.
     *  It stores the new size after attempting to remove object from queue.
     *  Test fails if new size does not equal old size minus 1.
     *  **Will not work until after add to queue function is complete**
     */
    @Test
    public void testRemoveFromApprovalQueueDecrement() {
        // add to queue
        workflow.addToApprovalQueue(newPetition.getaNumber());

        // get current queue size
        int currentSize = workflow.getApprovalQueue().size();

        // remove from queue
        workflow.removeFromApprovalQueue();

        // get new queue size
        int newSize = workflow.getApprovalQueue().size();

        // check if queue size decrements by 1
        assertEquals(currentSize - 1, newSize);
    }

    /**
     *  This test checks the return type.
     *  Test fails if returned type is null.
     */
    @Test
    public void testGetReviewQueueNotNull() {
        // get function return
        Queue<String> queue = workflow.getReviewQueue();

        // check if is a queue object
        assertNotNull(queue);
    }

    /**
     *  This test checks the return type.
     *  Test fails if returned type is null.
     */
    @Test
    public void testGetApprovalQueueNotNull() {
        // get function return
        Queue<String> queue = workflow.getApprovalQueue();

        // check if is a queue object
        assertNotNull(queue);
    }
}

