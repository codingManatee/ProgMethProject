package object;

import javafx.scene.image.Image;
import logic.Player;

public class Trap extends SuperObject {
	
	public Trap(String name) {
		switch(name) {
		case "TrapUp": this.name = "TrapUp";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapUp.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapUp's Image Fail");
			}
			break;
		case "TrapDown": this.name = "TrapDown";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapDown.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapDown's Image Fail");
			}
		case "TrapLeft": this.name = "TrapLeft";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapLeft's Image Fail");
			}
		case "TrapRight": this.name = "TrapRight";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapRight's Image Fail");
			}
		case "TrapTopLeft" : this.name = "TrapTopLeft";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapTopLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapTopLeft's Image Fail");
			}
		case "TrapTopRight" : this.name = "TrapTopRight";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapTopRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapTopRight's Image Fail");
			}
		case "TrapBottomLeft" : this.name = "TrapBottomLeft";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapBottomLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapBottomLeft's Image Fail");
			}
		case "TrapBottomRight" : this.name = "TrapBottomRight";
			try {
				this.image = new Image(ClassLoader.getSystemResource("objects/trapBottomRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load TrapBottomRight's Image Fail");
			}
		}
	}
	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		player.Dead();	
	}
	
}
