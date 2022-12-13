package object;

import javafx.scene.image.Image;
import logic.Player;

public class Coin extends SuperObject{
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
		// TODO Auto-generated method stub
		this.equals(null);
	}
}
