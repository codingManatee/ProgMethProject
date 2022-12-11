package logic;

import main.GamePanel;

public class CollisionChecker {

	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + (int)(entity.solidArea.getX());
		int entityRightWorldX = entity.worldX + (int)(entity.solidArea.getX()) + (int)(entity.solidArea.getWidth());
		int entityTopWorldY =  entity.worldY + (int)(entity.solidArea.getY()) + (int)(entity.solidArea.getWidth());
		
	}
}
