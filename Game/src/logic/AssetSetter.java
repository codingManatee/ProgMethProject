package logic;

import main.GamePanel;
import object.Bit;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.getSuperObject()[0] = new Bit();
		gp.getSuperObject()[0].worldX = 9 * gp.getTileSize();
		gp.getSuperObject()[0].worldY = 5 * gp.getTileSize();
		
	}
}
