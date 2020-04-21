package expenseManager.state;

import java.util.List;

import expenseManager.context.ExpenseMngrContextI;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.state.stateprocessor.BasicStateProcessor;
import expenseManager.state.stateprocessor.SpendingStateProcessorI;
import expenseManager.util.constants.UtilConstants;

/**
 * BasicSpendingState class - Implements the functions of the SpendingStateI
 * interface that is provided to the user end to credit money and check the item
 * purchasability
 * 
 * @author Kenneth Peter Fernandes
 */
public class BasicState implements SpendingStateI {
    // Stores the interface of ExpenseMngrContextI for ExpenseMngrContext instance
    private ExpenseMngrContextI expenseMngrCntxtObj;
    // Stores the interface of SpendingStateProcessorI for BasicStateProcessor
    // instance
    private SpendingStateProcessorI basicStatePrcsrObj;

    /**
     * BasicState constructor - Intializes the variables holding ExpenseMngrContextI
     * interface and SpendingStateProcessorI interface
     * 
     * @param inExpenseMngrCntxtObj - ExpenseMngrContextI interface for
     *                              ExpenseMngrContext instance
     */
    public BasicState(ExpenseMngrContextI inExpenseMngrCntxtObj) {
        expenseMngrCntxtObj = inExpenseMngrCntxtObj;
        basicStatePrcsrObj = BasicStateProcessor.getInstance();
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
        basicStatePrcsrObj.processSpendingState(moneyCreditList, expenseMngrCntxtObj.getRunAvgWinSize(),
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
            ExpenseMngrResults.getExpnseResInstance().storeResults(
                    UtilConstants.BASIC_STATE.getConstantValue() + UtilConstants.DOUBLE_COLON.getConstantValue() + item
                            + UtilConstants.DOUBLE_HYPHEN.getConstantValue()
                            + basicStatePrcsrObj.getIsPurchasableByItemType(itemType));
        }

    }

    @Override
    public String toString() {
        return "Class: BasicState, Data Members: [ expenseMngrCntxtObj: " + expenseMngrCntxtObj.toString()
                + ", basicStatePrcsrObj: " + basicStatePrcsrObj.toString() + "]";
    }

}