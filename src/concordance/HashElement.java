package concordance;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class HashElement
{

    // String to store the word
    private String word;

    // LinkedList to store nodes containing line #'s
    private LinkedList<LinkedListNode> lineNumbers;

    // Constructor via word
    public HashElement(String word)
    {
        // Store the word
        this.word = word;

        // Initialize the LinkedList
        lineNumbers = new LinkedList<>();
    }

    // Method to add nodes with a lineNumber
    public void addNode(LinkedListNode lineNumber)
    {
        lineNumbers.add(lineNumber);
    }

    // Get word...
    public String getWord()
    {
        return word;
    }

    // Set word... Even though I don't recommend using, still good to have
    public void setWord(String word)
    {
        this.word = word;
    }

    // Get LinkedList...
    public LinkedList<LinkedListNode> getLineNumbers()
    {
        return lineNumbers;
    }

    // Set LinkedList... Even though I don't recommend using, still good to have
    public void setLineNumbers(LinkedList<LinkedListNode> lineNumbers)
    {
        this.lineNumbers = lineNumbers;
    }

    // toString method 
    @Override
    public String toString()
    {
        // Initialize an empty string to store lines
        String lines = "";
        
        // Iterate through each node in linked list
        for (LinkedListNode line : lineNumbers)
        {
            // Append line number to the string
            lines += line.toString() + ", ";
        }
        
        // Remove the trailing comma and whitespace
        lines = lines.substring(0, lines.length()-2);
      
        // Return the line numbers
        return lines;
    }
}
