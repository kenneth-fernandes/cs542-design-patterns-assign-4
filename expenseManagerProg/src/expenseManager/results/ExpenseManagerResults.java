package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

import expenseManager.util.persister.DataPersisterToFile;
import expenseManager.util.persister.DataPersisterToFileI;

public class ExpenseManagerResults implements ResultsI, ResultPersisterI {
    private String expenseResults = "";
    private static ExpenseManagerResults expenseMngrResultObj = new ExpenseManagerResults();
    private DataPersisterToFileI dataPersisterObj;

    private ExpenseManagerResults() {
    }

    /**
     * 
     * @return
     */
    public static ResultsI getExpenseResultInstance() {
        return expenseMngrResultObj;
    }

    /**
     * 
     * @return
     */
    public static ResultPersisterI getExpenseResultPersisterInstance() {
        return expenseMngrResultObj;
    }

    /**
     * 
     */
    @Override
    public void storeResults(String resultData) {
        expenseResults = expenseResults.concat(resultData + "\n");
    }

    /**
     * @throws IOException
     * @throws FileNotFoundException
     * 
     */
    @Override
    public void storeResultToFile(String filePath) throws FileNotFoundException, IOException {
        dataPersisterObj = new DataPersisterToFile(filePath);
        dataPersisterObj.writeLine(expenseResults);
        dataPersisterObj.closeFile();
    }

    @Override
    public String toString() {
        return "Class - ExpenseManagerResults | Data members []";
    }
}