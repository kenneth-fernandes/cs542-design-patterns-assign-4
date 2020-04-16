package expenseManager.items;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expenseManager.util.fileprocess.FileProcessorI;

/**
 * The class AvailableItems processes data and stores available list of items
 * based on its categories
 * 
 * @author Kenneth Fernandes
 */
public class AvailableItems implements AvailableItemsI {
    //
    private static AvailableItemsI availItemsObj = new AvailableItems();
    //
    private HashMap<String, List<String>> availItemsData = new HashMap<>();
    //
    private String availItemData;

    /**
     * AvailableItems private constructor
     */
    private AvailableItems() {
    }

    /**
     * The static function returns the single instance of AvailableItems object of
     * type AvailableItemsI
     * 
     * @return - The AvailableItems object of type AvailableItemsI
     */
    public static AvailableItemsI getInstance() {
        return availItemsObj;
    }

    /**
     * The function processess each line of data from the file and stores it into a
     * HashMap
     * 
     * @param availItemsFileProcessObj - FileProcessor object
     * 
     */
    @Override
    public void processData(FileProcessorI availItemsFileProcessObj) {

        try {
            while ((availItemData = availItemsFileProcessObj.readLine()) != null) {
                String[] keyValArr = availItemData.split(":");
                insertData(keyValArr[0], keyValArr[1]);
            }
            availItemsFileProcessObj.closeFile();
        } catch (IOException e) {
            try {
                availItemsFileProcessObj.closeFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
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
     * The function returns the item stored in the HashMap corressponding to the key
     * 
     * @return - The item stored in the HashMap corressponding to the key
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