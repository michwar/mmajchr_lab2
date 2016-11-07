package zpi_lab2.zpi_lab2;

import java.util.Scanner;

import lab2lib.lab2lib.SimpleUserInterface;

public class SimpleConsole implements SimpleUserInterface {
	
	private static SimpleConsole instance = new SimpleConsole();

	private Scanner scanner;
	
	private SimpleConsole() {
		this.scanner = new Scanner(System.in);
	}
	
	public static SimpleConsole getInstance() {
		return instance;
	}

	@Override
	public String prompt(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	@Override
	public void show(String message) {
		System.out.println(message);
	}

	@Override
	public boolean promptYesNo(String promptMsg) {
		for(;;) {
			String c = prompt(promptMsg + " [T/N]");
			if(c.startsWith("T") || c.startsWith("t")) {
				return true;
			} else if(c.startsWith("N") || c.startsWith("n")) {
				return false;
			}
		}
	}

}
