package expenseManager.util.validator;

import expenseManager.util.validator.expception.FileNotProcessedException;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;
import expenseManager.util.validator.expception.InvalidInputParamsException;

/**
 * ValidatorUtilI interface - Contains the function signatures that perform
 * ValidatorI implemented functions
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ValidatorUtilI {
    /**
     * The function executes each ValidatorI's implemented functions
     * 
     * @param - Base error message
     * @param - Array of ValidatorI interfaces
     */
    public void validateInputParams(String baseErrMsg, ValidatorI... validators) throws InvalidInputParamsException;

    /**
     * The function executes each ValidatorI's implemented functions
     * 
     * @param - Base error message
     * @param - Array of ValidatorI interfaces
     */
    public void validateFileProcessor(String baseErrMsg, ValidatorI... validators) throws FileNotProcessedException;

    /**
     * 
     * @param baseErrMsg
     * @param validators
     * @throws InvalidAvailItemFileFormatException
     */
    public void validateAvailItemFileData(String baseErrMsg, ValidatorI... validators)
            throws InvalidAvailItemFileFormatException;

    /**
     * 
     * @param baseErrMsg
     * @param validators
     * @throws InvalidInputFileFormatException
     */
    public void validateInputFileData(String baseErrMsg, ValidatorI... validators)
            throws InvalidInputFileFormatException;

}