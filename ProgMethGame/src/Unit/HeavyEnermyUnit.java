package Unit;

public class HeavyEnermyUnit extends EnermyUnit{

	public HeavyEnermyUnit(int hp, int power, int def) {
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
		return 10;
	}

}
