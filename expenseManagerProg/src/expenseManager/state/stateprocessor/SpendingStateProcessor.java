package expenseManager.state.stateprocessor;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;

/**
 * SpendingStateProcessor abstract class - Contains methods that are used by
 * state processor class to perfomr spending state processing
 * 
 * @author Kenneth Peter Fernandes
 */
public abstract class SpendingStateProcessor {
    /**
     * Performs the processing of state by running average calculation of the
     * credited amounts and changing of state based value of the average calculated
     * 
     * @param moneyCreditList     - List of money credited
     * @param windowSize          - Window size for running average calculation
     * @param expenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                            ExpenseMngrContext instance
     */
    public final void processSpendingState(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj) {
        // Invoking the function to calculate running average
        performRunAvgCaln(moneyCreditList, windowSize, expenseMngrCntxtObj);
        // Invoking the function to perform spending state change
        performStateChange(expenseMngrCntxtObj);

    }

    /**
     * Returns the "YES" or "NO" string if the item of an item-type is purchasable
     * based on the spending state
     * 
     * @param itemType - Category of the item to be purchased
     * @return
     */
    public final String getIsPurchasableByItemType(String itemType) {
        return isPurchasable(itemType);
    }

    /**
     * Returns whether the item of an item type is pucrchasable or not based on the
     * spending state
     * 
     * @param itemType - Category of the item to be purchased
     * @return - "YES" or "NO" string
     */
    protected abstract String isPurchasable(String itemType);

    /**
     * Performs the state change of the spending ability of the user
     * 
     * @param expenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                            ExpenseMngrContext instance
     */
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

    /**
     * Performs the calulation of running average based on the window size
     * 
     * @param moneyCreditList     - List of amounts credited
     * @param windowSize          - Window size for running average calculation
     * @param expenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                            ExpenseMngrContext instance
     */
    private void performRunAvgCaln(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj) {
        int total = 0;
        if (moneyCreditList.size() >= windowSize) {
            int startPosition = moneyCreditList.size() - windowSize;
            for (int i = startPosition; i < moneyCreditList.size(); i += 1) {
                total += moneyCreditList.get(i);
            }
            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / windowSize);
        } else {
            for (Integer money : moneyCreditList) {
                total += money;
            }
            expenseMngrCntxtObj.setRunAvgCreditAmount((double) total / moneyCreditList.size());
        }

    }
}