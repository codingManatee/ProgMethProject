package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {

	public static double mouseX,mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
<<<<<<< Updated upstream
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>(); 
	
=======
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	private static KeyCode lastKey;

>>>>>>> Stashed changes
	public static boolean getKeyPressed(KeyCode keycode) {
		return keyPressed.contains(keycode);
	}

	public static void setKeyPressed(KeyCode keycode, boolean pressed) {
		if (pressed) {
			if (!keyPressed.contains(keycode)) {
				keyPressed.add(keycode);
			}
		} else {
			keyPressed.remove(keycode);
		}
		System.out.println(keyPressed);
	}

	public static void mouseLeftDown() {
		isLeftDown = true;
		isLeftClickedLastTick = true;
	}

<<<<<<< Updated upstream
	public static void mouseLeftRelease(){
=======
	public static void mouseLeftRelease() {
>>>>>>> Stashed changes
		isLeftDown = false;
	}

	public static boolean isLeftClickTriggered() {
		return isLeftClickedLastTick;
	}

	public static void updateInputState() {
		isLeftClickedLastTick = false;
	}

}
