package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.ExtravagantStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;

public class ExtravagantState implements SpendingStateI {

    private ExpenseMngrContextI expenseMngrCntxtObj;

    private SpendingStateProcessorI extvgntStatePrcsrObj;

    public ExtravagantState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        extvgntStatePrcsrObj = ExtravagantStateProcessor.getInstance();
    }

    @Override
    public void creditMoney(int amount) {
        List<Integer> moneyCreditList = expenseMngrCntxtObj.getMoneyCreditLst();
        moneyCreditList.add(amount);
        extvgntStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(), expenseMngrCntxtObj);
    }

    @Override
    public void processItem(String item) {
        String itemType = AvailableItems.getInstance().getKeyByData(item);
        if (!itemType.isEmpty()) {
            ExpenseMngrResults.getExpnseResInstance().storeResults("EXTRAVEGANT::" + item + "--"
                    + extvgntStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }
    }
}