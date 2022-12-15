package logic;

import java.util.ArrayList;
import java.util.List;

import main.GamePanel;
import sharedObject.RenderableHolder;
import tile.TileManager;

public class GameLogic {
	GamePanel gp;

	public GameLogic(GamePanel gp) {
		this.gp = gp;
		gp.setUpGame();
	}

	
	public void logicUpdate() {
		gp.getPlayer().update();
	}
}
