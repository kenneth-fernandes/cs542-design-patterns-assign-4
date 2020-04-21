package expenseManager.dataprocess;

import java.io.IOException;

import expenseManager.state.SpendingStateI;
import expenseManager.util.constants.ExceptionConstants;
import expenseManager.util.constants.UtilConstants;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.ValidatorFetcher;
import expenseManager.util.validator.ValidatorFetcherI;
import expenseManager.util.validator.ValidatorUtil;
import expenseManager.util.validator.ValidatorUtilI;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;

/**
 * InputDataProcessor class - Implements the InputDataProcessorI interface
 * functions to process input file data
 * 
 * @author Kenneth Peter Fernandes
 */
public class InputDataProcessor implements InputDataProcessorI {
    // Stores the line data read from the file
    private String lineData;
    // Stores the interface of InputDataProcessorI for InputDataProcessor instance
    private static InputDataProcessorI inputDataPrcsrObj = new InputDataProcessor();
    // Stores the interface of ValidatorUtilI for ValidatorUtil instance
    ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
    // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
    ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

    /**
     * Private InputDataProcessor class empty constructor
     */
    private InputDataProcessor() {
    }

    /**
     * Returns the InputDataProcessorI interface for InputDataProcessor instance
     * 
     * @return - InputDataProcessorI interface for InputDataProcessor instance
     */
    public static InputDataProcessorI getInstance() {
        return inputDataPrcsrObj;
    }

    /**
     * Performs data processing of each line of data of the input file and credits
     * money and process item to check if it can be purchased based on the spending
     * state
     * 
     * @param fileProcessorObj - FileProcessorI interface for FileProcessor instance
     *                         of input file
     * @param context          - SpendingStateI interface for SpendingStateContext
     *                         instance
     * @throws InvalidInputFileFormatException - User defined exception thrown by
     *                                         validator for incorrect file data
     *                                         format
     * @throws IOException                     - Exception caused while Input/Output
     *                                         thrown by the function
     */
    public void processData(FileProcessorI fileProcessorObj, SpendingStateI context)
            throws InvalidInputFileFormatException, IOException {
        try {
            while ((lineData = fileProcessorObj.readLine()) != null) {
                validatrUtilObj.validateInputFileData(
                        ExceptionConstants.INPUT_FILE_DATA_PROCESSING_ERROR_MSG.getErrorMsg(),
                        validatrFetchrObj.inputFileFormatValidn(lineData));
                String[] keyValPairArr = lineData.split(UtilConstants.COLON_CHAR.getConstantValue());
                if (isItemData(keyValPairArr[0].trim()))
                    context.processItemPuchasability(keyValPairArr[1].trim());

                if (isMoneyData(keyValPairArr[0].trim()))
                    context.creditMoney(Integer.parseInt(keyValPairArr[1].trim()));
            }
            fileProcessorObj.closeFile();
        } catch (IOException e) {
            try {
                fileProcessorObj.closeFile();
            } catch (IOException e1) {
                throw e1;
            }
            throw e;
        }
    }

    /**
     * Checks if the data read from the file is of type item
     * 
     * @param data - Line data read from the input file
     * @return - True or False - if the data read from the file is of type item
     */
    private boolean isItemData(String data) {
        return data.toLowerCase().trim().equals("item");
    }

    /**
     * Checks if the data read from the file is of type money
     * 
     * @param data - Line data read from the input file
     * @return - True or False - if the data read from the file is of type money
     */
    private boolean isMoneyData(String data) {
        return data.toLowerCase().trim().equals("money");
    }

    @Override
    public String toString() {
        return "Class: InputDataProcessor, Data Members: [lineData: " + lineData + ", inputDataPrcsrObj: "
                + inputDataPrcsrObj.toString() + ", validatrUtilObj: " + validatrUtilObj.toString()
                + ", validatrFetchrObj: " + validatrFetchrObj.toString() + "]";
    }

}