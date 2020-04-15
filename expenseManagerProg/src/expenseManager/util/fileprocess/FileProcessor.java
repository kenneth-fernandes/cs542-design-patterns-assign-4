package expenseManager.util.fileprocess;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The class FileProcessor performs file related operations.
 * 
 * @author Kenneth Fernandes
 */
public class FileProcessor implements FileProcessorI {

	// The BufferedReader for reading data from the file
	private BufferedReader br;

	/**
	 * The FileProcessor constructor that initializes Buffered Reader with filepath
	 * 
	 * @param filePath - Path of the file to be read
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public FileProcessor(String filePath) throws FileNotFoundException, IOException {
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			throw e;
		}
	}

	/**
	 * Function that reads the file one line which returns the line
	 * back to the caller function
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
	 * @throws IOException
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
