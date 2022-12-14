package logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.GamePanel;
import object.Bit;
import object.Coin;
import object.Door;
import object.Fire;
import object.Key;
import object.Lever;
import object.Spring;
import object.Trap;

public class AssetSetter {
	
	ArrayList<String> fileNames = new ArrayList<>();
	ArrayList<String> positions = new ArrayList<>();
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
		// ASSETSETTER FILE READER
		InputStream is = ClassLoader.getSystemResourceAsStream("map/assetsetter.txt".toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));			
		
		String line;
		try {
			while ((line = br.readLine()) != null) {
				fileNames.add(line);
				positions.add(br.readLine());
			}
		} catch (Exception e) {
			System.out.println("AssetSetter Error");
		}
	}
	
	public void setObject() {
		for (int i = 0 ; i < fileNames.size() ; i++) {
			String[] fileName;
			
			fileName = fileNames.get(i).split(" ");
			String[] name = fileName[0].split(",");
			System.out.println(name[0]);
			//System.out.println(name[1]);
			switch(name[0]) {
			case "Bit" : gp.getSuperObject()[i] = new Bit(); break;
			case "Coin" : gp.getSuperObject()[i] = new Coin(); break;
			case "Door" : gp.getSuperObject()[i] = new Door(); break;
			case "Fire" : gp.getSuperObject()[i] = new Fire(); break;
			case "Key" : gp.getSuperObject()[i] = new Key(); break;
			case "Lever" : gp.getSuperObject()[i] = new Lever(); break;
			case "Trap" :
				gp.getSuperObject()[i] = new Trap("Trap"+name[1]); break;
			}
			
			String[] position;
			
			position = positions.get(i).split(" ");
			gp.getSuperObject()[i].worldX = Integer.parseInt(position[0]) * gp.getTileSize();
			gp.getSuperObject()[i].worldY = Integer.parseInt(position[1]) * gp.getTileSize();
		}
	}
}
