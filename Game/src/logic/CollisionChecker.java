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
				entity.collisionOnTop = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnBottom = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - gp.getPlayer().getSpeed())/gp.getTileSize();
			tileNum1 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
			tileNum2 = gp.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
			if (gp.getTileManager().getTile()[tileNum1].collision == true ||
					gp.getTileManager().getTile()[tileNum2].collision == true) {
				entity.collisionOnLeft = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + gp.getPlayer().getSpeed())/gp.getTileSize();
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
				entity.solidArea.setX(entity.worldX + entity.solidArea.getX());
				entity.solidArea.setY(entity.worldY + entity.solidArea.getY());
				
				// Get the object's solid area position
				gp.getSuperObject()[i].solidArea.setX(gp.getSuperObject()[i].worldX + gp.getSuperObject()[i].solidArea.getX());
				gp.getSuperObject()[i].solidArea.setY(gp.getSuperObject()[i].worldY + gp.getSuperObject()[i].solidArea.getY());
				
				switch(gp.getPlayer().getDirection()) {
				case "up" :
					entity.solidArea.setY(entity.solidArea.getY() - gp.getPlayer().getSpeed());
					if (entity.solidArea.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnTop = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.setY(entity.solidArea.getY() + gp.getPlayer().getSpeed());
					if (entity.solidArea.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnBottom = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.setX(entity.solidArea.getX() - gp.getPlayer().getSpeed());
					if (entity.solidArea.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnLeft = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.setX(entity.solidArea.getX() + gp.getPlayer().getSpeed());
					if (entity.solidArea.intersects(gp.getSuperObject()[i].solidArea.getBoundsInLocal())) {
						if (gp.getSuperObject()[i].collision == true) {
							entity.collisionOnRight = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				}
				entity.solidArea.setX(entity.solidAreaDefaultX);
				entity.solidArea.setY(entity.solidAreaDefaultY);
				gp.getSuperObject()[i].solidArea.setX(gp.getSuperObject()[i].solidAreaDefaultX);
				gp.getSuperObject()[i].solidArea.setY(gp.getSuperObject()[i].solidAreaDefaultY);
			}
		}
		
		return index;
	}
}
