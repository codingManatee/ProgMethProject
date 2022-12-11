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
	
	int curScore;
	
	public Player(GamePanel gp) {

		this.gp = gp;
		this.direction = "right";	
		setDefaultValues();
		screenX = gp.getScreenWidth()/2 - gp.getTileSize()/2;
		screenY = gp.getScreenHeight()/2 - gp.getTileSize()/2;
		
		solidArea = new Rectangle(16,16,32,32);
		solidAreaDefaultX = (int) solidArea.getX();
		solidAreaDefaultY = (int) solidArea.getY();
		 
	}
	
	public void setDefaultValues() {
		
		worldX = gp.getTileSize() * 8;
		worldY = gp.getTileSize() * 5;
		
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
	
			if (InputUtility.isLeftClickTriggered()) {
				System.out.println(curScore);
			}
			
			// CHECK TILE COLLISION
			collisionOnLeft = false;
			collisionOnRight = false;
			collisionOnTop = false;
			collisionOnBottom = false;
			gp.getCollisionChecker().checkTile(this);
			
			// CHECK OBJECT COLLISION
			int objIndex = gp.getCollisionChecker().checkObject(this, true);
			pickUpObject(objIndex);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			switch(direction) {
				case "up": if (!collisionOnTop) this.worldY -= speed; break;
				case "down": if (!collisionOnBottom) this.worldY += speed; break;
				case "left": if (!collisionOnLeft) this.worldX -= speed; break;
				case "right": if (!collisionOnRight) this.worldX += speed; break;
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
	
	public void pickUpObject(int i) {
		if (i != 999) {
			String objectName = gp.getSuperObject()[i].name;
			
			switch(objectName) {
			case "Bit":
				curScore++;
				gp.getSuperObject()[i] = null;
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
