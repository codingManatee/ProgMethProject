package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;

public class Door extends SuperObject{
	public Door() {
		this.name = "Door";
		this.solidArea = new Rectangle(-5,-5,74,74);
		collision = true;
		
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/door.gif").toString());
		} catch (Exception e){
			System.out.println("Load Door's image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub

	}
}
