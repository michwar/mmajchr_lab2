package zpi_lab2.zpi_lab2;

import lab2lib.lab2lib.SimpleUserInterface;

public class SimpleConsole implements SimpleUserInterface {
	
	private static SimpleConsole instance = new SimpleConsole();
	
	private SimpleConsole() {
		;
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
