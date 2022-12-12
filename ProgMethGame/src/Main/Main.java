package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	private static AudioClip sound;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Test1");
		sound = new AudioClip(ClassLoader.getSystemResource("sound/try.wav").toString());
		sound.play();
		Canvas canvas = new Canvas(1024,576);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		
		stage.show();
	}
	
}
