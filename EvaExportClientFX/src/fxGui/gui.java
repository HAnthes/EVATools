package fxGui;

import java.rmi.RemoteException;
import java.util.Date;

import client.Client;
import client.RemoteListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 * JavaF Gui mit Startknopf und Textfeld für ein Loggin.
 * @version 1
 * 
 */
public class gui extends Application implements RemoteListener {
	TextArea logView;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws RemoteException {
		Client client = Client.getInstance();
		client.getObserver().register(this);

		logView = new TextArea();
		Button button1 = new Button();
		button1.setText("Start");
		button1.setOnAction(e -> {
			try {
				if (!client.getServer().getStatus())
					client.getServer().startTransfer();
				else rlistner("Prozess is running" );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Label zeit = new Label("Letzter Start : "
				+ new Date(client.getServer().getLastTransfer()));

		HBox box = new HBox(button1);
		box.setAlignment(Pos.CENTER_LEFT);
		box.setSpacing(20);

		BorderPane bp = new BorderPane(); // Basis Layout

		bp.setTop(box);
		bp.setCenter(logView);
		bp.setBottom(zeit);

		primaryStage.setTitle("EVA Export");
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			public void handle(WindowEvent event) {
				client.deregister();
				Platform.exit();
				System.exit(0);
			}
		});

		Scene scene = new Scene(bp, 640, 480);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void rlistner(String x) {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				logView.appendText(x + "\n");

			}
		});

	}

}