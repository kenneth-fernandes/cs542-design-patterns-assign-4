package expenseManager.dataprocess;

import java.io.IOException;

import expenseManager.state.SpendingStateI;
import expenseManager.util.fileprocess.FileProcessorI;

public class InputDataProcessor implements InputDataProcessorI {

    private String lineData;
    private static InputDataProcessorI inputDataPrcsrObj = new InputDataProcessor();

    private InputDataProcessor() {
    }

    public static InputDataProcessorI getInstance() {
        return inputDataPrcsrObj;
    }

    public void processData(FileProcessorI fileProcessorObj, SpendingStateI context) {
        try {
            while ((lineData = fileProcessorObj.readLine()) != null) {
                String[] keyValPairArr = lineData.split(":");
                if (isItemData(keyValPairArr[0]))
                    context.processItem(keyValPairArr[1]);

                if (isMoneyData(keyValPairArr[0]))
                    context.creditMoney(Integer.parseInt(keyValPairArr[1]));
            }
            fileProcessorObj.closeFile();
        } catch (IOException e) {
            try {
                fileProcessorObj.closeFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private boolean isItemData(String data) {
        return data.toLowerCase().trim().equals("item");
    }

    private boolean isMoneyData(String data) {
        return data.toLowerCase().trim().equals("money");
    }

}