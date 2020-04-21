package expenseManager.util.validator.expception;

/**
 * FileNotProcessedException class
 * 
 * @author Kenneth Peter Fernandes
 */
public class FileNotProcessedException extends Exception {

    /**
     * Serial number constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * FileNotProcessedException constructor calling the parent class object
     * 
     * @param s - The error message
     */
    public FileNotProcessedException(String s) {
        super(s);
    }
}

