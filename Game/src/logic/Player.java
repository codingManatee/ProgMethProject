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
	
	// GAME PANEL
	GamePanel gp;
	
	// PRIVATE SETTING
	private double speed;
	private String direction;
	private String faceDirection;
	
	// ANIMATION PLAYER
	private int spriteCounter = 0;
	private int spriteNum = 1;
	
	public final int screenX;
	public final int screenY;
	
	// IN GAME SCORE
	public int curScore;
	public int hasKey;
	
	// PLAYER STATUS
	public int gameState;
	
	public Player(GamePanel gp) {

		this.gp = gp;
		this.direction = "down";	
		this.faceDirection = "right";
		this.speed = 3;
		setDefaultValues();
		screenX = gp.getScreenWidth()/2 - gp.getTileSize()/2;
		screenY = gp.getScreenHeight()/2 - gp.getTileSize()/2;
		
		// HITBOX
		solidArea = new Rectangle(4,4,52,52);
		
		// PICKUP RANGE
		pickRange = new Rectangle(8,8,48,48);

		
		solidAreaDefaultX = (int) solidArea.getX();
		solidAreaDefaultY = (int) solidArea.getY();
		 
		pickRangeDefaultX = (int) pickRange.getX();
		pickRangeDefaultY = (int) pickRange.getY();
	}
	
	public void setDefaultValues() {
		
		// SET PLAYER'S ORIGIN
		worldX = gp.getTileSize() * 13;
		worldY = gp.getTileSize() * 85;
		
	}

	public void update() {
		if ((InputUtility.getKeyPressed(KeyCode.W)||InputUtility.getKeyPressed(KeyCode.S)
				||InputUtility.getKeyPressed(KeyCode.A)||InputUtility.getKeyPressed(KeyCode.D))
				&& (collisionOnLeft||collisionOnRight||collisionOnTop||collisionOnBottom)) {
			if (InputUtility.getKeyPressed(KeyCode.W)) { direction = "up"; } 
			else if (InputUtility.getKeyPressed(KeyCode.S)) { direction = "down"; }
			else if (InputUtility.getKeyPressed(KeyCode.A)) { direction = "left"; faceDirection = "left"; }
			else if (InputUtility.getKeyPressed(KeyCode.D)) { direction = "right"; faceDirection = "right"; }
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			move(direction);
			
			// CHECK TILE COLLISION
			collisionOnLeft = false;
			collisionOnRight = false;
			collisionOnTop = false;
			collisionOnBottom = false;
			speed = 3;
		}
		
		// IF FLYING, ADD SPEED
		isFlying();
		
		// CHECK OBJECT COLLISION
		gp.getCollisionChecker().checkTile(this);
		int objIndex = gp.getCollisionChecker().checkObject(this, true);
		pickUpObject(objIndex);
		
		// ANIMATE THE PLAYER
		animate();
	}
	
	public void move(String direction) {
		switch(direction) {
		case "up": if (!collisionOnTop) this.worldY -= speed; break;
		case "down": if (!collisionOnBottom) this.worldY += speed; break;
		case "left": if (!collisionOnLeft) this.worldX -= speed; break;
		case "right": if (!collisionOnRight) this.worldX += speed; break;
		}		
	}
	
	public void isFlying() {
		if (!(collisionOnLeft||collisionOnRight||collisionOnTop||collisionOnBottom) && (speed < 15)) {
			speed += 0.1;
		}
	}
	
	public void animate(){
		// ANIMATION OF PLAYER
		spriteCounter++;
		if (spriteCounter > 12) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 3;
			} else if (spriteNum == 3) {
				spriteNum = 4;
			} else if (spriteNum == 4) {
				spriteNum = 5;
			} else if (spriteNum == 5) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	// OBJECT CHECKER
	public void pickUpObject(int i) {
		if (i != 999) {
			gp.getSuperObject()[i].interact(this);
		}
	}

	
	public void draw(GraphicsContext gc) {
		Image image = null;
		switch(faceDirection) {
		case "left":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().left1;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().left2;
			} else if (spriteNum == 3) {
				image = RenderableHolder.getInstance().left3;
			} else if (spriteNum == 4) {
				image = RenderableHolder.getInstance().left4;
			} else if (spriteNum == 5) {
				image = RenderableHolder.getInstance().left5;
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
			} else if (spriteNum == 5) {
				image = RenderableHolder.getInstance().right5;
			}		
		}
		gc.drawImage(image, screenX, screenY);
	}
	
	
	// GETTER AND SETTER
	public String getDirection() {
		return this.direction;
	}
	public double getSpeed() {
		return this.speed;
	}
	public void Win() {
		this.gameState = 2;
	}
	
	public void Dead() {
		this.gameState = 1;
	}
}
