package concordance;

/**
 *
 * @author dpoumakis
 */
public class LinkedListNode
{

    // Integer to store line number
    private Integer lineNumber;

    // Node to store next pointer
    private LinkedListNode next;

    // Constructor via lineNumber
    public LinkedListNode(Integer lineNumber)
    {
        this.lineNumber = lineNumber;
    }
    
    // Constructor via lineNumber && next pointer
    public LinkedListNode(Integer lineNumber, LinkedListNode next)
    {
        // Store the line number
        this.lineNumber = lineNumber;

        // Store the next pointer
        this.next = next;
    }
}
