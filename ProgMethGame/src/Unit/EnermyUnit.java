package Unit;

public abstract class EnermyUnit {
	//Fields
	private int hp;
	private int power;
	private int def;
	private boolean dead;
	
	//Constructor
	public EnermyUnit(int hp,int power,int def) {
		setHP(hp);
		setPower(power);
		setDef(def);
	}
	public abstract int Attack(BaseUnit unit);
	public abstract int giveExp();
	public void dead() {
		giveExp();
		setDead(true);
	}
	
	//Getter and Setter
	public int getHP() {
		return this.hp;
	}
	public int getPower() {
		return this.power;
	}
	public int getDef() {
		return this.def;
	}
	public boolean isDead() {
		return this.dead;
	}
	
	public void setHP(int hp) {
		if (hp > 0) {
			this.hp = hp;
		} else {
			dead();
		}
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
}
