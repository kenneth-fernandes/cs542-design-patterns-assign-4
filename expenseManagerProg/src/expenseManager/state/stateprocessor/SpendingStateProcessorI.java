package expenseManager.state.stateprocessor;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;

/**
 * SpendingStateProcessorI interface - Contains the functions that is
 * implemented by all the state processor class
 * 
 * @author Kenneth Peter Fernandes
 */
public interface SpendingStateProcessorI {
    /**
     * Performs the processing of state by running average calculation of the
     * credited amounts and changing of state based value of the average calculated
     * 
     * @param moneyCreditList     - List of money credited
     * @param windowSize          - Window size for running average calculation
     * @param expenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                            ExpenseMngrContext instance
     */
    public void processSpendingState(List<Integer> moneyCreditList, int windowSize,
            ExpenseMngrContextI expenseMngrCntxtObj);

    /**
     * Returns the "YES" or "NO" string if the item of an item-type is purchasable
     * based on the spending state
     * 
     * @param itemType - Category of the item to be purchased
     * @return
     */
    public String getIsPurchasableByItemType(String itemType);

}