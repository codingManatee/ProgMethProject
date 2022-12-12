package logic;

import main.GamePanel;
import object.Bit;
import object.Spring;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.getSuperObject()[0] = new Bit();
		gp.getSuperObject()[0].worldX = 9 * gp.getTileSize();
		gp.getSuperObject()[0].worldY = 5 * gp.getTileSize();
		
		gp.getSuperObject()[1] = new Bit();
		gp.getSuperObject()[1].worldX = 9 * gp.getTileSize();
		gp.getSuperObject()[1].worldY = 4 * gp.getTileSize();
		
		gp.getSuperObject()[2] = new Bit();
		gp.getSuperObject()[2].worldX = 10 * gp.getTileSize();
		gp.getSuperObject()[2].worldY = 5 * gp.getTileSize();
		
		gp.getSuperObject()[3] = new Spring();
		gp.getSuperObject()[3].worldX = 5 * gp.getTileSize();
		gp.getSuperObject()[3].worldY = 10 * gp.getTileSize();
		
	}
}
