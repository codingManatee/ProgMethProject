package Unit;

import Base.Blockable;

public class HammerUnit extends BaseUnit implements Blockable{
	
	public HammerUnit(int hp,int power,int def) {
		super(hp, power, def);
	}

	@Override
	public int attack(EnermyUnit unit) {
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
