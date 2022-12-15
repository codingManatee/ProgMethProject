
package main;

import component.HomePage;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1344, 832);
        stage.setScene(scene);
        stage.setTitle("Get Out!");
        
        
        HomePage homepage = new HomePage();
        root.getChildren().add(homepage);
        
        stage.show();
    }
}