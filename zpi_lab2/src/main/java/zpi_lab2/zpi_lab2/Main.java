package zpi_lab2.zpi_lab2;

import lab2lib.lab2lib.FirstCallback;
import lab2lib.lab2lib.FirstCallbackImpl;
import lab2lib.lab2lib.OnCloseCallback;
import lab2lib.lab2lib.OnCloseCallbackImpl;
import lab2lib.lab2lib.SimpleUserInterface;

public class Main implements Runnable {
	
	private SimpleUserInterface ui;
	private Close cl;
	
	public Main(SimpleUserInterface ui, Close cl) {
		this.ui = ui;
		this.cl = cl;
	}

	@Override
	public void run() {
		String fileName;
		String corectString;
		String incorrectString;
		
		OnCloseCallback onCloseCallback = new OnCloseCallbackImpl(ui);
		cl.setOnCloseCallback(onCloseCallback);

		fileName = ui.prompt("Podaj nazwe pliku: ");

		corectString = ui.prompt("Podaj poprawny string: ");

		incorrectString = ui.prompt("Podaj niepoprawny string: ");

		FirstCallback firstCallback = new FirstCallbackImpl(ui);
		FileOperation fileOperation = new FileOperation(firstCallback, ui);
		fileOperation.saveFile(fileName, corectString, incorrectString);
	}

}
