package zpi_lab2.zpi_lab2;

import java.util.Scanner;

import lab2lib.lab2lib.FirstCallback;
import lab2lib.lab2lib.FirstCallbackImpl;

public class App {
	public static void main(String[] args) {
		String fileName;
		String corectString;
		String incorrectString;

		SimpleConsole ui = SimpleConsole.getInstance();

		fileName = ui.prompt("Podaj nazwe pliku: ");

		corectString = ui.prompt("Podaj poprawny string: ");

		incorrectString = ui.prompt("Podaj niepoprawny string: ");
		
		FirstCallback firstCallback = new FirstCallbackImpl(ui);
		FileOperation fileOperation = new FileOperation(firstCallback);
		fileOperation.saveFile(fileName, corectString, incorrectString);
		
	}
}
