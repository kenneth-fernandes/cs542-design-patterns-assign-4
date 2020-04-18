package expenseManager.util.dataprocess;

import expenseManager.state.SpendingStateI;
import expenseManager.util.fileprocess.FileProcessorI;

public interface InputDataProcessorI {

    public void processData(FileProcessorI fileProcessorObj, SpendingStateI context);

}