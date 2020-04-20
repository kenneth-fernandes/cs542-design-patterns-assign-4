package expenseManager.items;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;

/**
 * AvailableItemsI
 */
public interface AvailableItemsI {

    /**
     * The function processess each line of data from the file and stores it into a
     * HashMap
     * 
     * @param availItemsFileProcessObj - FileProcessor object
     * 
     */

    /**
     * The function processess each line of data from the file and stores it into a
     * HashMap
     * 
     * @param fileProcessorObj- FileProcessor object
     * @throws InvalidAvailItemFileFormatException
     * @throws IOException
     */
    public void storeFileData(FileProcessorI fileProcessorObj) throws InvalidAvailItemFileFormatException, IOException;

    /**
     * The function returns the available items data stored in the HashMap
     * 
     * @return - HashMap object that stores the available items
     */
    public HashMap<String, List<String>> getData();

    /**
     * The function returns the key corressponding to which the item is stored
     * 
     * @return - The key corressponding to which the item is stored
     */
    public String getKeyByData(String itemData);

}