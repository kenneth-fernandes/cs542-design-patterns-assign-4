package expenseManager.results;

import java.io.FileNotFoundException;
import java.io.IOException;

import expenseManager.util.constants.UtilConstants;
import expenseManager.util.persister.DataPersisterToFile;
import expenseManager.util.persister.DataPersisterToFileI;

public class ExpenseMngrResults implements ExpenseResultsI, ExpenseResultPersisterI {
    // Stores the final result that has to persisted to the output file
    private String expenseResults = "";
    // Stores the ExpenseMngrResults instance
    private static ExpenseMngrResults expenseMngrResultObj = new ExpenseMngrResults();
    // Stores the interface DataPersisterToFileI for DataPersisterToFile instance
    private DataPersisterToFileI dataPersisterObj;

    /**
     * Private ExpenseMngrResultsclass empty constructor
     */
    private ExpenseMngrResults() {
    }

    /**
     * Returns the ExpenseResultsI interface for ExpenseMngrResults single instance
     * 
     * @return - ExpenseResultsI interface for ExpenseMngrResults single instance
     */
    public static ExpenseResultsI getExpnseResInstance() {
        return expenseMngrResultObj;
    }

    /**
     * Returns the ExpenseResultPersisterI interface for ExpenseMngrResults single
     * instance
     * 
     * @return - ExpenseResultPersisterI interface for ExpenseMngrResults single
     *         instance
     */
    public static ExpenseResultPersisterI getExpnseResPersistrInstance() {
        return expenseMngrResultObj;
    }

    /**
     * Stores the result to data-structure
     * 
     * @param resultData - Result data
     */
    @Override
    public void storeResults(String resultData) {
        expenseResults = expenseResults.concat(resultData + UtilConstants.NEW_LINE_CHAR.getConstantValue());
    }

    /**
     * Store the result captured in the data-structure to the output file
     * 
     * @param filePath - Output file path
     * @throws FileNotFoundException - Exception caused while Input/Output thrown by
     *                               the function
     *
     * @throws IOException           - Exception caused while Input/Output thrown by
     *                               the function
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
        return "Class: ExpenseManagerResults, Data members [ expenseResults: " + expenseResults
                + ", expenseMngrResultObj: " + expenseMngrResultObj.toString() + ", dataPersisterObj:"
                + dataPersisterObj.toString() + "]";
    }
}