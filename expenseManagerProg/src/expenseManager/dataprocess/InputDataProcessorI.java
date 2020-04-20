package expenseManager.dataprocess;

import java.io.IOException;

import expenseManager.state.SpendingStateI;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;

public interface InputDataProcessorI {
    /**
     * 
     * @param fileProcessorObj
     * @param context
     * @throws InvalidInputFileFormatException
     * @throws IOException
     */
    public void processData(FileProcessorI fileProcessorObj, SpendingStateI context)
            throws InvalidInputFileFormatException, IOException;

}