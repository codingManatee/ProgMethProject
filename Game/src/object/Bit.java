package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Bit extends SuperObject{
	public Bit() {
		
		this.name = "Bit";
		try {
			image = new Image(ClassLoader.getSystemResource("objects/bit.png").toString());
		} catch (Exception e) {
			System.out.println("Load Bit's image Fail");
		}
	}
}
