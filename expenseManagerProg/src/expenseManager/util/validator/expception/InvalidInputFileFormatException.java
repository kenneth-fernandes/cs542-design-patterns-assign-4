package expenseManager.util.validator.expception;

/**
 * InvalidInputFileFormatException class
 * 
 * @author Kenneth Peter Fernandes
 */
public class InvalidInputFileFormatException extends Exception {
    /**
     * Serial number constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * InvalidInputFileFormatException constructor calling the parent class object
     * 
     * @param s - The error message
     */
    public InvalidInputFileFormatException(String s) {
        super(s);
    }
}