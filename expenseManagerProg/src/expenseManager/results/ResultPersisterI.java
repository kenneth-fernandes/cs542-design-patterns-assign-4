package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ResultPersisterI {
    /**
     * 
     * @param filePath
     */
    public void storeResultToFile(String filePath) throws FileNotFoundException, IOException;
}