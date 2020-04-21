package expenseManager.util.fileprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import expenseManager.util.constants.ExceptionConstants;
import expenseManager.util.validator.ValidatorFetcher;
import expenseManager.util.validator.ValidatorFetcherI;
import expenseManager.util.validator.ValidatorUtil;
import expenseManager.util.validator.ValidatorUtilI;
import expenseManager.util.validator.expception.FileNotProcessedException;

/**
 * FileProcessor class - Implements FileProcessorI interface functions that
 * performs file related operations.
 * 
 * @author Kenneth Peter Fernandes
 */
public class FileProcessor implements FileProcessorI {

	// The BufferedReader for reading data from the file
	private BufferedReader bufferedReader;
	// Stores the interface of ValidatorUtilI for ValidatorUtil instance
	ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
	// Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
	ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();
	// Stores the File instance
	private File file;

	/**
	 * The FileProcessor constructor that initializes Buffered Reader with filepath
	 * 
	 * @param filePath - Path of the file to be read
	 * @throws ExceptionException - caused while Input/Output thrown by the function
	 */
	/**
	 * The FileProcessor constructor that initializes Buffered Reader with filepath
	 * 
	 * @param filePath - Path of the file to be read
	 * @throws FileNotProcessedException - User defined exception thrown by
	 *                                   validator for file processing error
	 * @throws FileNotFoundException     - Exception caused while Input/Output
	 *                                   thrown by the function
	 */
	public FileProcessor(String filePath) throws FileNotProcessedException, FileNotFoundException {
		try {
			validatrUtilObj.validateFileProcessor(ExceptionConstants.INPUT_FILE_ERROR_MSG.getErrorMsg(),
					validatrFetchrObj.inputFileEmptyValidatn(file = new File(filePath)));
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw e;
		}
	}

	/**
	 * Function that reads the file one line which returns the line back to the
	 * caller function
	 * 
	 * @return Returns one line read from the file
	 */
	public String readLine() throws IOException {
		String line = null;
		return ((line = bufferedReader.readLine()) != null) ? line.trim() : line;
	}

	/**
	 * This is a function is for closing the file
	 * 
	 * @throws IOException - Exception caused while Input/Output thrown by the
	 *                     function
	 */
	public void closeFile() throws IOException {
		try {
			if (bufferedReader != null)
				bufferedReader.close();
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return "Class: ExpenseManagerInput, Data Members: [bufferedReader:" + bufferedReader + ", validatrUtilObj: "
				+ validatrUtilObj.toString() + ", validatrFetchrObj: " + validatrFetchrObj.toString() + ", file: "
				+ file.getAbsolutePath() + "]";
	}
}
