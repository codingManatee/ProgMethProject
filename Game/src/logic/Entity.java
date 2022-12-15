package logic;

import sharedObject.IRenderable;

<<<<<<< Updated upstream
public abstract class Entity implements IRenderable{

	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;
	
	protected Entity(){
		visible = true;
		destroyed = false;
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}

	@Override
	public int getZ(){
		return z;
	}
=======
public abstract class Entity {

	public int worldX, worldY;
	protected int z;
	protected boolean visible, destroyed;
	public Rectangle solidArea, pickRange;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public int pickRangeDefaultX, pickRangeDefaultY;
	public boolean collisionOnLeft, collisionOnRight, collisionOnTop, collisionOnBottom;

	protected Entity() {
		this.visible = true;
		this.destroyed = false;
	}

>>>>>>> Stashed changes
}
