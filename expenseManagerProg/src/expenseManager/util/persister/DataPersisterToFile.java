package expenseManager.util.persister;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataPersisterToFile implements DataPersisterToFileI {

    // Stores the BufferedWriter instance
    private BufferedWriter buffrdWriter;

    // Stores the File instance
    private File file;

    // Stores the FileWriter instance
    private FileWriter fileWriter;

    /**
     * DataPersisterToFile constructor
     */
    public DataPersisterToFile(String filePath) throws FileNotFoundException, IOException {
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            buffrdWriter = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    /**
     * This function writes data to bufferedWrite
     * 
     * @param dataStr - The data of type String
     */
    public void writeLine(String dataStr) throws IOException {
        buffrdWriter.write(dataStr.trim());
    }

    /**
     * This function closes the file connection and flushes the buffrdWriter to the
     * file
     * 
     * @throws IOException
     */
    public void closeFile() throws IOException {
        try {
            buffrdWriter.flush();
            if (buffrdWriter != null)
                buffrdWriter.close();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "PersistToFile : (buffrdWriter=" + buffrdWriter + ", file = " + file + ", fileWriter ="
                + fileWriter + ")";
    }
}