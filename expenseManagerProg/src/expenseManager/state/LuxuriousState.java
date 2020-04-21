package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.LuxuriousStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;
import expenseManager.util.constants.UtilConstants;

/**
 * LuxuriousSpendingState
 */
public class LuxuriousState implements SpendingStateI {
    // Stores the interface of ExpenseMngrContextI for ExpenseMngrContext instance
    private ExpenseMngrContextI expenseMngrCntxtObj;
    // Stores the interface of SpendingStateProcessorI for LuxuriousStateProcessor
    // instance
    private SpendingStateProcessorI luxStatePrcsrObj;

    /**
     * LuxuriousState constructor - Intializes the variables holding
     * ExpenseMngrContextI interface and SpendingStateProcessorI interface
     * 
     * @param inExpenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                              ExpenseMngrContext instance
     */
    public LuxuriousState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        luxStatePrcsrObj = LuxuriousStateProcessor.getInstance();
    }

    /**
     * Credits the amount in the money credit list and internally performs
     * calculation to find out the spending state
     * 
     * @param amount - The amount provided by the user through the input file
     */
    @Override
    public void creditMoney(int amount) {
        List<Integer> moneyCreditList = expenseMngrCntxtObj.getMoneyCreditLst();
        moneyCreditList.add(amount);
        luxStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(),
                expenseMngrCntxtObj);

    }

    /**
     * Processes the item provided by the user through input file which internally
     * checks whether item can be purchased based on the current spending state
     * 
     * @param item - The item provided by the user through the input file
     */
    @Override
    public void processItemPuchasability(String item) {
        String itemType = AvailableItems.getInstance().getKeyByData(item);
        if (!itemType.isEmpty()) {
            ExpenseMngrResults.getExpnseResInstance()
                    .storeResults(UtilConstants.LUXURIOUS_STATE.getConstantValue()
                            + UtilConstants.DOUBLE_COLON.getConstantValue() + item
                            + UtilConstants.DOUBLE_HYPHEN.getConstantValue()
                            + luxStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }
    }

}