package object;

import javafx.scene.image.Image;
import logic.Player;

public class Coin extends SuperObject implements Pickable {
	public Coin() {
		this.name = "Coin";
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/coin.gif").toString());
		} catch (Exception e) {
			System.out.println("Load Coin's Image Fail");
		}
	}

	@Override
	public void interact(Player player) {
		if (isVisible()) {
			this.image = null;
			this.playSE(1);
		}
		setVisible(false);
	}

	@Override
	public void pick(Player player) {
		// TODO Auto-generated method stub
		player.curScore++;
	}
}
