package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseManagerContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.util.input.ExpenseManagerInput;

/**
 * LuxuriousSpendingState
 */
public class LuxuriousState implements SpendingStateI {

    private ExpenseManagerContextI expenseMngrCntxtObj;

    public LuxuriousState(ExpenseManagerContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
    }

    @Override
    public void creditMoney(int amount) {
        List<Integer> moneyCreditList = expenseMngrCntxtObj.getMoneyCreditLst();
        moneyCreditList.add(amount);
        performRunAvgCaln(moneyCreditList, ExpenseManagerInput.getInstance().getRunAvgWinSize());
        performStateChange();

    }

    @Override
    public void processItem(String item) {
        String itemType = AvailableItems.getInstance().getKeyByData(item);
        if (!itemType.isEmpty()) {
            ExpenseMngrResults.getExpnseResInstance().storeResults(
                    "LUXURIOUS::" + item + "--" + (itemType.equals("moderatelyExpensive") || itemType
                            .equals("basic") ? "YES" : "NO"));
        }
    }

    private void performRunAvgCaln(List<Integer> moneyCreditList, int windowSize) {
        int total = 0;
        if (moneyCreditList.size() == windowSize) {
            for (Integer money : moneyCreditList) {
                total += money;
            }
           
            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / windowSize);
            moneyCreditList.remove(0);
        } else {
            for (Integer money : moneyCreditList) {
                total += money;
            }
            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / moneyCreditList.size());
        }
    }

    private void performStateChange() {
        Double avg = expenseMngrCntxtObj.getRunAvgCreditAmount();
        if (avg >= (double) 10000 && avg < (double) 50000) {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getLuxuriousState());
        } else if (avg >= (double) 50000) {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getExtravagantState());
        } else {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getBasicState());
        }
    }

}