package expenseManager.driver;

import java.io.IOException;

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
import expenseManager.util.validator.ValidatorFetcher;
import expenseManager.util.validator.ValidatorFetcherI;
import expenseManager.util.validator.ValidatorUtil;
import expenseManager.util.validator.ValidatorUtilI;
import expenseManager.util.validator.expception.FileNotProcessedException;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;
import expenseManager.util.validator.expception.InvalidInputParamsException;

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

				ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();

				ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

				validatrUtilObj.validateInputParams("User-Input Error",
						validatrFetchrObj.inputFilePathValidatn(args[0]),
						validatrFetchrObj.availItmFilePathValidatn(args[1]),
						validatrFetchrObj.runAvgWinSizeValidatn(args[2]),
						validatrFetchrObj.outputFilePathValidatn(args[3]));

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

		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileNotProcessedException | InvalidInputParamsException | InvalidInputFileFormatException
				| InvalidAvailItemFileFormatException e) {
			System.err.printf(e.getMessage());
		}

	}
}
