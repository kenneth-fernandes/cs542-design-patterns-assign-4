package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.LuxuriousStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;

/**
 * LuxuriousSpendingState
 */
public class LuxuriousState implements SpendingStateI {

    private ExpenseMngrContextI expenseMngrCntxtObj;

    private SpendingStateProcessorI luxStatePrcsrObj;

    public LuxuriousState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        luxStatePrcsrObj = LuxuriousStateProcessor.getInstance();
    }

    @Override
    public void creditMoney(int amount) {
        List<Integer> moneyCreditList = expenseMngrCntxtObj.getMoneyCreditLst();
        moneyCreditList.add(amount);
        luxStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(),
                expenseMngrCntxtObj);

    }

    @Override
    public void processItem(String item) {
        String itemType = AvailableItems.getInstance().getKeyByData(item);
        if (!itemType.isEmpty()) {
            ExpenseMngrResults.getExpnseResInstance().storeResults("LUXURIOUS::" + item + "--"
                    + luxStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }
    }

}