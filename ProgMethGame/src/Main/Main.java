package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Test1");
		
		Canvas canvas = new Canvas(1024,576);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		String image_path = "C:\\Users\\patta\\Desktop\\pixil-layer-5.png";
		setBackGround(gc);
		drawText(gc);
		drawImage(gc,image_path);
		stage.show();
	}
	
	public void setBackGround(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
	
	public void drawText(GraphicsContext gc) {
		gc.setLineWidth(2);
		gc.setFill(Color.RED);
		Font font = Font.font("Times New Rowan",FontWeight.BOLD,58);
		gc.setFont(font);
		gc.fillText("Hello World",300,300);
	}
	
	public void drawImage(GraphicsContext gc,String image_path) {
		System.out.println(image_path);
		Image image = new Image(image_path);
		gc.translate(gc.getCanvas().getWidth()/2, gc.getCanvas().getHeight()/2);
		gc.drawImage(image, 100, 100);
//		int angle = 0;
//		while (angle < 360) {
//			angle += 10;
//			gc.rotate(angle);
//			gc.drawImage(image,,100);
//		}
	}
	
}
