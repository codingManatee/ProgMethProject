package object;

import javafx.scene.image.Image;
import logic.Player;

public class Fire extends SuperObject implements Killable{
	public Fire() {
		this.name = "Fire";
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/fire.gif").toString());
		} catch (Exception e) {
			System.out.println("Load Fire's Image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		kill(player);
	}

	@Override
	public void kill(Player player) {
		// TODO Auto-generated method stub
		player.Dead();
	}
}
