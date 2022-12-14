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
		
		gp.setUpGame();
		
	}

	
	public void logicUpdate() {
		gp.getPlayer().update();
	}
}
