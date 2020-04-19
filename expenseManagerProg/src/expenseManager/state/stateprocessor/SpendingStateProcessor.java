package expenseManager.state.stateprocessor;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;

public abstract class SpendingStateProcessor implements SpendingStateProcessorI {
    public final void processSpendingState(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj) {
        performRunAvgCaln(moneyCreditList, windowSize, expenseMngrCntxtObj);
        performStateChange(expenseMngrCntxtObj);

    }

    public final String getIsPurchasableByItemType(String itemType) {
        return isPurchasable(itemType);
    }

    protected abstract String isPurchasable(String itemType);

    private final void performStateChange(ExpenseMngrContextI expenseMngrCntxtObj) {
        Double avg = expenseMngrCntxtObj.getRunAvgCreditAmount();
        if (avg >= (double) 10000 && avg < (double) 50000) {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getLuxuriousState());
        } else if (avg >= (double) 50000) {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getExtravagantState());
        } else {
            expenseMngrCntxtObj.setCurrentState(expenseMngrCntxtObj.getBasicState());
        }
    }

    private void performRunAvgCaln(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj) {
        int total = 0;
        if (moneyCreditList.size() == windowSize) {
            for (Integer money : moneyCreditList) {
                total += money;
            }
            moneyCreditList.remove(0);
        } else {
            for (Integer money : moneyCreditList) {
                total += money;
            }
        }
        expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / moneyCreditList.size());
    }
}