package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Player;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	// PLAYER ANIMATION
	public static Image up,down,left1,left2,left3,left4,left5,left6;
	public static Image right1,right2,right3,right4,right5,right6;
	
	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		
		// PLAYER
		left1 = new Image(ClassLoader.getSystemResource("player/left1.png").toString());
		left2 = new Image(ClassLoader.getSystemResource("player/left2.png").toString());
		left3 = new Image(ClassLoader.getSystemResource("player/left3.png").toString());
		left4 = new Image(ClassLoader.getSystemResource("player/left4.png").toString());
		left5 = new Image(ClassLoader.getSystemResource("player/left5.png").toString());

		
		right1 = new Image(ClassLoader.getSystemResource("player/right1.png").toString());
		right2 = new Image(ClassLoader.getSystemResource("player/right2.png").toString());
		right3 = new Image(ClassLoader.getSystemResource("player/right3.png").toString());
		right4 = new Image(ClassLoader.getSystemResource("player/right4.png").toString());
		right5 = new Image(ClassLoader.getSystemResource("player/right5.png").toString());

	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof Player) System.out.println("player");

		}
	}
	
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
}
