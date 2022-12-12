package object;

import javafx.scene.image.Image;

public class Spring extends SuperObject{
	
	public Spring() {
		this.name = "Spring";
		try {
			image = new Image(ClassLoader.getSystemResource("objects/bit.png").toString());
		} catch (Exception e) {
			System.out.println("Load Spring's image Fail");
		}
	}

}
