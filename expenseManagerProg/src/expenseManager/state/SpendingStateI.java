package expenseManager.state;

/**
 * SpendingStateI
 */
public interface SpendingStateI {

    public void creditMoney(int amount);

    public void processItem(String item);
}