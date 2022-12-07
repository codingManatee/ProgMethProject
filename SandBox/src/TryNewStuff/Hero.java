package TryNewStuff;

public class Hero {
	//Fields
	private int hp;
	private int power;
	private int def;
	private int life;
	
	//Constructor
	public Hero() {
		setHP(10);
		setPower(3);
		setDef(1);
		setLife(1);
	}
	public Hero(int hp,int power,int def,int life) {
		setHP(hp);
		setPower(power);
		setDef(def);
		setLife(life);
	}
	
	//Methods
	public boolean attack(Hero hero) {
		if (power > hero.getDef()) {
			hero.setHP(hero.getHP()-(power-hero.getDef()));
			return true;
		} else {
			return false;
		}
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
	public int getLife() {
		return this.life;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public void setLife(int life) {
		this.life = life;
	}
}
