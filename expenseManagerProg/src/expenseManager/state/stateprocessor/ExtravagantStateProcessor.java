package expenseManager.state.stateprocessor;

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

        return itemType.equals("basic") || itemType.equals("moderatelyExpensive") || itemType.equals("superExpensive")
                ? "YES"
                : "NO";
    }
}