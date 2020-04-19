package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;

public abstract class SpendingStateProcessor {
    protected final void processSpendingState(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj) {
        performRunAvgCaln(moneyCreditList, windowSize, expenseMngrCntxtObj);
        performStateChange(expenseMngrCntxtObj);

    }

    protected abstract String getIsPurchasableByItemType(String itemType);

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

            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / windowSize);
            moneyCreditList.remove(0);
        } else {
            for (Integer money : moneyCreditList) {
                total += money;
            }
            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / moneyCreditList.size());
        }
    }
}