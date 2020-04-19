package expenseManager.state.stateprocessor;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;

public interface SpendingStateProcessorI {
    
    public void processSpendingState(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj);

    public String getIsPurchasableByItemType(String itemType);

}