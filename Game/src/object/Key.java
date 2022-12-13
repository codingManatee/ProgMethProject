package object;

import javafx.scene.image.Image;
import logic.Player;

public class Key extends SuperObject{
	public Key() {
		this.name = "Key";
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/key.gif").toString());
		} catch (Exception e) {
			System.out.println("Load Key's image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		player.hasKey++;
	}
}
