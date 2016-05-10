package concordance;

/**
 *
 * @author dpoumakis
 */
public class LinkedListNode
{
    private Integer lineNumber;
    private LinkedListNode next;
    
    public LinkedListNode(Integer lineNumber, LinkedListNode next)
    {
        this.lineNumber = lineNumber;
        this.next = next;
    }
}
