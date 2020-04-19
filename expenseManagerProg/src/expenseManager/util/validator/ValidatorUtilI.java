package expenseManager.util.validator;

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
    public void validate(String baseErrMsg, ValidatorI... validators) throws Exception;

}