package zpi_lab2.zpi_lab2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import lab2lib.lab2lib.OnCloseCallback;
import lab2lib.lab2lib.OnCloseCallbackImpl;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setExplicitExit(primaryStage);
		primaryStage.show();
		runMain();
	}
	
	private void setExplicitExit(Stage primaryStage) {
		OnCloseCallback onCloseCallback = new OnCloseCallbackImpl(SimpleConsole.getInstance());
		Platform.setImplicitExit(false);
		primaryStage.setOnCloseRequest(ev -> {
			if(onCloseCallback.closing()) {
				Platform.exit();
			} else {
				ev.consume();
			}
		});
	}
	
	private void runMain() {
		Main mainRun = new Main(SimpleConsole.getInstance());
		Thread mainThread = new Thread(mainRun, "Main app code thread.");
		mainThread.setDaemon(true);
		mainThread.start();
	}

}
