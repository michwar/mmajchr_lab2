package zpi_lab2.zpi_lab2;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

import lab2lib.lab2lib.SimpleUserInterface;

public class SimpleConsole implements SimpleUserInterface {
	
	private static SimpleConsole instance = new SimpleConsole();
	
	private Console console;
	private PrintWriter printWriter;
	private Reader reader;
	private Scanner scanner;
	
	private SimpleConsole() {
		this.console = System.console();
		this.printWriter = this.console.writer();
		this.reader = this.console.reader();
		this.scanner = new Scanner(this.reader);
	}
	
	public static SimpleConsole getInstance() {
		return instance;
	}

	@Override
	public String prompt(String arg0) {
		return null;
	}

	@Override
	public void show(String arg0) {
	}

}
