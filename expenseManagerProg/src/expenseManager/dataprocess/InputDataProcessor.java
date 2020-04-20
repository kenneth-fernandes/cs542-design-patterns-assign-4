package expenseManager.dataprocess;

import java.io.IOException;

import expenseManager.state.SpendingStateI;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.validator.ValidatorFetcher;
import expenseManager.util.validator.ValidatorFetcherI;
import expenseManager.util.validator.ValidatorUtil;
import expenseManager.util.validator.ValidatorUtilI;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;

public class InputDataProcessor implements InputDataProcessorI {
    //
    private String lineData;
    //
    private static InputDataProcessorI inputDataPrcsrObj = new InputDataProcessor();
    //
    ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
    //
    ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

    /**
     * 
     */
    private InputDataProcessor() {
    }

    /**
     * 
     * @return
     */
    public static InputDataProcessorI getInstance() {
        return inputDataPrcsrObj;
    }

    /**
     * @throws InvalidInputFileFormatException
     * @throws IOException
     * 
     */
    public void processData(FileProcessorI fileProcessorObj, SpendingStateI context)
            throws InvalidInputFileFormatException, IOException {
        try {
            while ((lineData = fileProcessorObj.readLine()) != null) {
                validatrUtilObj.validateInputFileData("Input-file data processing error",
                        validatrFetchrObj.inputFileFormatValidn(lineData));
                String[] keyValPairArr = lineData.split(":");
                if (isItemData(keyValPairArr[0]))
                    context.processItemPuchasability(keyValPairArr[1]);

                if (isMoneyData(keyValPairArr[0]))
                    context.creditMoney(Integer.parseInt(keyValPairArr[1]));
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
     * 
     * @param data
     * @return
     */
    private boolean isItemData(String data) {
        return data.toLowerCase().trim().equals("item");
    }

    /**
     * 
     * @param data
     * @return
     */
    private boolean isMoneyData(String data) {
        return data.toLowerCase().trim().equals("money");
    }

}