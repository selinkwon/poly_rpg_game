package poly_rpg;


public class Monster extends Unit{

	private int power; 
	
	public Monster(String name, int hp, int maxHp) {
		super(name, hp, maxHp);
	}

	public void attack(Unit unit) {
		this.power = ran.nextInt(unit.getMax()/2) + 1;

		if (unit.getHp() > 0) {
			unit.setHp(unit.getHp() - this.power);
			System.err.printf("\n⚔️%s의 공격!⚔️\n",super.getName());
			System.err.printf("%d의 피해를 입혔다.\n", this.power);
			if (unit.getHp() < 0) {
				unit.setHp(0);
				System.err.printf("%s의 체력 : %d/%d\n", unit.getName(), unit.getHp(), unit.getMax());
				System.err.printf("\n%s 이(가) 죽었습니다.\n", unit.getName());
			} else {
				System.err.printf("%s의 체력 : %d/%d\n", unit.getName(), unit.getHp(), unit.getMax());
			}
		}

	}

	
}
