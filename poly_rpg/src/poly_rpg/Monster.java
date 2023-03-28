package poly_rpg;

import java.util.ArrayList;

public class Monster extends Map{
	private ArrayList<Monster> monsterList = new ArrayList<>();
	private int power; 
	private int mY;
	private int mX;
	private final int MONSTER = -5;
	private int count = 4;
	
	public Monster(String name, int hp, int maxHp) {
		super(name, hp, maxHp,10);
	}

	public void setMonster() {
		while (count > 0) {
			mY = ran.nextInt(super.SIZE);
			mX = ran.nextInt(super.SIZE);
			if (super.map[mY][mX] == super.ROAD) {
				Monster monster = new Monster("생쥐", 100, 100);
				monsterList.add(monster);
				map[mY][mX] = MONSTER;
				count--;
			}
		}
		if(super.map[mY][mX] == MONSTER) {
			Tool.write("🐀");
		}
	}

	public void attack(Unit unit) {
		this.power = ran.nextInt(unit.getMaxHp()/2) + 1;

		if (unit.getHp() > 0) {
			unit.setHp(unit.getHp() - this.power);
			System.err.printf("\n⚔️%s의 공격!⚔️\n",super.getName());
			System.err.printf("%d의 피해를 입혔다.\n", this.power);
			if (unit.getHp() < 0) {
				unit.setHp(0);
				System.err.printf("%s의 체력 : %d/%d\n", unit.getName(), unit.getHp(), unit.getMaxHp());
				System.err.printf("\n%s 이(가) 죽었습니다.\n", unit.getName());
			} else {
				System.err.printf("%s의 체력 : %d/%d\n", unit.getName(), unit.getHp(), unit.getMaxHp());
			}
		}

	}

	
}
