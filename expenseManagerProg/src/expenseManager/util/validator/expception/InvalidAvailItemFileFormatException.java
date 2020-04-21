package expenseManager.util.validator.expception;

/**
 * InvalidAvailItemFileFormatException class
 * 
 * @author Kenneth Peter Fernandes
 */
public class InvalidAvailItemFileFormatException extends Exception{
    /**
     * Serial number constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * InvalidAvailItemFileFormatException constructor calling the parent class
     * object
     * 
     * @param s - The error message
     */
    public InvalidAvailItemFileFormatException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Class: InvalidAvailItemFileFormatException, Data Members: [ ]";
    }
}