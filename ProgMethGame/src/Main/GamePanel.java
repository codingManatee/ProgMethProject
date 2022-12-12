package Main;

import javafx.scene.layout.Pane;

public class GamePanel extends Pane{
	
	//SCREEN SETTINGS
	final int originalTileSize = 32; // 32s32 tile
	final int scale = 2;
	
	final int tileSize = originalTileSize * scale; // 64x64 tile
	final int maxScreenCol = 10;
	final int maxScreenRow = 18;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	public GamePanel() {

	}
}
