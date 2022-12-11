package main;

import input.InputUtility;
import logic.CollisionChecker;
import logic.Player;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import tile.TileManager;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GamePanel extends Canvas{
	
	// SCREEN SETTING
	final int originalTileSize = 32; // 32x32 tile
	final int scale = 2;
	
	final int tileSize = originalTileSize * scale; // 64x64 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 9;
	final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	// WORLD SETTING
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = maxWorldCol * tileSize;
	public final int worldHeight = maxWorldRow * tileSize; 
	
	
	// TILE MANAGER
	TileManager tileM = new TileManager(this);
	
	// PLAYER
	public Player player = new Player(this);
	
	// COLLISION CHECKER
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	public GamePanel() {
		this.setHeight(screenHeight);
		this.setWidth(screenWidth);
		this.setVisible(true);
		addListener();
		
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
		
		this.setOnMouseEntered((MouseEvent event) -> {
			InputUtility.mouseOnScreen = true;
		});

		this.setOnMouseExited((MouseEvent event) -> {
			InputUtility.mouseOnScreen = false;
		});

		this.setOnMouseMoved((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
			}
		});

		this.setOnMouseDragged((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
			}
		});
	}
	
	// CANVAS PAINTER
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			//System.out.println(entity.getZ());
			tileM.draw(gc);
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}

	}
	
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
}
