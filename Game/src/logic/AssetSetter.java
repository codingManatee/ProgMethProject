package logic;

import main.GamePanel;
import object.Bit;
import object.Coin;
import object.Door;
import object.Fire;
import object.Key;
import object.Lever;
import object.Spring;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.getSuperObject()[0] = new Bit();
		gp.getSuperObject()[0].worldX = 17 * gp.getTileSize();
		gp.getSuperObject()[0].worldY = 87 * gp.getTileSize();

		gp.getSuperObject()[5] = new Coin();
		gp.getSuperObject()[5].worldX = 15 * gp.getTileSize();
		gp.getSuperObject()[5].worldY = 87 * gp.getTileSize();

		gp.getSuperObject()[1] = new Key();
		gp.getSuperObject()[1].worldX = 19 * gp.getTileSize();
		gp.getSuperObject()[1].worldY = 85 * gp.getTileSize();
		
		gp.getSuperObject()[2] = new Door();
		gp.getSuperObject()[2].worldX = 15 * gp.getTileSize();
		gp.getSuperObject()[2].worldY = 88 * gp.getTileSize();
		
		gp.getSuperObject()[4] = new Lever();
		gp.getSuperObject()[4].worldX = 19 * gp.getTileSize();
		gp.getSuperObject()[4].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[6] = new Coin();
		gp.getSuperObject()[6].worldX = 19 * gp.getTileSize();
		gp.getSuperObject()[6].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[7] = new Coin();
		gp.getSuperObject()[7].worldX = 20 * gp.getTileSize();
		gp.getSuperObject()[7].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[8] = new Coin();
		gp.getSuperObject()[8].worldX = 21 * gp.getTileSize();
		gp.getSuperObject()[8].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[9] = new Coin();
		gp.getSuperObject()[9].worldX = 22 * gp.getTileSize();
		gp.getSuperObject()[9].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[10] = new Coin();
		gp.getSuperObject()[10].worldX = 23 * gp.getTileSize();
		gp.getSuperObject()[10].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[11] = new Coin();
		gp.getSuperObject()[11].worldX = 24 * gp.getTileSize();
		gp.getSuperObject()[11].worldY = 88 * gp.getTileSize();

		gp.getSuperObject()[13] = new Fire();
		gp.getSuperObject()[13].worldX = 12 * gp.getTileSize();
		gp.getSuperObject()[13].worldY = 84 * gp.getTileSize();

		gp.getSuperObject()[14] = new Fire();
		gp.getSuperObject()[14].worldX = 12 * gp.getTileSize();
		gp.getSuperObject()[14].worldY = 91 * gp.getTileSize();

	}
}
