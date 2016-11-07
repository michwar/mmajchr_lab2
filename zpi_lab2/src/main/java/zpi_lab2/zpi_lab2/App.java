package zpi_lab2.zpi_lab2;

import javafx.application.Application;
import javafx.stage.Stage;
import lab2lib.lab2lib.FirstCallback;
import lab2lib.lab2lib.FirstCallbackImpl;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String fileName;
		String corectString;
		String incorrectString;

		SimpleConsole ui = SimpleConsole.getInstance();

		fileName = ui.prompt("Podaj nazwe pliku: ");

		corectString = ui.prompt("Podaj poprawny string: ");

		incorrectString = ui.prompt("Podaj niepoprawny string: ");

		FirstCallback firstCallback = new FirstCallbackImpl(ui);
		FileOperation fileOperation = new FileOperation(firstCallback, ui);
		fileOperation.saveFile(fileName, corectString, incorrectString);
	}

}
