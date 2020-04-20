package expenseManager.dataprocess;

import java.io.IOException;

import expenseManager.state.SpendingStateI;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;

/**
 * InputDataProcessorI interface - Contains function to process input file data
 * 
 * @author Kenneth Peter Fernandes
 */
public interface InputDataProcessorI {
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
            throws InvalidInputFileFormatException, IOException;

}