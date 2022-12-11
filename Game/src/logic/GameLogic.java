package logic;

import java.util.ArrayList;
import java.util.List;

import main.GamePanel;
import sharedObject.RenderableHolder;
import tile.TileManager;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	GamePanel gp;
	
	public GameLogic(GamePanel gp) {
		this.gp = gp;
		this.gameObjectContainer = new ArrayList<Entity>();
		addNewObject(gp.player);
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate() {
		gp.player.update();
	}
}
