package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExpenseResultPersisterI {
    /**
     * 
     * @param filePath
     */
    public void storeResultToFile(String filePath) throws FileNotFoundException, IOException;
}