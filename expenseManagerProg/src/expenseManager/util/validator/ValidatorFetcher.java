package expenseManager.util.validator;

import java.io.File;

/**
 * ValidatorFetcher class - Implements the ValidatorFetcherI interface functions
 * for performing validations
 * 
 * @author - Kenneth Peter Fernandes
 */
public class ValidatorFetcher implements ValidatorFetcherI {
    // The variable hold the interface of ValidatorFetcher instance
    private static ValidatorFetcherI validatrFetchrObj = new ValidatorFetcher();

    /**
     * The function returns the interface of ValidatorFetcher object's single
     * instance
     * 
     * @return - Interface of ValidatorFetcher object
     * 
     */
    public static ValidatorFetcherI getInstance() {
        return validatrFetchrObj;
    }

    /**
     * Private ValidatorFetcher empty constructor
     */
    private ValidatorFetcher() {
    }

    /**
     * The implementation of the function performs validation of input filepath
     * parameter
     * 
     * @param input - The input parameter entered for input file-path
     * @return - The implemented interface ValidatorI performing the input filepath
     *         parameter validation
     */
    public ValidatorI inputFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception("File path parameter, for retrieving the money earned and "
                            + "items that can be purchased, is empty");
                }
            }
        };
    }

    /**
     * The implementation of the function performs validation of available items
     * filepath parameter
     * 
     * @param input - The input parameter entered for available items file-path
     * @return - The implemented interface ValidatorI performing the available items
     *         filepath parameter validation
     */
    public ValidatorI availItmFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception("File path parameter, for retrieving the data of list of available items for"
                            + " purchasing, is empty");
                }
            }
        };
    }

    /**
     * The implementation of the function performs validation of window size
     * parameter used for running average calculation
     * 
     * @param input - The input parameter entered for window size
     * @return - The implemented interface ValidatorI performing validation of
     *         window size parameter
     */
    public ValidatorI runAvgWinSizeValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception("Window size parameter, for calculating the running average, is empty.");
                } else {
                    try {
                        int value = Integer.parseInt(input);
                        if (value <= 0) {
                            throw new Exception(
                                    "Window size parameter, for calculating the running average, entered is less than or equal to zero.");
                        }
                    } catch (NumberFormatException e) {
                        throw new Exception(
                                "Window size parameter, for calculating the running average entered, is an invalid integer value.");
                    }

                }
            }
        };
    }

    /**
     * The implementation of the function performs validation of output filepath parameter
     * 
     * @param input - The input parameter entered for output file-path
     * @return - The implemented interface ValidatorI performing the output filepath
     *         parameter validation
     */
    public ValidatorI outputFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception("File path parameter, for storing the final outcome mentioning the "
                            + "purchasable/ non-purchasable items along with the spending state, is empty");
                }
            }
        };
    }

    /**
     * The implementation of the
     * 
     * @param input -
     * @return -
     */
    public ValidatorI inputFileValidatn(File file) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (file.length() == 0) {
                    throw new Exception("The input file or the available items list file is empty");
                }
            }
        };
    }

}