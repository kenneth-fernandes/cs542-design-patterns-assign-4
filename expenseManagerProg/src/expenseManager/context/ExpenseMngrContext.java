package expenseManager.context;

import java.util.ArrayList;
import java.util.List;

import expenseManager.state.BasicState;
import expenseManager.state.ExtravagantState;
import expenseManager.state.LuxuriousState;
import expenseManager.state.SpendingStateI;

/**
 * ExpenseMngrContext class - Implements the menthods of SpendingStateI and
 * ExpenseMngrContextI interfaces in order to store the current spending state
 * of the person's spending on items based on its spendability
 * 
 * @author - Kenneth Peter Fernandes
 * 
 */
public class ExpenseMngrContext implements SpendingStateI, ExpenseMngrContextI {
    // Stores the window size for calculating the running average
    private int runAvgWinSize;
    // Stores the interface of SpendingStateI that the BasicState class implements
    private SpendingStateI basicStateObj;
    // Stores the interface of SpendingStateI that the LuxuriousState class
    // implements
    private SpendingStateI luxuriousStateObj;
    // Stores the interface of SpendingStateI that the ExtravagantState class
    // implements
    private SpendingStateI extravaganStateObj;
    // Stores the interface of SpendingStateI and is the element used for accessing
    // the current state
    private SpendingStateI currentStateObj;
    // Stores the money that gets credited while reading from the input file
    private List<Integer> moneyCreditLst;
    // Stores the running average of the money that is credited with the help of a
    // window of a particular size
    private Double runAvgCreditAmount;

    /**
     * ExpenseMngrContext constructor - Initializes the instance variables
     * 
     * @param inRunAvgWinSize - Window size for calculation of running average
     */
    public ExpenseMngrContext(int inRunAvgWinSize) {

        // Storing the window size for running average calculation provided from the
        // input parameter
        runAvgWinSize = inRunAvgWinSize;

        /**
         * Spending state instances created and stored in interface variables
         */
        basicStateObj = new BasicState(this);
        luxuriousStateObj = new LuxuriousState(this);
        extravaganStateObj = new ExtravagantState(this);

        // Storing the basic state as default current spending state
        currentStateObj = basicStateObj;

        // Initialization of arraylist to store the credited money from input file
        moneyCreditLst = new ArrayList<Integer>();
    }

    /**
     * Returns the SpendingStateI interface for BasicState instance that implements
     * the interface
     * 
     * @return - SpendingStateI interface for BasicState instance
     */
    @Override
    public SpendingStateI getBasicState() {
        return basicStateObj;
    }

    /**
     * Returns the SpendingStateI interface for LuxuriousState instance that
     * implements the interface
     * 
     * @return - SpendingStateI interface for LuxuriousState instance
     */
    @Override
    public SpendingStateI getLuxuriousState() {
        return luxuriousStateObj;
    }

    /**
     * Returns the SpendingStateI interface for ExtravagantState instance that
     * implements the interface
     * 
     * @return - SpendingStateI interface for ExtravagantState instance
     */
    @Override
    public SpendingStateI getExtravagantState() {
        return extravaganStateObj;
    }

    /**
     * Stores the interface of SpendingStateI for any of the state class instances
     * that implements the interface
     * 
     * @param state - Interface of SpendingStateI for state class instances
     */
    @Override
    public void setCurrentState(SpendingStateI state) {
        currentStateObj = state;
    }

    /**
     * Returns the SpendingStateI interface for any of the state class instances
     * that implements the interface
     * 
     * @return - Interface of SpendingStateI for state class instances
     */
    @Override
    public SpendingStateI getCurrentState() {
        return currentStateObj;
    }

    /**
     * Returns the value stored in the running average instance variable
     * 
     * @return - Running average value
     */
    @Override
    public Double getRunAvgCreditAmount() {
        return runAvgCreditAmount;
    }

    /**
     * Stores the value of running average calculated by the function in the state
     * class to the context class instance variable
     * 
     * @param avg - Running average value
     */
    public void setRunAvgCreditAmount(Double avg) {
        runAvgCreditAmount = avg;
    }

    /**
     * Returns the list of money that is credited by the user through the input file
     * 
     * @return - List of credited money
     */
    @Override
    public List<Integer> getMoneyCreditLst() {
        return moneyCreditLst;
    }

    /**
     * Returns the window size for calculating the running average
     * 
     * @return - wWndow size for calculating the running average
     */
    @Override
    public int getRunAvgWinSize() {
        return runAvgWinSize;
    }

    /**
     * Credits the amount in the money credit list and internally performs
     * calculation to find out the spending state
     * 
     * @param amount - The amount provided by the user through the input file
     */
    @Override
    public void creditMoney(int amount) {
        currentStateObj.creditMoney(amount);
    }

    /**
     * Processes the item provided by the user through input file which internally
     * checks whether item can be purchased based on the current spending state
     * 
     * @param item- The item provided by the user through the input file
     */
    @Override
    public void processItemPuchasability(String item) {
        currentStateObj.processItemPuchasability(item);
    }

}