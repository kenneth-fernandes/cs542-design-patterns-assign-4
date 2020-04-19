package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.BasicStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;

/**
 * BasicSpendingState
 */
public class BasicState implements SpendingStateI {

    private ExpenseMngrContextI expenseMngrCntxtObj;
    private SpendingStateProcessorI basicStatePrcsrObj;

    public BasicState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        basicStatePrcsrObj = BasicStateProcessor.getInstance();
    }

    @Override
    public void creditMoney(int amount) {
        List<Integer> moneyCreditList = expenseMngrCntxtObj.getMoneyCreditLst();
        moneyCreditList.add(amount);
        basicStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(),
                expenseMngrCntxtObj);
                
    }

    @Override
    public void processItem(String item) {
        String itemType = AvailableItems.getInstance().getKeyByData(item);
        if (!itemType.isEmpty()) {
            ExpenseMngrResults.getExpnseResInstance()
                    .storeResults("BASIC::" + item + "--" + basicStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }

    }

}