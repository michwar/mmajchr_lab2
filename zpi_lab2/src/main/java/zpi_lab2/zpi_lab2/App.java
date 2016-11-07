package zpi_lab2.zpi_lab2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lab2lib.lab2lib.OnCloseCallback;
import lab2lib.lab2lib.SimpleUserInterface;

public class App extends Application implements Close, SimpleUserInterface {
	
	private OnCloseCallback onCloseCallback;
	private TextArea textOut;
	private TextField textIn;
	private Button btnOK;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		textOut = new TextArea();
		textOut.setEditable(false);
		root.setCenter(textOut);
		BorderPane bottom = new BorderPane();
		textIn = new TextField();
		bottom.setCenter(textIn);
		btnOK = new Button("OK");
		btnOK.setDefaultButton(true);
		btnOK.setDisable(true);
		bottom.setRight(btnOK);
		root.setBottom(bottom);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
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
		Main mainRun = new Main(this, this);
		Thread mainThread = new Thread(mainRun, "Main app code thread.");
		mainThread.setDaemon(true);
		mainThread.start();
	}

	@Override
	public String prompt(String promptMsg) {
		show(promptMsg);
		return null;
	}

	@Override
	public boolean promptYesNo(String promptMsg) {
		prompt(promptMsg);
		return false;
	}

	@Override
	public void show(String message) {
		textOut.appendText(message + "\n");
	}

}
