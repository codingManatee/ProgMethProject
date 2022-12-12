package object;

import javafx.scene.image.Image;

public class Lever extends SuperObject{
	public boolean isOn = false;
	public Lever() {
		this.name = "Lever";
		try {
			if (!isOn) {
				this.image = new Image(ClassLoader.getSystemResource("objects/leverOff.png").toString());				
			} else {
				this.image = new Image(ClassLoader.getSystemResource("objects/leverOn.png").toString());
			}
		} catch (Exception e) {
			System.out.println("Load Lever's image Fail");
		}
		
	}
	
	public void setOn(boolean on) {
		this.isOn = on;
	}
}
