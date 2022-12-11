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
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("map/worldmap1.txt");
	}
	
	public void getTileImage() {
		
		tile[0] = new Tile();
		tile[0].image = RenderableHolder.getInstance().grass;
		
		tile[1] = new Tile();
		tile[1].image = RenderableHolder.getInstance().brick;
		tile[1].collision = true;

		tile[2] = new Tile();
		tile[2].image = RenderableHolder.getInstance().water;
		tile[2].collision = true;
		
		tile[3] = new Tile();
		tile[3].image = RenderableHolder.getInstance().sand;
		
		tile[4] = new Tile();
		tile[4].image = RenderableHolder.getInstance().tree;
		tile[4].collision = true;
		
	}
	
	public void draw(GraphicsContext gc) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while (worldCol < gp.getMaxWorldCol() && worldRow < gp.getMaxWorldRow()) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.getTileSize();
			int worldY = worldRow * gp.getTileSize();
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if (worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX && 
				worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX &&
				worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY &&
				worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY) {
				
				gc.drawImage(tile[tileNum].image, screenX, screenY , gp.getTileSize() , gp.getTileSize() );
				
			}
			
			worldCol++;
			
			if (worldCol == gp.getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
			}
			System.out.println(tileNum);
			
			
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
}
