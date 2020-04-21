package expenseManager.util.input;

/**
 * ExpenseManagerInput class - Implements the methods of InputParametersI
 * interface used for storing and retrieving command line arguments passed to
 * the application
 * 
 * @author Kenneth Peter Fernandes
 */
public class ExpenseManagerInput implements InputParametersI {
    // Stores the InputParametersI interface for ExpenseManagerInput instance
    private static InputParametersI expenseInputParamObj = new ExpenseManagerInput();
    // Stores the input text file path where the money earned and item to be
    // purchased is listed
    private String inputFilePath;
    // Stores the available items text file path where the list of items are present
    // with the type of the cost category
    private String availableItemsFilePath;
    // Stores the window size used for running average calculation
    private int runAvgWinSize;
    // Stores the output text file path where the outcome is stored
    private String outputFilePath;

    /**
     * Intializing the flags to false which are used to check if the input
     * parameters are set or not in order to avoid overriting
     */
    private boolean isInputFilePathSet = false;
    private boolean isAvailItemsFilePathSet = false;
    private boolean isRunAvgWinSizeSet = false;
    private boolean isOutputFilePathSet = false;

    /**
     * Private ExpenseManagerInput class empty constructor
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
        if (!isInputFilePathSet) {
            inputFilePath = path;
            isInputFilePathSet = true;
        }
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
        if (!isAvailItemsFilePathSet) {
            availableItemsFilePath = path;
            isAvailItemsFilePathSet = true;
        }
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
        if (!isRunAvgWinSizeSet) {
            runAvgWinSize = Integer.parseInt(runAvgWinSizeStr);
            isRunAvgWinSizeSet = true;
        }
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
        if (!isOutputFilePathSet) {
            outputFilePath = path;
            isOutputFilePathSet = true;
        }
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

    @Override
    public String toString() {
        return "Class:FileProcessor, Data Members: [expenseInputParamObj:" + expenseInputParamObj.toString()
                + ", inputFilePath: " + inputFilePath + ", availableItemsFilePath: " + availableItemsFilePath
                + ", runAvgWinSize: " + runAvgWinSize + ", outputFilePath: " + outputFilePath + ", isInputFilePathSet:"
                + isInputFilePathSet + ", isAvailItemsFilePathSet: " + isAvailItemsFilePathSet
                + ", isRunAvgWinSizeSet: " + isRunAvgWinSizeSet + ", isOutputFilePathSet: " + isOutputFilePathSet + "]";
    }

}