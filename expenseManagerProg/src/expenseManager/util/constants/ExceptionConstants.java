package expenseManager.util.constants;

/**
 * ExceptionConstants enum - Stores the constants for Exceptions error messages
 * 
 * @author Kenneth Peter Fernandes
 * 
 */
public enum ExceptionConstants {
        /**
         * Input file path empty error message constant
         */
        INPUT_FILE_PATH_EMPTY_ERROR_MSG("File path parameter, for retrieving "
                        + "the money earned and items that can be purchased, is empty."),
        /**
         * Avialable item file path empty error message constant
         */
        AVAILABLE_ITEM_FILE_PATH_EMPTY_ERROR_MSG(
                        "File path parameter, for retrieving the data of list of available items "
                                        + "for purchasing, is empty."),
        /**
         * Window size empty error message constant
         */
        WINDOW_SIZE_PARAMETER_EMPTY_ERROR_MSG("Window size parameter, for calculating the running average, is empty."),
        /**
         * Window size negative value message constant
         */
        WINDOW_SIZE_PARAMETER_NEGATIVE_VALUE_ERROR_MSG("Window size parameter, for calculating the running average, "
                        + "entered is less than or equal to zero."),
        /**
         * Window size invalid integer format error message constant
         */
        WINDOW_SIZE_PARAMETER_INVALID_FORMAT_ERROR_MSG(
                        "Window size parameter, for calculating the running average entered, "
                                        + "is an invalid integer value."),
        /**
         * Output file path empty error message constant
         */
        OUTPUT_FILE_PATH_EMPTY_ERROR_MSG("File path parameter, for storing the final outcome mentioning the "
                        + "purchasable/ non-purchasable items along with the spending state, is empty."),
        /**
         * Input and Available items file empty error message constant
         */
        INPUT_AVAILABLE_ITEMS_FILE_CONTENTS_EMPTY_ERROR_MSG(
                        "The input file or the available items list file is empty."),
        /**
         * Input file empty data error message constant
         */
        INPUT_FILE_DATA_EMPTY_ERROR_MSG("The data read from the input file, having money and items that can "
                        + "be purchased, is blank or empty."),
        /**
         * Input file incorrect data format error message constant
         */
        INPUT_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG(
                        "The data read from the input file, having money and items that can be purchased, "
                                        + "is not in correct format."),
        /**
         * Input file negative money value error message constant
         */
        INPUT_FILE_MONEY_DATA_INCORRECT_FORMAT_ERROR_MSG(
                        "The data read from the input file, having money and items that "
                                        + "can be purchased, has money earned as less than or equal to zero."),
        /**
         * Input file incorrect integer format for money error message constant
         */
        INPUT_FILE_MONEY_INCORRECT_INTEGER_FORMAT_ERROR_MSG(
                        "The money data read from the input file, having money and items that "
                                        + "can be purchased, has a invalid integer value."),
        /**
         * Available item file empty error message constant
         */
        AVAILABLE_ITEM_FILE_DATA_EMPTY_ERROR_MSG("The data read from the available items file is blank or empty."),
        /**
         * Available item file incorrect data format error message constant
         */
        AVAILABLE_ITEM_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG(
                        "The data read from the available items file is not in correct format."),
        /**
         * Available item file numeric item name error message constant
         */
        AVAILABLE_ITEM_FILE_DATA_NUMERIC_ITEM_NAME_ERROR_MSG(
                        "The data read from the available items file has a numeric item name."),
        /**
         * Input file error message constant
         */
        INPUT_FILE_ERROR_MSG("Input-file Error"),
        /**
         * Available items data processing error message constant
         */
        AVAILABLE_ITEMS_DATA_PROCESSING_ERROR_MSG("Available Items data processing error"),
        /**
         * Input file data processing error message constant
         */
        INPUT_FILE_DATA_PROCESSING_ERROR_MSG("Input-file data processing error"),

        /**
         * User input error message constant
         */
        USER_INPUT_ERROR_MESSAGE("User-Input Error"),
        /**
         * Incorrect number of user input arguments error message constant
         */
        USER_INPUT_INCORRECT_NUMBER_OF_ARGS_ERROR_MSG(
                        "\nError: Incorrect number of arguments. Program accepts 4 argumnets.");

        // Stores the error messages as constants string data in the enums
        private final String errorMsg;

        /**
         * Creating enums based on enum name and storing an error message as constant
         * string data
         * 
         * @param errorMsg - Error message as string data
         */
        ExceptionConstants(String errorMsg) {
                this.errorMsg = errorMsg;
        }

        /**
         * Returns the error message associated with a constant enum
         * 
         * @return - Error message associated with a constant enum
         */
        public String getErrorMsg() {
                return this.errorMsg;
        }
}