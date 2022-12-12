package main;

import input.InputUtility;
import logic.AssetSetter;
import logic.CollisionChecker;
import logic.Player;
import object.SuperObject;
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
import javafx.scene.text.Font;

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
	public final int maxWorldCol = 30;
	public final int maxWorldRow = 30;
	public final int worldWidth = maxWorldCol * tileSize;
	public final int worldHeight = maxWorldRow * tileSize; 
	
	// PLAYER AND OBJECT
	Player player = new Player(this);
	SuperObject obj[] = new SuperObject[10];
	AssetSetter aSetter = new AssetSetter(this);
	
	// SYSTEM
	TileManager tileM = new TileManager(this);
	CollisionChecker cChecker = new CollisionChecker(this);
	
	
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
	
	public void setUpGame() {
		
		aSetter.setObject();
		
	}
	
	// CANVAS PAINTER
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		
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

		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			// PLAYER
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
