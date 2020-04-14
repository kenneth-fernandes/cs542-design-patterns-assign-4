package expenseManager.util.input;

public class ExpenseManagerInput implements InputParametersI {

    private static InputParametersI expenseInputParamObj = new ExpenseManagerInput();
    private String inputFilePath;
    private String availableItemsFilePath;
    private int runAvgWinSize;
    private String outputFilePath;

    /**
     * ExpenseManagerInput class private constructor
     */
    private ExpenseManagerInput() {
    }

    /**
     * Function that returns the single instance of ExpenseManagerInput object
     * 
     * @return - Returns the ExpenseManagerInput object
     */
    public static InputParametersI getInstance() {
        return expenseInputParamObj;
    }

    /**
     * Function to store the Input file path
     * 
     * @param path - Command-line argument for File path
     */
    @Override
    public void setInputFilePath(String path) {
        inputFilePath = path;
    }

    /**
     * Function to retrieve the Input file path
     * 
     * @return - Input file path
     */
    @Override
    public String getInputFilePath() {

        return inputFilePath;
    }

    /**
     * Function to store the Available Items file path
     * 
     * @param path - Command-line argument for File path
     */
    @Override
    public void setAvailableItemsFilePath(String path) {
        availableItemsFilePath = path;
    }

    /**
     * Function to retrieve the Available Items file path
     * 
     * @return - Available Items file path
     * 
     */
    @Override
    public String getAvailableItemsFilePath() {

        return availableItemsFilePath;
    }

    /**
     * Function to store the running average window to be used
     * 
     * @param runAvgWinSizeStr - Command-line argument for running average window
     *                         size
     */
    @Override
    public void setRunAvgWinSize(String runAvgWinSizeStr) {
        runAvgWinSize = Integer.parseInt(runAvgWinSizeStr);
    }

    /**
     * Function to retrieve the runnning average window
     * 
     * @return - Running average window size
     */
    @Override
    public int getRunAvgWinSize() {

        return runAvgWinSize;
    }

    /**
     * Function to store the Output file path
     * 
     * @param path - Command-line argument for File path
     */
    @Override
    public void setOutputFilePath(String path) {
        outputFilePath = path;
    }

    /**
     * Function to retrieve the Output file path
     * 
     * @return - Output file path
     */
    @Override
    public String getOutputFilePath() {

        return outputFilePath;
    }

}