package expenseManager.state;

import expenseManager.results.ExpenseManagerResults;

/**
 * BasicSpendingState
 */
public class BasicState implements SpendingStateI {
    public BasicState(SpendingStateI expenseMngrCntxtObj) {

    }

    @Override
    public void storeData(String data, boolean isPurchasable) {
        ExpenseManagerResults.getExpenseResultInstance()
                .storeResults("BASIC::" + data + "--" + (isPurchasable ? "YES" : "NO"));
    }

}