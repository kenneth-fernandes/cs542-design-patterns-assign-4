package expenseManager.driver;

import expenseManager.context.ExpenseManagerContext;
import expenseManager.items.AvailableItems;
import expenseManager.results.ExpenseManagerResults;
import expenseManager.state.SpendingStateI;
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
	public static void main(String[] args) throws Exception {

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
		AvailableItems.getInstance().processData(new FileProcessor(inputParamsObj.getAvailableItemsFilePath()));
		SpendingStateI context = new ExpenseManagerContext();
		String dataStr;
		System.out.println();
		dataStr = "";
		FileProcessorI inputFileProcessObj = new FileProcessor(inputParamsObj.getInputFilePath());
		while ((dataStr = inputFileProcessObj.readLine()) != null) {
			String[] strArr = dataStr.split(":");
			if (strArr[0].equals("item")) {
				context.processItem(strArr[1]);

			} else {
				context.creditMoney(Integer.parseInt(strArr[1]));
			}
		}
		ExpenseManagerResults.getExpenseResultPersisterInstance().storeResultToFile(inputParamsObj.getOutputFilePath());

	}
}
