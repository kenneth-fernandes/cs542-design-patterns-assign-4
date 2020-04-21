package expenseManager.util.constants;

public enum UtilConstants {
    /**
     * Double colon character constant
     */
    DOUBLE_COLON("::"),
    /**
     * Double hyphen character constant
     */
    DOUBLE_HYPHEN("--"),
    /**
     * Colon character constant
     */
    COLON_CHAR(":"),
    /**
     * Single space constants
     */
    SINGLE_SPACE(" "),
    /**
     * New line character constant
     */
    NEW_LINE_CHAR("\n"),
    /**
     * Money string constant
     */
    MONEY("money"),
    /**
     * Item string constant
     */
    ITEM("item"),
    /**
     * Basic state string constant
     */
    BASIC_STATE("BASIC"),
    /**
     * Luxurious state constant
     */
    LUXURIOUS_STATE("LUXURIOUS"),
    /**
     * Extravagant State constant
     */
    EXTRAVAGANT_STATE("EXTRAVAGANT"),
    /**
     * Yes string constant
     */
    YES("YES"),
    /**
     * No string constant
     */
    NO("NO");

    // Stores the constant string for a particular constant variable
    private final String constStrVal;

    /**
     * Creating enums based on enum name and storing a util constants
     * 
     * @param constStrVal - Util constant string
     */
    UtilConstants(String constStrVal) {
        this.constStrVal = constStrVal;
    }

    /**
     * Returns the Util constants associated with an enum
     * 
     * @return - Util constant string
     */
    public String getConstantValue() {
        return this.constStrVal;
    }
}