package expenseManager.state.stateprocessor;

public class BasicStateProcessor extends SpendingStateProcessor implements SpendingStateProcessorI {


    private static SpendingStateProcessorI basicStatePrcsrObj = new BasicStateProcessor();

    public static SpendingStateProcessorI getInstance() {
        return basicStatePrcsrObj;
    }

    @Override
	public String isPurchasable(String itemType) {
        
        return itemType.equals("basic") ? "YES" : "NO";
    }

}