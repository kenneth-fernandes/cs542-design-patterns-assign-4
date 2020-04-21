package expenseManager.util.constants;

public enum ValidationConditionConstants {
    /**
     * Regular expression for number validation
     */
    NUMBER_REG_EXP("[0-9]+"),
    /**
     * Regular expression for Input file data format
     */
    INPUT_ITEM_FORMAT_REG_EXP("^[a-z]+:[a-zA-Z0-9\\W]+"),
    /**
     * Regular expression for Input file money data format
     */
    INPUT_MONEY_FORMAT_REG_EXP("^[a-z]+:[0-9]+"),
    /**
     * Regular expression for Available item file data format
     */
    AVAILABLE_ITEM_FORMAT_REG_EXP("^[a-z]+[a-zA-Z]*:[a-zA-Z0-9\\W]+");

    // Stores the constant string for a particular constant variable
    private final String constStrVal;

    /**
     * Creating enums based on enum name and storing a validation constants
     * 
     * @param constStrVal - Validation constant string
     */
    ValidationConditionConstants(String constStrVal) {
        this.constStrVal = constStrVal;
    }

    /**
     * Returns the validation constants associated with an enum  
     * 
     * @return - Validation constant string
     */
    public String getConstantValue() {
        return this.constStrVal;
    }
}