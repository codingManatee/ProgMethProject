package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import main.GamePanel;
import sharedObject.RenderableHolder;

public class Player extends Entity{
	
	GamePanel gp;
	
	private int speed = 3;
	private String direction;
	private int spriteCounter = 0;
	private int spriteNum = 1;
	public final int screenX;
	public final int screenY;
	private int x ;
	private int y ;
	
	
	public Player(GamePanel gp) {

		this.gp = gp;
		this.direction = "right";	
		setDefaultValues();
		screenX = gp.getScreenWidth()/2 - gp.getTileSize()/2;
		screenY = gp.getScreenHeight()/2 - gp.getTileSize()/2;
		
		solidArea = new Rectangle(0,0, gp.getTileSize(), gp.getTileSize());
	}
	
	public void setDefaultValues() {
		
		worldX = gp.getTileSize() * 0;
		worldY = gp.getTileSize() * 0;
		
	}
	
	private void right() {
		direction = "right";
		this.worldX += speed;
	}
	
	private void left() {
		direction = "left";
		this.worldX -= speed;
	}
	
	private void up() {
		//direction = "up";
		this.worldY -= speed;
	}
	
	private void down() {
		//direction = "down";
		this.worldY += speed;
	}
	
	
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W)||InputUtility.getKeyPressed(KeyCode.S)
				||InputUtility.getKeyPressed(KeyCode.A)||InputUtility.getKeyPressed(KeyCode.D)) {
			if (InputUtility.getKeyPressed(KeyCode.W)) {
				up();
			} else if (InputUtility.getKeyPressed(KeyCode.S)){
				down();
			} else if (InputUtility.getKeyPressed(KeyCode.A)) {
				left();
			} else if (InputUtility.getKeyPressed(KeyCode.D)) {
				right();
			}
			
			if (InputUtility.getKeyPressed(KeyCode.SPACE)) {
				speed++;
				System.out.println(speed);
			}
			
			if (InputUtility.isLeftClickTriggered()) {
			}
			
			spriteCounter++;
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 3;
				} else if (spriteNum == 3) {
					spriteNum = 4;
				} else if (spriteNum == 4) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		Image image = null;
		switch(direction) {
		case "left":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().left1;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().left2;
			} else if (spriteNum == 3) {
				image = RenderableHolder.getInstance().left3;
			} else if (spriteNum == 4) {
				image = RenderableHolder.getInstance().left4;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().right1;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().right2;
			} else if (spriteNum == 3) {
				image = RenderableHolder.getInstance().right3;
			} else if (spriteNum == 4) {
				image = RenderableHolder.getInstance().right4;
			}
		}
		gc.drawImage(image, screenX, screenY);
	}

}
