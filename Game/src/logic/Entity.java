package logic;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{

	public int worldX , worldY;
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
}
