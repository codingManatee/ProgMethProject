package object;

import input.InputUtility;
import javafx.scene.image.Image;
import logic.Player;

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
	
	@Override
	public void interact(Player player) {
		if (InputUtility.isLeftClickTriggered()) {
			if (isOn == false) {						
				this.image = new Image(ClassLoader.getSystemResource("objects/leverOn.png").toString());
				setOn(true);
				System.out.println("ON");
			} else {
				this.image = new Image(ClassLoader.getSystemResource("objects/leverOff.png").toString());
				setOn(false);
				System.out.println("OFF");
			}
		}
	}
	
	public void setOn(boolean on) {
		this.isOn = on;
	}

}
