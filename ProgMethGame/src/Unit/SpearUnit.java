package Unit;

import Base.Blockable;
import Base.RangeAttack;

public class SpearUnit extends BaseUnit implements Blockable,RangeAttack {
	public SpearUnit(int hp,int power,int def) {
		super(hp,power,def);
	}
	
	@Override
	public int attack(EnermyUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void rangeAttack() {
		// TODO Auto-generated method stub
		
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
