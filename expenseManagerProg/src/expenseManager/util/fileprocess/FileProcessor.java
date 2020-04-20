package expenseManager.util.fileprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	private BufferedReader br;
	//
	ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
	//
	ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();
	//
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
			validatrUtilObj.validateFileProcessor("Input-file Error",
					validatrFetchrObj.inputFileEmptyValidatn(file = new File(filePath)));
			br = new BufferedReader(new FileReader(file));
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
		return ((line = br.readLine()) != null) ? line.trim() : line;
	}

	/**
	 * This is a function is for closing the file
	 * 
	 * @throws IOException - Exception caused while Input/Output thrown by the
	 *                     function
	 */
	public void closeFile() throws IOException {
		try {
			if (br != null)
				br.close();
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return "FileProcessor [bufferedReader=" + br + "]";
	}
}
