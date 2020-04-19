package expenseManager.driver;

import expenseManager.context.ExpenseMngrContext;
import expenseManager.items.AvailableItems;
import expenseManager.items.AvailableItemsI;
import expenseManager.results.ExpenseMngrResults;
import expenseManager.results.ExpenseResultPersisterI;
import expenseManager.state.SpendingStateI;
import expenseManager.dataprocess.InputDataProcessorI;
import expenseManager.dataprocess.InputDataProcessor;
import expenseManager.util.fileprocess.FileProcessor;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.input.ExpenseManagerInput;
import expenseManager.util.input.InputParametersI;

/**
 * Driver class - The entry point of the program
 * 
 * @author Kenneth Peter Fernandes
 */
public class Driver {
	public static void main(String[] args) {
		try {

			InputParametersI inputParamsObj = ExpenseManagerInput.getInstance();
			/*
			 * As the build.xml specifies the arguments as argX, in case the argument value
			 * is not given java takes the default value specified in build.xml. To avoid
			 * that, below condition is used
			 */
			final int REQUIRED_NUMBER_OF_ARGS = 4;
			if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputFile}"))
					|| (args[1].equals("${availableItemsFile}")) || (args[2].equals("${runAvgWinSize}"))
					|| (args[3].equals("${outputFile}"))) {

				System.err.printf("\nError: Incorrect number of arguments. Program accepts 4 argumnets.");

				System.exit(0);
			} else {

				inputParamsObj.setInputFilePath(args[0]);
				inputParamsObj.setAvailableItemsFilePath(args[1]);
				inputParamsObj.setRunAvgWinSize(args[2]);
				inputParamsObj.setOutputFilePath(args[3]);
			}

			// Retriving the single instance of AvailableItems object
			AvailableItemsI availItemsObj = AvailableItems.getInstance();

			// Creating the FileProcessor object for Input file procession
			FileProcessorI availItmsFileProcessObj = new FileProcessor(inputParamsObj.getAvailableItemsFilePath());

			// Processing of available items data from the file and storing it in a
			// data-structure
			availItemsObj.storeFileData(availItmsFileProcessObj);

			// Creating an object of ExpenseManagerContext for managing the expenses based
			// on the input
			SpendingStateI expnseMngrCntxt = new ExpenseMngrContext(inputParamsObj.getRunAvgWinSize());

			// Creating the FileProcessor object for Input file procession
			FileProcessorI inputFileProcessObj = new FileProcessor(inputParamsObj.getInputFilePath());

			// Creating the object to process input data
			InputDataProcessorI inputDataPrcsrObj = InputDataProcessor.getInstance();

			// Passing the filprocessor object for input file and ExpenseManagerContext for
			// further processing
			inputDataPrcsrObj.processData(inputFileProcessObj, expnseMngrCntxt);


			// Retrieving the single instance of ExpenseMngrResults object.
			ExpenseResultPersisterI expenseMngrResObj = ExpenseMngrResults.getExpnseResPersistrInstance();
			// Storing the results to the file
			expenseMngrResObj.storeResultToFile(inputParamsObj.getOutputFilePath());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
