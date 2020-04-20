package expenseManager.util.constants;

public enum ExceptionsConstants {
    INPUT_FILE_PATH_EMPTY_ERROR_MSG(
            "File path parameter, for retrieving the money earned and items that can be purchased, is empty."),
    AVAILABLE_ITEM_FILE_PATH_EMPTY_ERROR_MSG(
            "File path parameter, for retrieving the data of list of available items for purchasing, is empty."),
    WINDOW_SIZE_PARAMETER_EMPTY_ERROR_MSG("Window size parameter, for calculating the running average, is empty."),
    WINDOW_SIZE_PARAMETER_NEGATIVE_VALUE_ERROR_MSG(
            "Window size parameter, for calculating the running average, entered is less than or equal to zero."),
    WINDOW_SIZE_PARAMETER_INVALID_FORMAT_ERROR_MSG(
            "Window size parameter, for calculating the running average entered, is an invalid integer value.");

    //
    private final String errorMsg;

    /**
     * 
     * @param errorMsg
     */
    ExceptionsConstants(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}