package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import sharedObject.RenderableHolder;

public class Player extends CollidableEntity{
	private static final int speed = 3;
	private String direction;
	private int spriteCounter = 0;
	private int spriteNum = 1;
	
	
	public Player(double x,double y) {
		this.x = x;
		this.y = y;
		this.radius = 10;
		this.direction = "right";
	}
	
	private void right() {
		direction = "right";
		this.x += speed;
	}
	
	private void left() {
		direction = "left";
		this.x -= speed;
	}
	
	private void up() {
		direction = "up";
		this.y -= speed;
	}
	
	private void down() {
		direction = "down";
		this.y += speed;
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
			
			if (InputUtility.isLeftClickTriggered()) {
				//this.x = InputUtility.mouseX;
				//this.y = InputUtility.mouseY;
			}
			
			spriteCounter++;
			
			System.out.println(spriteCounter);
			System.out.println(spriteNum);
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
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
		case "up":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().up;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().close;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().down;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().close;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().left;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().close;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = RenderableHolder.getInstance().right;				
			} else if (spriteNum == 2) {
				image = RenderableHolder.getInstance().close;
			}
			break;
		}
		gc.drawImage(image, x, y);
		//gc.setFill(Color.BLUE);
		//gc.fillRect(x, y, 64, 64);
		//gc.translate(x, y);
		//gc.translate(-x, -y);
	}

}
