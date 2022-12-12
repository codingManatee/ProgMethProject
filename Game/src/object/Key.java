package object;

import javafx.scene.image.Image;

public class Key extends SuperObject{
	public Key() {
		this.name = "Key";
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/key.png").toString());
		} catch (Exception e) {
			System.out.println("Load Key's image Fail");
		}
	}
}
