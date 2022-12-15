package main;

import input.InputUtility;
import logic.AssetSetter;
import logic.CollisionChecker;
import logic.Player;
import logic.Sound;
import object.SuperObject;
import sharedObject.RenderableHolder;
import tile.TileManager;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GamePanel extends Canvas{
	
	// SCREEN SETTING
	final int originalTileSize = 64; // 32x32 tile
	final int scale = 1;
	
	final int tileSize = originalTileSize * scale; // 64x64 tile
	final int maxScreenCol = 21;
	final int maxScreenRow = 13;
	final int screenWidth = tileSize * maxScreenCol; // 1344 pixels
	final int screenHeight = tileSize * maxScreenRow; //960 pixels
	
	// WORLD SETTING
	public int maxWorldCol;
	public int maxWorldRow;

	// PLAYER AND OBJECT
	Player player = new Player(this);
	SuperObject obj[] = new SuperObject[1000];
	AssetSetter aSetter = new AssetSetter(this);

	// SYSTEM
	TileManager tileM = new TileManager(this);
	CollisionChecker cChecker = new CollisionChecker(this);
	Sound sound = new Sound();
	
	public GamePanel() {
		this.setHeight(screenHeight);
		this.setWidth(screenWidth);
		this.setVisible(true);
		addListener();
		
	}

	// START SETTING
	public void setUpGame() {
		
		aSetter.setObject();
		//playMusic(0);
	}

	
	// INPUT KEY
	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

		this.setOnMousePressed((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY)
				InputUtility.mouseLeftDown();
		});

		this.setOnMouseReleased((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY)
				InputUtility.mouseLeftRelease();
		});

	}
	
	// CANVAS PAINTER
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		if (player.gameState == 0) {			
			// GAME RUNNING
			
			// TILE
			tileM.draw(gc);
			
			// OBJECT
			for (int i = 0 ; i < obj.length ; i++) {
				if (obj[i] != null) {
					obj[i].draw(gc, this);
				}
			}
			gc.setFill(Color.WHITE);
			Font font = new Font(40);
			gc.setFont(font);
			gc.fillText(Integer.toString(player.curScore),screenWidth - 40 ,50);
			player.draw(gc);
		} else if (player.gameState == 1){
			// LOSE
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, screenWidth, screenHeight);
			
			gc.setFill(Color.WHITE);
			Font font = new Font(100);
			gc.setFont(font);
			gc.fillText("GAME OVER",screenWidth/3-25,screenHeight/2);
			
			
		} else {
			// WIN
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, screenWidth, screenHeight);
			
			gc.setFill(Color.WHITE);
			Font font = new Font(100);
			gc.setFont(font);
			gc.fillText("GAME WIN",screenWidth/3-25,screenHeight/2);
			
		}
	}
	
	
//	// SOUND PLAYER
//	public void playSE(int i) {
//		sound.setFile(i);
//		sound.play();
//	}

	// Getter and Setter
	public int getTileSize() {
		return this.tileSize;
	}
	public int getMaxScreenCol() {
		return this.maxScreenCol;
	}
	public int getMaxScreenRow() {
		return this.maxScreenRow;
	}
	public int getScreenWidth() {
		return this.screenWidth;
	}
	public int getScreenHeight() {
		return this.screenHeight;
	}
	public int getMaxWorldCol() {
		return this.maxWorldCol;
	}
	public int getMaxWorldRow() {
		return this.maxWorldRow ;
	}
	public Player getPlayer() {
		return this.player;
	}
	public TileManager getTileManager() {
		return this.tileM;
	}
	public CollisionChecker getCollisionChecker() {
		return this.cChecker;
	}
	public SuperObject[] getSuperObject() {
		return this.obj;
	}
}
