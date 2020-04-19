package expenseManager.state.stateprocessor;

public class ExtravagantStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI {
    private static SpendingStateProcessorI extvgntStatePrcsrObj = new ExtravagantStateProcessor();

    public static SpendingStateProcessorI getInstance() {
        return extvgntStatePrcsrObj;
    }

    @Override
	public String isPurchasable(String itemType) {

        return itemType.equals("basic") || itemType.equals("moderatelyExpensive") || itemType.equals("superExpensive")
                ? "YES"
                : "NO";
    }
}