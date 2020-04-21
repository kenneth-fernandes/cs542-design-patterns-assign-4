package expenseManager.state.stateprocessor;

import expenseManager.util.constants.ItemCostTypeConstants;
import expenseManager.util.constants.UtilConstants;

public class ExtravagantStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI {
    // Stores the SpendingStateProcessorI interface for ExtravagantStateProcessor
    // instance
    private static SpendingStateProcessorI extvgntStatePrcsrObj = new ExtravagantStateProcessor();

    /**
     * Private ExtravagantStateProcessor empty constructor
     */
    private ExtravagantStateProcessor() {
    }

    /**
     * Returns the SpendingStateProcessorI interface for ExtravagantStateProcessor
     * instance
     * 
     * @return - SpendingStateProcessorI interfaceor ExtravagantStateProcessor
     *         instance
     */
    public static SpendingStateProcessorI getInstance() {
        return extvgntStatePrcsrObj;
    }

    /**
     * Returns the "YES" or "NO" string if the item of an item-type is purchasable
     * based on the spending state
     * 
     * @param itemType - Category of the item to be purchased
     * @return
     */
    @Override
    public String isPurchasable(String itemType) {

        return itemType.equals(ItemCostTypeConstants.BASIC_ITEM.getConstantValue())
                || itemType.equals(ItemCostTypeConstants.MODERATERATLY_EXPENSIVE_ITEM.getConstantValue())
                || itemType.equals(ItemCostTypeConstants.SUPER_EXPENSIVE_ITEM.getConstantValue())
                        ? UtilConstants.YES.getConstantValue()
                        : UtilConstants.NO.getConstantValue();
    }

    @Override
    public String toString() {

        return "Class: ExtravagantStateProcessor, Data Members: [ extvgntStatePrcsrObj: "
                + extvgntStatePrcsrObj.toString() + "]";
    }
}