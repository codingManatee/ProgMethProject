package Unit;

import Base.Blockable;

public class HammerUnit extends BaseUnit implements Blockable{
	
	public HammerUnit(float hp,float power,float def) {
		super(hp, power, def);
	}

	@Override
	public int attack(BaseUnit baseUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void block() {
		
	}

	@Override
	public boolean isBlocking() {
		// TODO Auto-generated method stub
		return false;
	}
}
