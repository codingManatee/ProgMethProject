package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;

public class Spring extends SuperObject{
	public Spring(String name) {
		switch(name) {
		case "bottomLeft":
			this.name = "bottomLeft";
			// SET PICKUP RANGE
			this.solidArea = new Rectangle(16,128,32,32);
			
			try {
				image = new Image(ClassLoader.getSystemResource("objects/bit.png").toString());
			} catch (Exception e) {
				System.out.println("Load Spring's image Fail");
			}			
		}
	
			
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		
	}

}
