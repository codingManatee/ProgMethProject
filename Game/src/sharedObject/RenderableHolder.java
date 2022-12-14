package sharedObject;

import javafx.scene.image.Image;


public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	// PLAYER ANIMATION
	public static Image up,down,left1,left2,left3,left4,left5,left6;
	public static Image right1,right2,right3,right4,right5,right6;
	
	public RenderableHolder() {
		loadResource();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		// PLAYER
		left1 = new Image(ClassLoader.getSystemResource("player/left1.png").toString());
		left2 = new Image(ClassLoader.getSystemResource("player/left2.png").toString());
		left3 = new Image(ClassLoader.getSystemResource("player/left3.png").toString());
		left4 = new Image(ClassLoader.getSystemResource("player/left4.png").toString());
		left5 = new Image(ClassLoader.getSystemResource("player/left5.png").toString());

		right1 = new Image(ClassLoader.getSystemResource("player/right1.png").toString());
		right2 = new Image(ClassLoader.getSystemResource("player/right2.png").toString());
		right3 = new Image(ClassLoader.getSystemResource("player/right3.png").toString());
		right4 = new Image(ClassLoader.getSystemResource("player/right4.png").toString());
		right5 = new Image(ClassLoader.getSystemResource("player/right5.png").toString());
	}
}
