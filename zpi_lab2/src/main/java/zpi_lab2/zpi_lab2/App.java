package zpi_lab2.zpi_lab2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import lab2lib.lab2lib.OnCloseCallback;

public class App extends Application implements Close {
	
	private OnCloseCallback onCloseCallback;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setExplicitExit(primaryStage);
		primaryStage.show();
		runMain();
	}

	@Override
	public OnCloseCallback getOnCloseCallback() {
		return onCloseCallback;
	}

	@Override
	public void setOnCloseCallback(OnCloseCallback onCloseCallback) {
		this.onCloseCallback = onCloseCallback;
	}

	private void setExplicitExit(Stage primaryStage) {
		Platform.setImplicitExit(false);
		primaryStage.setOnCloseRequest(ev -> {
			if(onCloseCallback == null || onCloseCallback.closing()) {
				Platform.exit();
			} else {
				ev.consume();
			}
		});
	}
	
	private void runMain() {
		Main mainRun = new Main(SimpleConsole.getInstance(), this);
		Thread mainThread = new Thread(mainRun, "Main app code thread.");
		mainThread.setDaemon(true);
		mainThread.start();
	}

}
