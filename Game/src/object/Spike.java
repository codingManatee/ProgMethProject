package object;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import logic.Player;

public class Spike extends SuperObject implements Killable {

	boolean isActive = false;
	Image active;

	public Spike(String name) {
		this.name = "Spike";
		image = new Image(ClassLoader.getSystemResource("objects/spikeOff.gif").toString());

		switch (name) {
		case "SpikeUp":
			try {
				active = new Image(ClassLoader.getSystemResource("objects/spikeUp.gif").toString());
			} catch (Exception e) {
				System.out.println("Load spikeUp's image Fail");
			}
			break;
		case "SpikeLeft":
			try {
				active = new Image(ClassLoader.getSystemResource("objects/spikeLeft.gif").toString());
			} catch (Exception e) {
				System.out.println("Load spikeLeft's image Fail");
			}
			break;
		case "SpikeRight":
			try {
				active = new Image(ClassLoader.getSystemResource("objects/spikeRight.gif").toString());
			} catch (Exception e) {
				System.out.println("Load spikeRight's image Fail");
			}
			break;
		case "SpikeBottom":
			try {
				active = new Image(ClassLoader.getSystemResource("objects/spikeBottom.gif").toString());
			} catch (Exception e) {
				System.out.println("Load spikeBottom's image Fail");
			}
			break;
		}

	}

	@Override
	public void interact(Player player) {
		if (!isActive) {
			Timer time = new Timer();
			TimerTask task = new TimerTask() {
				int count = 0;

				@Override
				public void run() {
					if (count > 0 && count < 2) {
						isActive = true;
						image = active;
					} else if (count == 4) {
						time.cancel();
						isActive = false;
						image = new Image(ClassLoader.getSystemResource("objects/spikeOff.gif").toString());
					}
					count++;
				}
			};
			time.scheduleAtFixedRate(task, 0, 1000);
		} else {
			kill(player);
		}
	}

	@Override
	public void kill(Player player) {
		// TODO Auto-generated method stub
		player.Dead();
	}
}
