package Unit;

public class LightEnermyUnit extends EnermyUnit{

	public LightEnermyUnit(int hp, int power, int def) {
		super(hp, power, def);
	}

	@Override
	public int Attack(BaseUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int giveExp() {
		return 5;
	}

}
