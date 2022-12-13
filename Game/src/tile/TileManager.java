package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	String mapName;
	int mapTileNum[][];
	ArrayList<String> fileNames = new ArrayList<>();
	ArrayList<String> collisionStatus = new ArrayList<>();
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		// CHANGE YOUR MAP NAME HERE
		this.mapName = "map/finalMap.txt";
		
		
		// READ TILE DATA FILE // ALSO CHANGE WITH MAP
		InputStream is = ClassLoader.getSystemResourceAsStream("map/tiledata.txt".toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));			
	
		
		// GETTING TILE NAMES AND COLLISION INFO FROM THE TILE
		String line;
		try {
			while ((line = br.readLine()) != null) {
				fileNames.add(line);
				collisionStatus.add(br.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		tile = new Tile[fileNames.size()];
		getTileImage();
		
		
		// GET THE maxWorldCol & maxWorldRow
		is = ClassLoader.getSystemResourceAsStream(mapName.toString());
		br = new BufferedReader(new InputStreamReader(is));
		try {
			String line2 = br.readLine();
			String maxTile[] = line2.split(" ");
			
			gp.maxWorldCol = maxTile.length;
			gp.maxWorldRow = maxTile.length;
			mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
			
			br.close();
			
		} catch (Exception e) {
			System.out.println("Read Map Error");
		}
		
		loadMap(mapName);
	
	}
	
	public void getTileImage() {
		
		for (int i = 0 ; i < fileNames.size() ; i++) {
			
			String fileName;
			boolean collision;
			
			// Get a file name
			fileName = fileNames.get(i);
			
			// Get a collision status
			if (collisionStatus.get(i).equals("true")) {
				collision = true;
			} else {
				collision = false;
			}
			
			setUp(i, fileName , collision);
		}
	}
	
	public void setUp(int index, String imageName, boolean collision) {
		try {
			tile[index] = new Tile();
			tile[index].image = new Image(ClassLoader.getSystemResource("tiles/"+imageName).toString());
			tile[index].collision = collision;
		} catch (Exception e) {
			System.out.println("Load Tiles Error");
		}
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
	
	// GETTER AND SETTER
	public int[][] getMapTileNum() {
		return this.mapTileNum;
	}
	public Tile[] getTile() {
		return this.tile;
	}
}
