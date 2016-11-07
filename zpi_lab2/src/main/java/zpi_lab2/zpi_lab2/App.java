package zpi_lab2.zpi_lab2;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
		runMain();
	}
	
	private void runMain() {
		Main mainRun = new Main(SimpleConsole.getInstance());
		Thread mainThread = new Thread(mainRun, "Main app code thread.");
		mainThread.setDaemon(true);
		mainThread.start();
	}

}
