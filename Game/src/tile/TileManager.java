package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

<<<<<<< Updated upstream
public class TileManager implements IRenderable{
	
=======
public class TileManager {

>>>>>>> Stashed changes
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
<<<<<<< Updated upstream
	
=======
	ArrayList<String> fileNames = new ArrayList<>();
	ArrayList<String> collisionStatus = new ArrayList<>();

>>>>>>> Stashed changes
	public TileManager(GamePanel gp) {

		this.gp = gp;
<<<<<<< Updated upstream
		
		tile = new Tile[10];
		mapTileNum = new int[gp.getMaxScreenCol()][gp.getMaxScreenRow()];
		
		getTileImage();
		loadMap("map/map1.txt");
=======

		// CHANGE YOUR MAP NAME HERE
		this.mapName = "map/Map01.txt";

		// READ TILE DATA FILE // ALSO CHANGE WITH MAP
		InputStream is = ClassLoader.getSystemResourceAsStream("map/tiledata01.txt".toString());
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

>>>>>>> Stashed changes
	}

	public void getTileImage() {
<<<<<<< Updated upstream
		
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
=======

		for (int i = 0; i < fileNames.size(); i++) {

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

			setUp(i, fileName, collision);
		}
	}

	public void setUp(int index, String imageName, boolean collision) {
		try {
			tile[index] = new Tile();
			tile[index].image = new Image(ClassLoader.getSystemResource("tiles/" + imageName).toString());
			tile[index].collision = collision;
		} catch (Exception e) {
			System.out.println("Load Tiles Error");
		}
>>>>>>> Stashed changes
	}

	public void draw(GraphicsContext gc) {
<<<<<<< Updated upstream
		
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
=======

		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.getMaxWorldCol() && worldRow < gp.getMaxWorldRow()) {

			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * gp.getTileSize();
			int worldY = worldRow * gp.getTileSize();
			int screenX = worldX - gp.getPlayer().worldX + gp.getPlayer().screenX;
			int screenY = worldY - gp.getPlayer().worldY + gp.getPlayer().screenY;

			if (worldX + gp.getTileSize() > gp.getPlayer().worldX - gp.getPlayer().screenX
					&& worldX - gp.getTileSize() < gp.getPlayer().worldX + gp.getPlayer().screenX
					&& worldY + gp.getTileSize() > gp.getPlayer().worldY - gp.getPlayer().screenY
					&& worldY - gp.getTileSize() < gp.getPlayer().worldY + gp.getPlayer().screenY) {

				gc.drawImage(tile[tileNum].image, screenX, screenY, gp.getTileSize(), gp.getTileSize());

			}

			worldCol++;

			if (worldCol == gp.getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
>>>>>>> Stashed changes
			}
		}

	}

	public void loadMap(String map) {
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream(map.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

<<<<<<< Updated upstream
			while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()) {
	
				String line =  br.readLine();
				
				while (col < gp.getMaxScreenCol()) {
					
=======
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

				String line = br.readLine();

				while (col < gp.maxWorldCol) {
>>>>>>> Stashed changes
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);
					System.out.println(num);
					
					mapTileNum[col][row] = num;
					col++;
					
				}
<<<<<<< Updated upstream
				
				if (col == gp.getMaxScreenCol()) {
					col = 0 ;
=======

				if (col == gp.maxWorldCol) {
					col = 0;
>>>>>>> Stashed changes
					row++;
				}

			}
		} catch (Exception e) {
			System.out.println("Loadmap Error");
		}
	}

<<<<<<< Updated upstream
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
=======
	// GETTER AND SETTER
	public int[][] getMapTileNum() {
		return this.mapTileNum;
	}

	public Tile[] getTile() {
		return this.tile;
>>>>>>> Stashed changes
	}
}
