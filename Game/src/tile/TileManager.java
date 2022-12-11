package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class TileManager implements IRenderable{
	
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[20];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("map/map1.txt");
	}
	
	public void getTileImage() {
		
		tile[0] = new Tile();
		tile[0].image = RenderableHolder.getInstance().blank;
		
		tile[1] = new Tile();
		tile[1].image = RenderableHolder.getInstance().xblank;
		tile[1].collision = true;
		
		tile[2] = new Tile();
		tile[2].image = RenderableHolder.getInstance().topLeft;
		tile[2].collision = true;
		
		tile[3] = new Tile();
		tile[3].image = RenderableHolder.getInstance().topCenter;
		tile[3].collision = true;
		
		tile[4] = new Tile();
		tile[4].image = RenderableHolder.getInstance().topRight;
		tile[4].collision = true;
		
		tile[5] = new Tile();
		tile[5].image = RenderableHolder.getInstance().centerLeft;
		tile[5].collision = true;
		
		tile[6] = new Tile();
		tile[6].image = RenderableHolder.getInstance().center;
		tile[6].collision = true;
		
		tile[7] = new Tile();
		tile[7].image = RenderableHolder.getInstance().centerRight;
		tile[7].collision = true;
		
		tile[8] = new Tile();
		tile[8].image = RenderableHolder.getInstance().bottomLeft;
		tile[8].collision = true;
		
		tile[9] = new Tile();
		tile[9].image = RenderableHolder.getInstance().bottomCenter;
		tile[9].collision = true;
		
		tile[10] = new Tile();
		tile[10].image = RenderableHolder.getInstance().bottomRight;
		tile[10].collision = true;
		
		tile[11] = new Tile();
		tile[11].image = RenderableHolder.getInstance().left;
		tile[11].collision = true;
		
		tile[12] = new Tile();
		tile[12].image = RenderableHolder.getInstance().middle;
		tile[12].collision = true;
		
		tile[13] = new Tile();
		tile[13].image = RenderableHolder.getInstance().right;
		tile[13].collision = true;
		
	}
	
	public void draw(GraphicsContext gc) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while (worldCol < gp.getMaxWorldCol() && worldRow < gp.getMaxWorldRow()) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.getTileSize();
			int worldY = worldRow * gp.getTileSize();
			int screenX = worldX - gp.getPlayer().worldX + gp.getPlayer().screenX;
			int screenY = worldY - gp.getPlayer().worldY + gp.getPlayer().screenY;
			
			if (worldX + gp.getTileSize() > gp.getPlayer().worldX - gp.getPlayer().screenX && 
				worldX - gp.getTileSize() < gp.getPlayer().worldX + gp.getPlayer().screenX &&
				worldY + gp.getTileSize() > gp.getPlayer().worldY - gp.getPlayer().screenY &&
				worldY - gp.getTileSize() < gp.getPlayer().worldY + gp.getPlayer().screenY) {
				
				gc.drawImage(tile[tileNum].image, screenX, screenY , gp.getTileSize() , gp.getTileSize() );
				
			}
			
			worldCol++;
			
			if (worldCol == gp.getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
			}
			//System.out.println(tileNum);
			
			
		}
		
	}
	
	public void loadMap(String map) {
		try {
			InputStream is =  ClassLoader.getSystemResourceAsStream(map.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;

			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
	
				String line =  br.readLine();
				
				while (col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				
				if (col == gp.maxWorldCol) {
					col = 0 ;
					row++;
				}
				
			}
		} catch (Exception e) {
			System.out.println("Loadmap Error");
		}
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// GETTER AND SETTER
	public int[][] getMapTileNum() {
		return this.mapTileNum;
	}
	public Tile[] getTile() {
		return this.tile;
	}
}
