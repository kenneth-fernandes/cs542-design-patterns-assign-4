package expenseManager.state;

public class LuxuriousStateProcessor extends SpendingStateProcessor {

    private static LuxuriousStateProcessor luxStatePrcsrObj = new LuxuriousStateProcessor();

    public static LuxuriousStateProcessor getInstance() {
        return luxStatePrcsrObj;
    }

    @Override
    protected String getIsPurchasableByItemType(String itemType) {

        return itemType.equals("basic") || itemType.equals("moderatelyExpensive") ? "YES" : "NO";
    }

}