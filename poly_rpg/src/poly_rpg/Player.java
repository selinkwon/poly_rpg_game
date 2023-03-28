package poly_rpg;

import java.util.ArrayList;

public class Player extends Unit {
	
	private int power;
	private int potion;
	private int count;
	private int money;
	private String id;
	public static Inventory inven = new Inventory();
	public static Guild guild = new Guild();
	private UserManager user = new UserManager();


	public Player(String name, int level, int maxHp, int att, int def, int exp) {
		super(name, level, maxHp, att, def, exp);
		this.potion = 5;
		this.money = 0;
		this.id = user.log;
	}
	
	public Player(String id) {
		super(id);
	}
	
	public int getCount() {
		return this.count;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public static void guildMenu() {
		guild.guildMenu();
	}

	public static void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.getGuildList();
	}

	static public ArrayList<Item> getItemList() {
		return inven.getItemList();
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.getGuildList().size();
	}

	static public int getItemSize() {
		return inven.getItemList().size();
	}

	public static void changeJob() {
		guild.jobMenu();
	}
	
	public void attack(Map monster) {
		if(monster instanceof Boss) {			
			Boss boss = (Boss) monster;
			int shieldMax = boss.getShield();
			this.power = ran.nextInt(boss.getMaxHp())+1;
			if(boss.getHp()>0) {
				if(boss.getShield()>0) {
					boss.setShield(boss.getShield()-this.power);
					if(boss.getShield()<0) {
						boss.setShield(0);	
						boss.setHp(boss.getHp()-(this.power-shieldMax));
					}
				}
				else {
					boss.setHp(boss.getHp()-this.power);
				}
				System.err.printf("\n⚔️%s의 공격!⚔️\n",super.getName());
				System.err.printf("%d의 피해를 입혔다.\n",this.power);
				if(boss.getHp()<0) {	
					boss.setHp(0);
					System.err.printf("%s의 실드 : %d\n체력 : %d/%d\n",boss.getName(),boss.getShield(),boss.getHp(),boss.getMaxHp());
					System.out.printf("\n'%s'을(를) 잡았다!\n",boss.getName());
					this.count ++;
					System.out.printf("잡은 몬스터 수 : %d\n",this.count);
				}
				else {
					System.err.printf("%s의 실드 : %d\n체력 : %d/%d\n",boss.getName(),boss.getShield(),boss.getHp(),boss.getMaxHp());					
				}
			}
		}
		else {
			this.power = ran.nextInt(monster.getMaxHp())+1;
			if(monster.getHp()>0) {
				monster.setHp(monster.getHp()-this.power);
				System.err.printf("\n⚔️%s의 공격!⚔️\n",super.getName());
				System.err.printf("%d의 피해를 입혔다.\n",this.power);
				if(monster.getHp()<0) {
					monster.setHp(0);
					System.err.printf("%s의 체력 : %d/%d\n",monster.getName(),monster.getHp(),monster.getMaxHp());
					System.out.printf("\n'%s'을(를) 잡았다!\n",monster.getName());
					this.count ++;
					System.out.printf("잡은 몬스터 수 : %d\n",this.count);
				}
				else {
					System.err.printf("%s의 체력 : %d/%d\n",monster.getName(),monster.getHp(),monster.getMaxHp());					
				}
			}
		}
	}
	
	public void recovery() {
		if(super.getHp()<super.getMaxHp()) {
			if(this.potion>0) {
				super.setHp(super.getHp()+100);
				if(super.getHp()>=super.getMaxHp()) 
					super.setHp(super.getMaxHp());
				this.potion --;
				System.err.printf("🫙치유완료🫙\nHP +100\n현재 HP : %d/%d\n남은 포션 : %d\n",super.getHp(),super.getMaxHp(),this.potion);			
			}
			else {
				System.err.println("더 이상 사용할 포션이 없습니다.");
			}			
		}
		else {
			System.err.println("이미 체력이 가득 차 있습니다.");
		}
	}

	@Override
	void attack(Unit unit) {
	}
	
}