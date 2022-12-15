package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

<<<<<<< Updated upstream
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Player;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image player_model;
	public static Image up,down,left,right,close,grass,water,sand,brick,tree;
	
	static {
=======
public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	// PLAYER ANIMATION
	public static Image up, down, left1, left2, left3, left4, left5, left6;
	public static Image right1, right2, right3, right4, right5, right6;

	public RenderableHolder() {
>>>>>>> Stashed changes
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
		up = new Image(ClassLoader.getSystemResource("player/up.png").toString());
		down = new Image(ClassLoader.getSystemResource("player/down.png").toString());
		left = new Image(ClassLoader.getSystemResource("player/left.png").toString());
		right = new Image(ClassLoader.getSystemResource("player/right.png").toString());
		close = new Image(ClassLoader.getSystemResource("player/close.png").toString());
		grass = new Image(ClassLoader.getSystemResource("tiles/grass.png").toString());
		water = new Image(ClassLoader.getSystemResource("tiles/water.png").toString());
		sand = new Image(ClassLoader.getSystemResource("tiles/sand.png").toString());
		brick = new Image(ClassLoader.getSystemResource("tiles/brick.png").toString());
		tree = new Image(ClassLoader.getSystemResource("tiles/tree.png").toString());
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
