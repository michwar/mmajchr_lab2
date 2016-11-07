package zpi_lab2.zpi_lab2;

import java.util.Scanner;

import lab2lib.lab2lib.FirstCallback;
import lab2lib.lab2lib.FirstCallbackImpl;

public class App {
	public static void main(String[] args) {
		String fileName;
		String corectString;
		String incorrectString;

		Scanner scan = new Scanner(System.in);

		System.out.print("Podaj nazwe pliku: ");
		fileName = scan.nextLine();

		System.out.print("Podaj poprawny string: ");
		corectString = scan.nextLine();

		System.out.print("Podaj niepoprawny string: ");
		incorrectString = scan.nextLine();
		
		FirstCallback firstCallback = new FirstCallbackImpl(SimpleConsole.getInstance());
		FileOperation fileOperation = new FileOperation(firstCallback);
		fileOperation.saveFile(fileName, corectString, incorrectString);
		
	}
}
