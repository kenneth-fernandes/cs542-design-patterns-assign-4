package expenseManager.results;

public class ExpenseManagerResults implements ResultsI, ResultPersisterI {
    private String expenseResults = "";
    private static ExpenseManagerResults expenseResultObj = new ExpenseManagerResults();

    private ExpenseManagerResults() {
    }

    public static ResultsI getExpenseResultInstance() {
        return expenseResultObj;
    }

    public static ResultPersisterI getExpenseResultPersisterInstance() {
        return expenseResultObj;
    }

    public void storeResults(String resultData) {
        expenseResults = expenseResults.concat(resultData + "\n");
    }

    public void storeResultToFile() {
        
    }
}