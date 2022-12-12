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
			entityTopRow = (int)(entityTopWorldY - gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnTop = true;
			}
			break;
		case "down":
			entityBottomRow = (int)(entityBottomWorldY + gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnBottom = true;
			}
			break;
		case "left":
			entityLeftCol = (int)(entityLeftWorldX - gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnLeft = true;
			}
			break;
		case "right":
			entityRightCol = (int)(entityRightWorldX + gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnRight = true;
			}
			break;
		}	
	}
	
	public int checkObject(Entity entity,boolean player) {
		
		int index = 999;
		
		for (int i = 0 ; i < gp.getSuperObject().length ; i++) {
			
			if (gp.getSuperObject()[i] != null) {
				
				// Get entity's solid area position
				entity.pickRange.setX(entity.worldX + entity.pickRange.getX());
				entity.pickRange.setY(entity.worldY + entity.pickRange.getY());
				
				// Get the object's solid area position
				gp.getSuperObject()[i].solidArea.setX(gp.getSuperObject()[i].worldX + gp.getSuperObject()[i].solidArea.getX());
				gp.getSuperObject()[i].solidArea.setY(gp.getSuperObject()[i].worldY + gp.getSuperObject()[i].solidArea.getY());
				
				switch(gp.getPlayer().getDirection()) {
				case "up" :
					entity.pickRange.setY(entity.pickRange.getY() - gp.getPlayer().getSpeed());
					if (entity.pickRange.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnTop = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.pickRange.setY(entity.pickRange.getY() + gp.getPlayer().getSpeed());
					if (entity.pickRange.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnBottom = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.pickRange.setX(entity.pickRange.getX() - gp.getPlayer().getSpeed());
					if (entity.pickRange.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnLeft = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.pickRange.setX(entity.pickRange.getX() + gp.getPlayer().getSpeed());
					if (entity.pickRange.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnRight = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				}
				
				entity.pickRange.setX(entity.pickRangeDefaultX);
				entity.pickRange.setY(entity.pickRangeDefaultY);
				gp.getSuperObject()[i].solidArea.setX(gp.getSuperObject()[i].solidAreaDefaultX);
				gp.getSuperObject()[i].solidArea.setY(gp.getSuperObject()[i].solidAreaDefaultY);
			}
		}
	
		return index;
	}
}
