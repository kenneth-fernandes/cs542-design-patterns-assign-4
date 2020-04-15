package expenseManager.context;

import expenseManager.state.BasicState;
import expenseManager.state.ExtravagantState;
import expenseManager.state.LuxuriousState;
import expenseManager.state.SpendingStateI;

public class ExpenseManagerContext implements SpendingStateI {
    //
    private SpendingStateI basicStateObj;
    //
    private SpendingStateI luxuriousStateObj;
    //
    private SpendingStateI extravaganStateObj;
    //
    // private SpendingStateI expenseMngrCntxtObj = new ExpenseManagerContext();
    //
    private SpendingStateI currentStateObj;
    //
    private int moneyCreditCount;

    /**
     * 
     */
    public ExpenseManagerContext() {
        basicStateObj = new BasicState(this);
        luxuriousStateObj = new LuxuriousState(this);
        extravaganStateObj = new ExtravagantState(this);
        currentStateObj = basicStateObj;
    }

    public void setCurrentState(SpendingStateI state) {
        currentStateObj = state;
    }

    public SpendingStateI getCurrentState() {
        return currentStateObj;
    }

    public SpendingStateI getBasicState() {
        return basicStateObj;
    }

    public SpendingStateI getLuxuriousState() {
        return luxuriousStateObj;
    }

    public SpendingStateI getExtravagantState() {
        return extravaganStateObj;
    }

    @Override
    public void storeData(String data, boolean isPurchasable) {
        currentStateObj.storeData(data, isPurchasable);
    }

}