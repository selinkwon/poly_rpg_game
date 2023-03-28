package poly_rpg;

import java.util.Random;

abstract class Map{
	
	public final int ROAD=0;
	public final int PLAYER = 2;
	public final int WALL=4;
	public final int PORTAL = 9;
	public final int SIZE;
	public final int TREE = 3;
	public final int FLOWER = 5;
	private String name;
	private int maxHp,hp,exp;
	public Random ran;
	
	public int[][] map;
	
	public int pY;
	public int pX;
	
	public Map(int size) {
		SIZE = size;
		this.map = new int[SIZE][SIZE];
	}
	
	public Map(String name, int maxHp, int exp, int size) {
		SIZE = size;
		this.name = name;
		this.maxHp = maxHp;
		this.hp = this.maxHp;
		this.exp = exp;
		ran = new Random();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}


}
