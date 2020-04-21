package expenseManager.state.stateprocessor;

import expenseManager.util.constants.ItemCostTypeConstants;
import expenseManager.util.constants.UtilConstants;

/**
 * LuxuriousStateProcessor class - Extends the functions, to process spending
 * state, of SpendingStateProcessor abstract class which in-turn implements the
 * SpendingStateProcessorI interface
 * 
 * @author Kenneth Peter Fernandes
 */
public class LuxuriousStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI {
    // Stores the SpendingStateProcessorI interface for LuxuriousStateProcessor
    // instance
    private static SpendingStateProcessorI luxStatePrcsrObj = new LuxuriousStateProcessor();

    /**
     * Private LuxuriousStateProcessor empty constructor
     */
    private LuxuriousStateProcessor() {
    }

    /**
     * Returns the SpendingStateProcessorI interface for LuxuriousStateProcessor
     * instance
     * 
     * @return - SpendingStateProcessorI interfaceor LuxuriousStateProcessor
     *         instance
     */
    public static SpendingStateProcessorI getInstance() {
        return luxStatePrcsrObj;
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
                        ? UtilConstants.YES.getConstantValue()
                        : UtilConstants.NO.getConstantValue();
    }

}