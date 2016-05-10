package concordance;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author dpoumakis
 */
public class Main
{

    public static void main(String[] args)
    {
        // Initialize the hash table
        Hashtable<String, HashElement> table = new Hashtable<>();

        // Try to open the file
        try
        {
            // Grab the file name
            File file = new File("./ant.txt");

            // Initialize the input stream via file
            FileInputStream fileStream = new FileInputStream(file);

            // Initialize the dataStrean stream via fileStream
            DataInputStream dataStream = new DataInputStream(fileStream);

            // Initialize the line number count
            int lineNumber = 0;

            // Loop until end of file
            while (fileStream.available() > 0)
            {
                // Read and store available line
                String line = (String) dataStream.readLine();

                // Initialize string tokenizer via line
                StringTokenizer stringTok = new StringTokenizer(line);

                // Loop through each token in line
                while (stringTok.hasMoreTokens())
                {
                    // Store token, in this case it's word
                    String word = stringTok.nextToken();

                    // Put token into "standard" form
                    word = canonicalFunction(word);

                    // If word is already is the hash...
                    if (table.containsKey(word))
                    {
                        // Add line number to the LinkedList
                        table.get(word).addNode(new LinkedListNode(lineNumber));
                    }
                    // If word is not in the hash...
                    else
                    {
                        // Create hash element that will store word && line #'s
                        HashElement lines = new HashElement(word);

                        lines.addNode(new LinkedListNode(lineNumber)); //, null));

                        // Put key->word and value->lines into table
                        table.put(word, lines);
                    }
                }

                // Increment the line number count
                lineNumber++;
            }

            // Close the file && data streams
            fileStream.close();
            dataStream.close();
        }
        // There was an error during the "try" statement
        catch (Exception e)
        {
            // Output an error message to console
            System.out.println("Error");
        }

        // Store the keys from table into a set
        Set<String> keys = table.keySet();

        // Iterate through each key
        for (String key : keys)
        {
            System.out.println("The word \"" + key + "\" is on line: " + table.get(key));
        }
    }

    // This function puts the word into "standard form"
    public static String canonicalFunction(String word)
    {
        // Initialize string builder, using this to build return string
        StringBuilder formattedWord = new StringBuilder();

        // Check to see if word is already in "standard" form
        // using a regular expression. Found this a while back to improve speed
        if (word.matches(".*\\..*\\..*"))
        {
            // Word is in "standard" form, return it
            return word;
        }
        // Word is not in "standard" form
        else
        {
            // Iterarte through each char is the word
            for (char character : word.toCharArray())
            {
                // If its null, start of text, end of text, etc...
                if ((character >= '0' && character <= '9')
                        // If its a valid uppercase letter...
                        || (character >= 'A' && character <= 'Z')
                        // If its a valid lowercase letter...
                        || (character >= 'a' && character <= 'z'))
                {
                    // Append the letter to the string builder
                    formattedWord.append(character);
                }
            }
        }

        return formattedWord.toString().toLowerCase();
    }
}
