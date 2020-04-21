package expenseManager.state.stateprocessor;

import expenseManager.util.constants.ItemCostTypeConstants;
import expenseManager.util.constants.UtilConstants;

public class BasicStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI {
    // Stores the SpendingStateProcessorI interface for BasicStateProcessor
    // instance
    private static SpendingStateProcessorI basicStatePrcsrObj = new BasicStateProcessor();

    /**
     * Private BasicStateProcessor empty constructor
     */
    private BasicStateProcessor() {
    }

    /**
     * Returns the SpendingStateProcessorI interface for BasicStateProcessor
     * instance
     * 
     * @return - SpendingStateProcessorI interfaceor BasicStateProcessor instance
     */
    public static SpendingStateProcessorI getInstance() {
        return basicStatePrcsrObj;
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
                ? UtilConstants.YES.getConstantValue()
                : UtilConstants.NO.getConstantValue();
    }

    @Override
    public String toString() {

        return "Class: BasicStateProcessor, Data Members: [ basicStatePrcsrObj: " + basicStatePrcsrObj.toString() + "]";
    }

}