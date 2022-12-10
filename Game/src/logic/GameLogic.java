package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private Player player;
	
	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		
		player = new Player(64,64);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate() {
		player.update();
		
	}
}
