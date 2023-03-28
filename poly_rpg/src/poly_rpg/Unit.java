package poly_rpg;

import java.util.Random;

abstract class Unit {
	
	private String name;
	private int hp,maxHp;
	public Random ran;
	
	
	public Unit(String name, int hp, int maxHp) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.ran = new Random();
	}


	public String getName() {
		return name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMax() {
		return maxHp;
	}
	
	abstract void attack(Unit unit);

}
