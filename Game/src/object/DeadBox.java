package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;

public class DeadBox extends SuperObject{
	public DeadBox() {
		this.name = "DeadBox";
		
		this.solidArea = new Rectangle(0,0,64,64);
		
		this.collision = true;
		
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/deadBox.gif").toString());
		} catch (Exception e) {
			System.out.println("Load DeadBox's Image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		
	}
}
