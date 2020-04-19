package expenseManager.state.stateprocessor;

public class LuxuriousStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI{

    private static SpendingStateProcessorI luxStatePrcsrObj = new LuxuriousStateProcessor();

    public static SpendingStateProcessorI getInstance() {
        return luxStatePrcsrObj;
    }

    @Override
	public String isPurchasable(String itemType) {

        return itemType.equals("basic") || itemType.equals("moderatelyExpensive") ? "YES" : "NO";
    }

}