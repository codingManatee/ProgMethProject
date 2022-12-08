package Unit;

import Base.Blockable;
import Item.Item;
import Item.Sword;

public class SwordUnit extends BaseUnit implements Blockable{
	private Item holding = new Sword();
	
	public SwordUnit(int hp,int power,int def) {
		super(hp, power, def);
	}

	@Override
	public int attack(EnermyUnit unit) {
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
