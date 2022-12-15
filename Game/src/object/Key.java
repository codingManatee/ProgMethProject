package object;

import javafx.scene.image.Image;
import logic.Player;

public class Key extends SuperObject implements Pickable {
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
		if (isVisible()) {
			this.image = null;
			pick(player);
		}
		setVisible(false);
	}

	@Override
	public void pick(Player player) {
		// TODO Auto-generated method stub
		player.hasKey++;
		this.playSE(3);
	}
}
