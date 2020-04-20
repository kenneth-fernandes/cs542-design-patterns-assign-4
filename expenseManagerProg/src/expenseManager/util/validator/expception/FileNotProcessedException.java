package expenseManager.util.validator.expception;

public class FileNotProcessedException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param s
     */
    public FileNotProcessedException(String s) {
        super(s);
    }
}

