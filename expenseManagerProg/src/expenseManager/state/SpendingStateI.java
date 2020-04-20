package expenseManager.state;

/**
 * SpendingStateI interface - The interface contains function signatures that is
 * provided to the user end to credit money and check the item purchasability
 * 
 * @author Kenneh Peter Fernandes
 */
public interface SpendingStateI {
    /**
     * Credits the amount in the money credit list and internally performs
     * calculation to find out the spending state
     * 
     * @param amount - The amount provided by the user through the input file
     */
    public void creditMoney(int amount);

    /**
     * Processes the item provided by the user through input file which internally
     * checks whether item can be purchased based on the current spending state
     * 
     * @param item - The item provided by the user through the input file
     */
    public void processItemPuchasability(String item);
}