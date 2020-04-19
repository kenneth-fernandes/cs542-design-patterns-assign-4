package expenseManager.state;

public class BasicStateProcessor extends SpendingStateProcessor{


    private static BasicStateProcessor basicStatePrcsrObj = new BasicStateProcessor();

    public static BasicStateProcessor getInstance() {
        return basicStatePrcsrObj;
    }

    @Override
    protected String getIsPurchasableByItemType(String itemType) {
        
        return itemType.equals("basic") ? "YES" : "NO";
    }

}