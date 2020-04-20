package expenseManager.items;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;

/**
 * AvailableItemsI interface - Contains functions that processes data and stores
 * available list of items based on its categories.
 * 
 * @author Kenneth Peter Fernandes
 */
public interface AvailableItemsI {

    /**
     * The function processess each line of data from the file and stores it into a
     * HashMap
     * 
     * @param fileProcessorObj- FileProcessor object
     * @throws InvalidAvailItemFileFormatException - User defined exception thrown
     *                                             by validator for incorrect file
     *                                             data format
     * @throws IOException                         - Exception caused while
     *                                             Input/Output thrown by the
     *                                             function
     */
    public void storeFileData(FileProcessorI fileProcessorObj) throws InvalidAvailItemFileFormatException, IOException;

    /**
     * The function returns the available items data stored in the HashMap
     * 
     * @return - HashMap object that stores the available items
     */
    public HashMap<String, List<String>> getData();

    /**
     * The function returns theitem type key corressponding to which the item is
     * stored
     * 
     * @return - The item type corressponding to which the item is stored
     */
    public String getKeyByData(String itemData);

}