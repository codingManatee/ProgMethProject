package object;

import java.util.Timer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;
import logic.Sound;
import main.GamePanel;

public abstract class SuperObject{
	public Image image;
	public String name;
	public boolean collision = false;
	public int worldX,worldY;
	long startTime = System.nanoTime();
	
	// FOR SOUNDEFFECT
	Sound soundE;

	// SET OBJECT RANGE
	public Rectangle solidArea = new Rectangle(0,0,64,64);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	// PICK UP STATUS
	public boolean visible = true;
	
	public SuperObject() {
		this.image = null;
		this.name = "default object";
		soundE = new Sound();
	}
	
	public void draw(GraphicsContext gc, GamePanel gp) {
		
		int screenX = worldX - gp.getPlayer().worldX + gp.getPlayer().screenX;
		int screenY = worldY - gp.getPlayer().worldY + gp.getPlayer().screenY;
		
		if (worldX + gp.getTileSize() > gp.getPlayer().worldX - gp.getPlayer().screenX && 
			worldX - gp.getTileSize() < gp.getPlayer().worldX + gp.getPlayer().screenX &&
			worldY + gp.getTileSize() > gp.getPlayer().worldY - gp.getPlayer().screenY &&
			worldY - gp.getTileSize() < gp.getPlayer().worldY + gp.getPlayer().screenY) {
			
			gc.drawImage(image, screenX, screenY , gp.getTileSize() , gp.getTileSize() );
		}
	}
	
	public void playSE(int i) {
		soundE.setFile(i);
		soundE.play();
	}
	
	public abstract void interact(Player player);

	// GETTER AND SETTER
	public boolean isVisible() {
		return this.visible;
	}
	public void setVisible(boolean bool) {
		this.visible = bool;
	}
}
