package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;

public class Bit extends SuperObject{
	public Bit() {
		
		this.name = "Bit";
		try {
			image = new Image(ClassLoader.getSystemResource("objects/bit.gif").toString());
		} catch (Exception e) {
			System.out.println("Load Bit's image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
	}
}
