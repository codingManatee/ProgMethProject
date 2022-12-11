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
		int entityTopWorldY = entity.worldY + (int)(entity.solidArea.getY());
		int entityBottomWorldY = entity.worldY + (int)(entity.solidArea.getY()) + (int)(entity.solidArea.getHeight());
		
		int entityLeftCol = entityLeftWorldX/gp.getTileSize();
		int entityRightCol = entityRightWorldX/gp.getTileSize();
		int entityTopRow = entityTopWorldY/gp.getTileSize();
		int entityBottomRow = entityBottomWorldY/gp.getTileSize();
		
		int tileNum1, tileNum2;
		
		switch(gp.getPlayer().getDirection()) {
		case "up":
			entityTopRow = (entityTopWorldY - gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
}
