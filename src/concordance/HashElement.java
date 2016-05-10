package concordance;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class HashElement
{

    private String word;
    private LinkedList<LinkedListNode> lineNumbers;

    public HashElement(String word)
    {
        this.word = word;
        lineNumbers = new LinkedList<>();
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public LinkedList<LinkedListNode> getLineNumbers()
    {
        return lineNumbers;
    }

    public void setLineNumbers(LinkedList<LinkedListNode> lineNumbers)
    {
        this.lineNumbers = lineNumbers;
    }

    @Override
    public String toString()
    {
        return "HashElement{" + "word=" + word + ", lineNumbers=" + lineNumbers.size() + '}';
    }
}
