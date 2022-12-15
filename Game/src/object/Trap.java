package object;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;

public class Trap extends SuperObject implements Killable {

	public Trap(String name) {
		this.name = "Trap";
		this.solidArea = new Rectangle(0, 0, 66, 66);

		switch (name) {
		case "TrapUp":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapUp.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapUp's Image Fail");
			}
			break;
		case "TrapDown":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapDown.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapDown's Image Fail");
			}
			break;
		case "TrapLeft":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapLeft's Image Fail");
			}
			break;
		case "TrapRight":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapRight's Image Fail");
			}
			break;
		case "TrapTopLeft":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapTopLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapTopLeft's Image Fail");
			}
			break;
		case "TrapTopRight":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapTopRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapTopRight's Image Fail");
			}
			break;
		case "TrapBottomLeft":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapBottomLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapBottomLeft's Image Fail");
			}
			break;
		case "TrapBottomRight":
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapBottomRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapBottomRight's Image Fail");
			}
			break;
		}
	}

	@Override
	public void interact(Player player) {
		kill(player);
	}

	@Override
	public void kill(Player player) {
		// TODO Auto-generated method stub
		player.Dead();
	}

}
