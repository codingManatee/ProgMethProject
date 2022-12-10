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
	private static final int speed = 2;
	private int angle = 0;
	
	public Player(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	private void right() {
		this.x += speed;
	}
	
	private void left() {
		this.x -= speed;
	}
	
	private void up() {
		this.y -= speed;
	}
	
	private void down() {
		this.y += speed;
	}
	
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			up();
		} else if (InputUtility.getKeyPressed(KeyCode.S)){
			down();
		}
		if (InputUtility.getKeyPressed(KeyCode.A)) {
			left();
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			right();
		}
		if (InputUtility.isLeftClickTriggered()) {
			this.x = InputUtility.mouseX;
			this.y = InputUtility.mouseY;
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.player_model, x, y);
		//gc.translate(x, y);
		//gc.translate(-x, -y);
	}

}
