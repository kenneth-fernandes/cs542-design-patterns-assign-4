package expenseManager.state;

public class ExtravagantStateProcessor extends SpendingStateProcessor {
    private static ExtravagantStateProcessor extvgnttatePrcsrObj = new ExtravagantStateProcessor();

    public static ExtravagantStateProcessor getInstance() {
        return extvgnttatePrcsrObj;
    }

    @Override
    protected String getIsPurchasableByItemType(String itemType) {

        return itemType.equals("basic") || itemType.equals("moderatelyExpensive") || itemType.equals("superExpensive")
                ? "YES"
                : "NO";
    }
}