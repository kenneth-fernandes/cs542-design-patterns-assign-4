package expenseManager.util.constants;

/**
 * ItemCostTypeConstants enum - Stores the constants for item cost type
 */
public enum ItemCostTypeConstants {
    /**
     * Basic item string constant
     */
    BASIC_ITEM("basic"),
    /**
     * Moderately expensive item string constant
     */
    MODERATERATLY_EXPENSIVE_ITEM("moderatelyExpensive"),
    /**
     * Super expensive item string constant
     */
    SUPER_EXPENSIVE_ITEM("superExpensive");

    // Stores the constant string for a particular constant variable
    private final String constStrVal;

    /**
     * Creating enums based on enum name and storing a item type name as constant
     * string data
     * 
     * @param constStrVal - item type name as string data
     */
    ItemCostTypeConstants(String constStrVal) {
        this.constStrVal = constStrVal;
    }

    /**
     * Returns the item type name as string data
     * 
     * @return - Item type name as string data
     * 
     */
    public String getConstantValue() {
        return this.constStrVal;
    }
}