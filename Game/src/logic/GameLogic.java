package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;
import tile.TileManager;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private Player player;
	
	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		player = new Player(500,500);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	public void logicUpdate() {
		player.update();
	}
}
