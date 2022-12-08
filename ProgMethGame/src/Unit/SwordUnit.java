package Unit;

import Base.Blockable;
public class SwordUnit extends BaseUnit implements Blockable{
	
	
	public SwordUnit(float hp,float power,float def) {
		super(hp, power, def);
	}

	@Override
	public int attack(BaseUnit baseUnit) {
		return 0;
	}

	@Override
	public void block() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBlocking() {
		// TODO Auto-generated method stub
		return false;
	}
}
