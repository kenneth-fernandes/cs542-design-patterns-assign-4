package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

import expenseManager.util.persister.DataPersisterToFile;
import expenseManager.util.persister.DataPersisterToFileI;

public class ExpenseMngrResults implements ExpenseResultsI, ExpenseResultPersisterI {
    private String expenseResults = "";
    private static ExpenseMngrResults expenseMngrResultObj = new ExpenseMngrResults();
    private DataPersisterToFileI dataPersisterObj;

    private ExpenseMngrResults() {
    }

    /**
     * 
     * @return
     */
    public static ExpenseResultsI getExpnseResInstance() {
        return expenseMngrResultObj;
    }

    /**
     * 
     * @return
     */
    public static ExpenseResultPersisterI getExpnseResPersistrInstance() {
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