package expenseManager.context;

import java.util.List;

import expenseManager.state.SpendingStateI;

public interface ExpenseMngrContextI {

    public SpendingStateI getBasicState();

    public SpendingStateI getLuxuriousState();

    public SpendingStateI getExtravagantState();

    public Double getRunAvgCreditAmount();

    public void setRunAvgCreditAmount(Double avg);

    public List<Integer> getMoneyCreditLst();

    public void setCurrentState(SpendingStateI state);

    public SpendingStateI getCurrentState();

    public boolean getIsItemPurchasable();

    public void setItemPurchasableFlag(boolean flag);

    public int getRunAvgWinSize();

}