package expenseManager.util.fileprocess;

import java.io.IOException;

/**
 * FileProcessorI interface
 * 
 * @author Kenneth Fernandes
 */
public interface FileProcessorI {

    /**
     * Function that reads the file one line which returns the line back to the
     * caller function
     * 
     * @return Returns one line read from the file
     */
    public String readLine() throws IOException;


	/**
	 * This is a function is for closing the file
	 * 
	 * @throws IOException
	 */
	public void closeFile() throws IOException;

}