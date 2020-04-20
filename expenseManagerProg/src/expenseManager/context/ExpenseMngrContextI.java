package expenseManager.context;

import java.util.List;

import expenseManager.state.SpendingStateI;

/**
 * ExpenseMngrContextI interface - The interface contains method signatures that
 * are required by the context class to provide interface to all the states that
 * can access context class instance variable
 * 
 * @author Kenneth Peter Fernandes
 */
public interface ExpenseMngrContextI {
    /**
     * Returns the SpendingStateI interface for BasicState instance that implements
     * the interface
     * 
     * @return - SpendingStateI interface for BasicState instance
     */
    public SpendingStateI getBasicState();

    /**
     * Returns the SpendingStateI interface for LuxuriousState instance that
     * implements the interface
     * 
     * @return - SpendingStateI interface for LuxuriousState instance
     */
    public SpendingStateI getLuxuriousState();

    /**
     * Returns the SpendingStateI interface for ExtravagantState instance that
     * implements the interface
     * 
     * @return - SpendingStateI interface for ExtravagantState instance
     */
    public SpendingStateI getExtravagantState();

    /**
     * Stores the interface of SpendingStateI for any of the state class instances
     * that implements the interface
     * 
     * @param state - Interface of SpendingStateI for state class instances
     */
    public void setCurrentState(SpendingStateI state);

    /**
     * Returns the SpendingStateI interface for any of the state class instances
     * that implements the interface
     * 
     * @return - Interface of SpendingStateI for state class instances
     */
    public SpendingStateI getCurrentState();

    /**
     * Returns the value stored in the running average instance variable
     * 
     * @return - Running average value
     */
    public Double getRunAvgCreditAmount();

    /**
     * Stores the value of running average calculated by the function in the state
     * class to the context class instance variable
     * 
     * @param avg - Running average value
     */
    public void setRunAvgCreditAmount(Double avg);

    /**
     * Returns the list of money that is credited by the user through the input file
     * 
     * @return - List of credited money
     */
    public List<Integer> getMoneyCreditLst();

    /**
     * Returns the window size for calculating the running average
     * 
     * @return - wWndow size for calculating the running average
     */
    public int getRunAvgWinSize();

}