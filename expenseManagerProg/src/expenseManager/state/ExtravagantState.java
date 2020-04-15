package expenseManager.state;

import expenseManager.results.ExpenseManagerResults;

public class ExtravagantState implements SpendingStateI {
    public ExtravagantState(SpendingStateI expenseMngrCntxtObj) {

    }

    @Override
    public void storeData(String data, boolean isPurchasable) {
        ExpenseManagerResults.getExpenseResultInstance()
                .storeResults("EXTRAVEGANT::" + data + "--" + (isPurchasable ? "YES" : "NO"));
    }

}