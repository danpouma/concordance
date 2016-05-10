package concordance;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
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
            File file = new File("./words.txt");
            
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
                        
                    }
                    // If word is not in the hash...
                    else
                    {
                        // Create hash element that will store word && line #'s
                        HashElement lines = new HashElement(word);
                        
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
        catch (Exception e)
        {
            System.out.println("Error");
        }
        
        // Output values from table via it's toString() method
        System.out.println(table.values());
        
    }
    
    public static String canonicalFunction(String word)
    {
        StringBuilder formattedWord = new StringBuilder();
        
        if(word.matches(".*\\..*\\..*"))
        {
            return word;
        }
        else
        {
            for (char character : word.toCharArray()) 
            {
                if ((character >= '0' && character <= '9') 
                    || (character >= 'A' && character <= 'Z')
                    || (character >= 'a' && character <= 'z') )
                {
                    formattedWord.append(character);
                }
            }
        }
    
        return formattedWord.toString().toLowerCase();
    }
}
