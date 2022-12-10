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
		mapTileNum = new int[gp.getMaxScreenCol()][gp.getMaxScreenRow()];
		
		getTileImage();
		loadMap("map/map1.txt");
	}
	
	public void getTileImage() {
		
		tile[0] = new Tile();
		tile[0].image = RenderableHolder.getInstance().grass;
		
		tile[1] = new Tile();
		tile[1].image = RenderableHolder.getInstance().brick;

		tile[2] = new Tile();
		tile[2].image = RenderableHolder.getInstance().water;
		
		tile[3] = new Tile();
		tile[3].image = RenderableHolder.getInstance().sand;
		
		tile[4] = new Tile();
		tile[4].image = RenderableHolder.getInstance().tree;
	}
	
	public void draw(GraphicsContext gc) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()) {
			
			int tileNum = mapTileNum[col][row];
			//System.out.println(tileNum);
			
			gc.drawImage(tile[tileNum].image, x, y,64,64);
			col++;
			x += gp.getTileSize();
			
			if (col == gp.getMaxScreenCol()) {
				col = 0;
				x = 0 ;
				row++;
				y += gp.getTileSize();
			}
		}
		
	}
	
	public void loadMap(String map) {
		try {
			InputStream is =  ClassLoader.getSystemResourceAsStream(map.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;

			while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()) {
	
				String line =  br.readLine();
				
				while (col < gp.getMaxScreenCol()) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					System.out.println(num);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
				
				if (col == gp.getMaxScreenCol()) {
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
