package zpi_lab2.zpi_lab2;

import java.io.File;

import lab2lib.lab2lib.FirstCallback;
import lab2lib.lab2lib.SaveResult;
import lab2lib.lab2lib.SecondCallback;
import lab2lib.lab2lib.SecondCallbackImpl;

public class FileOperation {

	private FirstCallback mFirstCallback;

	public FileOperation() {
	}

	public FileOperation(FirstCallback firstCallback) {
		mFirstCallback = firstCallback;
	}

	public void saveFile(final String fileName, final String correctString, final String incorrectString) {
		String result = fileName;
		while (null != result) {
			result = saveNewFile(result, correctString, incorrectString);
		}
	}

	private String saveNewFile(String fileName, String correctString, String incorrectString) {
		File file = null;
		String result;
		SaveResult saveResult = new SaveResult(fileName, correctString, incorrectString);
		SecondCallback seconCallback = new SecondCallbackImpl(saveResult);
		
		return result;
	}
}
