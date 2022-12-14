package logic;

import javafx.scene.shape.Rectangle;

public abstract class Entity{

	public int worldX , worldY;
	protected int z;
	protected boolean visible,destroyed;
	public Rectangle solidArea,pickRange;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public int pickRangeDefaultX, pickRangeDefaultY;
	public boolean collisionOnLeft,collisionOnRight,collisionOnTop,collisionOnBottom;
	
	protected Entity(){

	}
	
}
