package Unit;

public class BossEnermyUnit extends EnermyUnit{

	public BossEnermyUnit(int hp, int power, int def) {
		super(hp, power, def);
		
	}

	@Override
	public int Attack(BaseUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int giveExp() {
		// TODO Auto-generated method stub
		return 20;
	}
}
