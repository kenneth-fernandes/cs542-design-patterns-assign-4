package expenseManager.items;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expenseManager.util.constants.ExceptionConstants;
import expenseManager.util.constants.UtilConstants;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.ValidatorFetcher;
import expenseManager.util.validator.ValidatorFetcherI;
import expenseManager.util.validator.ValidatorUtil;
import expenseManager.util.validator.ValidatorUtilI;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;

/**
 * AvailableItems class - Implements the functions of AvailableItemsI interface
 * that processes data and stores available list of items based on its
 * categories
 * 
 * @author Kenneth Peter Fernandes
 */
public class AvailableItems implements AvailableItemsI {
    // Stores the AvailableItemsI interface for AvailableItems instance
    private static AvailableItemsI availItemsObj = new AvailableItems();
    // Stores the list of type of item and item name
    private HashMap<String, List<String>> availItemsData = new HashMap<>();
    // Stores the current line data processed from the Available Items file
    private String availItemData;
    // Stores the interface of ValidatorUtilI for ValidatorUtil instance
    ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
    // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
    ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

    /**
     * AvailableItems private constructor
     */
    private AvailableItems() {
    }

    /**
     * Returns the AvailableItemsI interface for AvailableItems single instance
     * 
     * @return - AvailableItemsI interface for AvailableItems single instance
     */
    public static AvailableItemsI getInstance() {
        return availItemsObj;
    }

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
    @Override
    public void storeFileData(FileProcessorI fileProcessorObj) throws InvalidAvailItemFileFormatException, IOException {

        try {
            while ((availItemData = fileProcessorObj.readLine()) != null) {
                validatrUtilObj.validateAvailItemFileData(
                        ExceptionConstants.AVAILABLE_ITEMS_DATA_PROCESSING_ERROR_MSG.getErrorMsg(),
                        validatrFetchrObj.availItmFileFormatValidn(availItemData));
                String[] keyValArr = availItemData.split(UtilConstants.COLON_CHAR.getConstantValue());
                insertData(keyValArr[0], keyValArr[1]);
            }
            fileProcessorObj.closeFile();
        } catch (IOException | InvalidAvailItemFileFormatException e) {
            try {
                fileProcessorObj.closeFile();
            } catch (IOException e1) {
                throw e1;
            }
            throw e;
        }
    }

    /**
     * The function returns the available items data stored in the HashMap
     * 
     * @return - HashMap object that stores the available items
     */
    public HashMap<String, List<String>> getData() {
        return availItemsData;
    }

    /**
     * The function inserts available items data in the HashMap object based on the
     * key
     * 
     * @param key   - The category to which the item belongs
     * @param value - The item name
     * 
     */
    private void insertData(String key, String value) {
        List<String> lst;
        if (availItemsData.containsKey(key)) {
            lst = availItemsData.get(key);
            lst.add(value);
            availItemsData.put(key, lst);
        } else {
            lst = new ArrayList<>();
            lst.add(value);
            availItemsData.put(key, lst);
        }

    }

    /**
     * The function returns theitem type key corressponding to which the item is
     * stored
     * 
     * @return - The item type corressponding to which the item is stored
     */
    public String getKeyByData(String itemData) {
        for (String itemType : availItemsData.keySet()) {
            for (String item : availItemsData.get(itemType)) {
                if (itemData.equals(item)) {
                    return itemType;
                }
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "Class - AvailableItems : []";
    }

}