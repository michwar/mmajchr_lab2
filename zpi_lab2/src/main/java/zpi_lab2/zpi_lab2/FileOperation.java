package zpi_lab2.zpi_lab2;

import lab2lib.lab2lib.FirstCallback;

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

	private String saveNewFile(String result, String correctString, String incorrectString) {
		// TODO Auto-generated method stub
		return null;
	}
}
