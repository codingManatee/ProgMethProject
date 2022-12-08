package Unit;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;

public abstract class BaseUnit {
	//Fields
	private float hp;
	private	float power;
	private int stamina;
	private float def;
	private int life;
	private int exp;
	private int level;
	private int bit;
	private int nextLevelExp;
	
	//Constructor
	public BaseUnit(float hp,float power,float def) {
		setHP(hp);
		setPower(power);
		setStamina(100);
		setDef(def);
		setLevel(1);
		setNextLevelExp(100);
	}
	
	
	//Methods
	public abstract int attack(BaseUnit baseUnit);
	public void gainExp(int exp) {
		setExp(getExp()+exp);
	}
	public void checkLevelUp() { // Added Level Up in GUI
		if (getExp() >= nextLevelExp) {
		
			setExp(getExp()-nextLevelExp);
			setNextLevelExp(getNextLevelExp()+10);
		}
	}
	public void levelUp(int stat) {
		switch(stat) {
		case 1:
			setHP(getHP()+10);
			break;
		case 2:
			setPower(getPower()+5);
			break;
		case 3:
			setStamina(getStamina()+10);
			break;
		case 4:
			setDef(getDef()+5);
			break;
		}
	}
	
	
	//Getter and Setter
	public float getHP() {
		return this.hp;
	}
	public float getPower() {
		return this.power;
	}
	public float getDef() {
		return this.def;
	}
	public float getLife() {
		return this.life;
	}
	public int getExp() {
		return this.exp;
	}
	public int getLevel() {
		return this.level;
	}
	public int getBit() {
		return this.bit;
	}
	public int getNextLevelExp() {
		return this.nextLevelExp;
	}
	public int getStamina() {
		return this.stamina;
	}
	
	public void setHP(float hp) {
		this.hp = hp;
	}
	public void setPower(float power) {
		this.power = power;
	}
	public void setDef(float def) {
		this.def = def;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setBit(int bit) {
		this.bit = bit;
	}
	public void setNextLevelExp(int exp) {
		this.nextLevelExp = exp;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
}
