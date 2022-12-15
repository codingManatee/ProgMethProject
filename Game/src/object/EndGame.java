package object;

import javafx.scene.image.Image;
import logic.Player;

public class EndGame extends SuperObject{
	
	public EndGame() {
		this.name = "EndGame";
		try {
			this.image = new Image(ClassLoader.getSystemResource("objects/endGame.gif").toString());
		} catch (Exception e){
			System.out.println("Load EndGame's Image Fail");
		}
	}
	
	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		player.Win();
	}
}
