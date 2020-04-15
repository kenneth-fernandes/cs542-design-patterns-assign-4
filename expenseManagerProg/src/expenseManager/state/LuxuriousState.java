package expenseManager.state;

import expenseManager.results.ExpenseManagerResults;

/**
 * LuxuriousSpendingState
 */
public class LuxuriousState implements SpendingStateI {
    public LuxuriousState(SpendingStateI expenseMngrCntxtObj) {

    }

    @Override
    public void storeData(String data, boolean isPurchasable) {
        ExpenseManagerResults.getExpenseResultInstance()
                .storeResults("LUXURIOUS::" + data + "--" + (isPurchasable ? "YES" : "NO"));
    }

}