package expenseManager.util.persister;

import java.io.IOException;

/**
 * DataPersisterToFileI
 */
public interface DataPersisterToFileI {
    /**
     * This function writes data to bufferedWrite
     * 
     * @param dataStr - The data of type String
     */
    public void writeLine(String dataStr) throws IOException;

    /**
     * This function closes the file connection and flushes the buffrdWriter to the
     * file
     * 
     * @throws IOException
     */
    public void closeFile() throws IOException;

}