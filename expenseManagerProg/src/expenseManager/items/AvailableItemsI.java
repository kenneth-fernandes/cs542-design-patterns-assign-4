package expenseManager.items;

import java.util.HashMap;
import java.util.List;

import expenseManager.util.fileprocess.FileProcessorI;

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
    public void processData(FileProcessorI availItemsFileProcessObj);

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