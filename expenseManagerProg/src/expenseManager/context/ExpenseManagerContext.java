package expenseManager.context;

import java.util.ArrayList;
import java.util.List;

import expenseManager.state.BasicState;
import expenseManager.state.ExtravagantState;
import expenseManager.state.LuxuriousState;
import expenseManager.state.SpendingStateI;

public class ExpenseManagerContext implements SpendingStateI, ExpenseManagerContextI {
    //
    private SpendingStateI basicStateObj;
    //
    private SpendingStateI luxuriousStateObj;
    //
    private SpendingStateI extravaganStateObj;
    //
    private SpendingStateI currentStateObj;
    //
    private List<Integer> moneyCreditLst;
    //
    private Double runAvgCreditAmount;
    //
    private boolean isPurchasable;

    /**
     * 
     */
    public ExpenseManagerContext() {

        basicStateObj = new BasicState(this);
        luxuriousStateObj = new LuxuriousState(this);
        extravaganStateObj = new ExtravagantState(this);

        currentStateObj = basicStateObj;
        runAvgCreditAmount = 0.0;

        moneyCreditLst = new ArrayList<Integer>();
        isPurchasable = false;
    }

    @Override
    public SpendingStateI getBasicState() {
        return basicStateObj;
    }

    @Override
    public SpendingStateI getLuxuriousState() {
        return luxuriousStateObj;
    }

    @Override
    public SpendingStateI getExtravagantState() {
        return extravaganStateObj;
    }

    @Override
    public void setCurrentState(SpendingStateI state) {
        currentStateObj = state;
    }

    @Override
    public SpendingStateI getCurrentState() {
        return currentStateObj;
    }

    @Override
    public List<Integer> getMoneyCreditLst() {
        return moneyCreditLst;
    }

    @Override
    public void setItemPurchasableFlag(boolean flag) {
        isPurchasable = flag;
    }

    @Override
    public boolean getIsItemPurchasable() {
        return isPurchasable;
    }

    @Override
    public Double getRunAvgCreditAmount() {
        return runAvgCreditAmount;
    }

    public void setRunAvgCreditAmount(Double avg) {
        runAvgCreditAmount = avg;
    }

    @Override
    public void creditMoney(int amount) {
        currentStateObj.creditMoney(amount);
    }

    @Override
    public void processItem(String item) {
        currentStateObj.processItem(item);
    }

}