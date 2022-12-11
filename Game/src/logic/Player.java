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
	
	private int speed = 4;
	private String direction;
	private int spriteCounter = 0;
	private int spriteNum = 1;
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp) {

		this.gp = gp;
		this.direction = "right";	
		setDefaultValues();
		screenX = gp.getScreenWidth()/2 - gp.getTileSize()/2;
		screenY = gp.getScreenHeight()/2 - gp.getTileSize()/2;
		
		solidArea = new Rectangle(8,8,56,56);
	}
	
	public void setDefaultValues() {
		
		worldX = gp.getTileSize() * 7;
		worldY = gp.getTileSize() * 7;
		
	}
	
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W)||InputUtility.getKeyPressed(KeyCode.S)
				||InputUtility.getKeyPressed(KeyCode.A)||InputUtility.getKeyPressed(KeyCode.D)) {
			if (InputUtility.getKeyPressed(KeyCode.W)) {
				direction = "up";
			} else if (InputUtility.getKeyPressed(KeyCode.S)){
				direction = "down";
			} else if (InputUtility.getKeyPressed(KeyCode.A)) {
				direction = "left";
			} else if (InputUtility.getKeyPressed(KeyCode.D)) {
				direction = "right";
			}
			
			if (InputUtility.getKeyPressed(KeyCode.SPACE)) {
				speed++;
				System.out.println(speed);
			}
			
			if (InputUtility.isLeftClickTriggered()) {
			}
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.getCollisionChecker().checkTile(this);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {
				switch(direction) {
				case "up": this.worldY -= speed; break;
				case "down": this.worldY += speed; break;
				case "left": this.worldX -= speed; break;
				case "right": this.worldX += speed; break;
				}		
			}
			
			spriteCounter++;
			
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
		default :
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

	
	// GETTER AND SETTER
	public String getDirection() {
		return this.direction;
	}
	public int getSpeed() {
		return this.speed;
	}
}
