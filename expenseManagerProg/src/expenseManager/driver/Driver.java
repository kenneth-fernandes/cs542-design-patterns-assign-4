package expenseManager.driver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import expenseManager.items.AvailableItems;
import expenseManager.util.fileprocess.FileProcessor;
import expenseManager.util.fileprocess.FileProcessorI;
import expenseManager.util.input.ExpenseManagerInput;
import expenseManager.util.input.InputParametersI;

/**
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
		HashMap<String, List<String>> hMap = AvailableItems.getInstance().getData();
		Iterator hmIterator = hMap.entrySet().iterator();
		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) hmIterator.next();
			System.out.println(mapElement.getKey() + " - " + mapElement.getValue());
		}
		/*HashMap<String, List<String>> hMap = AvailableItems.getInstance().getData();
		while (hMap.entrySet().iterator().hasNext()) {
			Map.Entry mapElement = (Map.Entry) hMap.entrySet().iterator().next();
			System.out.println(mapElement.getKey() + " - " + mapElement.getValue());
		}*/
		/*
		 * String str; System.out.println(); str = ""; FileProcessorI
		 * inputFileProcessObj = new FileProcessor(inputParamsObj.getInputFilePath());
		 * while ((str = inputFileProcessObj.readLine()) != null) {
		 * System.out.println(str);
		 * 
		 * }
		 */
	}
}
