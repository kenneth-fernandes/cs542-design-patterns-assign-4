package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ExpenseResultPersisterI interface - Contains function to store the result
 * captured into a file
 * 
 * @author Kenneth Peter Fernandes
 */
public interface ExpenseResultPersisterI {
    /**
     * Store the result captured in the data-structure to the output file
     * 
     * @param filePath - Output file path
     * @throws FileNotFoundException - Exception caused while Input/Output thrown by
     *                               the function
     *
     * @throws IOException           - Exception caused while Input/Output thrown by
     *                               the function
     *
     */
    public void storeResultToFile(String filePath) throws FileNotFoundException, IOException;
}