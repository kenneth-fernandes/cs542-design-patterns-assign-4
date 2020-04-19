package expenseManager.util.validator;

/**
 * ValidatorUtil class - Implements the functions in ValidatorUtilI that
 * executes the list of various validators
 * 
 * @author - Kenneth Peter Fernandes
 */
public final class ValidatorUtil implements ValidatorUtilI {

    // The variable hold the interface of ValidatorUtil instance
    private static ValidatorUtilI validatorUtilObj = new ValidatorUtil();

    /**
     * Private ValidatorUtil empty constructor
     */
    private ValidatorUtil() {
    }

    /**
     * The function returns the interface of ValidatorUtil object's single instance
     * 
     * @return - Interface of ValidatorUtil object
     */
    public static ValidatorUtilI getInstance() {
        return validatorUtilObj;
    }

    /**
     * The function executes each ValidatorI's implemented functions
     * 
     * @param - Base error message
     * @param - Array of ValidatorI interfaces
     */
    public void validate(String baseErrMsg, ValidatorI... validators) throws Exception {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
            }
        }

    }
}