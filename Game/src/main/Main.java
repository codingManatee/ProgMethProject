/*
package main;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;

<<<<<<< Updated upstream
public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Adventure Time!");
		
		GameLogic logic = new GameLogic();
		GamePanel gamePanel = new GamePanel();
		root.getChildren().add(gamePanel);
		gamePanel.requestFocus();
		
		stage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gamePanel.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();
	}
}
*/
package main;

import component.HomePage;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.net.URISyntaxException;

import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1344, 832);
        
        GameLogic logic = new GameLogic();
		GamePanel gamePanel = new GamePanel();
		//root.getChildren().add(gamePanel);
        HomePage homePage = new HomePage();
        root.getChildren().add(homePage);
        
        gamePanel.requestFocus();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Adventure Time!");
        stage.show();

        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                gamePanel.paintComponent();
                logic.logicUpdate();
                RenderableHolder.getInstance().update();
                InputUtility.updateInputState();
            }
        };
        animation.start();
    }
=======
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1344, 832);
		stage.setScene(scene);
		stage.setTitle("GET OUT!");
		stage.getIcons().add(new Image(ClassLoader.getSystemResource("player/right3.png").toString()));

		HomePage homepage = new HomePage();
		root.getChildren().add(homepage);

		stage.show();
	}
>>>>>>> Stashed changes
}