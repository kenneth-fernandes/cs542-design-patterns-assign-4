package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.ExtravagantStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;
import expenseManager.util.constants.UtilConstants;

public class ExtravagantState implements SpendingStateI {
    // Stores the interface of ExpenseMngrContextI for ExpenseMngrContext instance
    private ExpenseMngrContextI expenseMngrCntxtObj;
    // Stores the interface of SpendingStateProcessorI for ExtravagantStateProcessor
    // instance
    private SpendingStateProcessorI extvgntStatePrcsrObj;

    /**
     * ExtravagantState constructor - Intializes the variables holding
     * ExpenseMngrContextI interface and SpendingStateProcessorI interface
     * 
     * @param inExpenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                              ExpenseMngrContext instance
     */
    public ExtravagantState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        extvgntStatePrcsrObj = ExtravagantStateProcessor.getInstance();
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
        extvgntStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(),
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
                    .storeResults(UtilConstants.EXTRAVAGANT_STATE.getConstantValue()
                            + UtilConstants.DOUBLE_COLON.getConstantValue() + item
                            + UtilConstants.DOUBLE_HYPHEN.getConstantValue()
                            + extvgntStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }
    }

    @Override
    public String toString() {

        return "Class: ExtravagantState, Data Members: [ expenseMngrCntxtObj: " + expenseMngrCntxtObj.toString()
                + ", extvgntStatePrcsrObj: " + extvgntStatePrcsrObj.toString() + "]";
    }

}