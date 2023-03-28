package poly_rpg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Home extends Map{
	
	public Home() {
		super(5);
	}

	private BufferedReader br;
	private final int BED = 1;
	private final int TV = 3;
	private final int DOOR = 4;
	private final int CHAIR = 6;
	private final int BOX = 7;
	
	public void setHome() {
		br = new BufferedReader(new InputStreamReader(System.in));
		super.map[super.pY][super.pX] = super.PLAYER;		
		super.map[3][0] = this.BED;
		super.map[2][4] = this.TV;
		super.map[4][4] = this.DOOR;
		super.map[1][4] = this.CHAIR;
		super.map[0][2] = this.BOX;
	}

	public void printHome() {
		for (int i = 0; i < super.SIZE; i++) {
			for (int j = 0; j < super.SIZE; j++) {
				if (super.map[i][j] == super.PLAYER) {
					System.out.print("🐧");				
				} else if (super.map[i][j] == this.BED) {
					System.out.print("🛏️");
				} else if(super.map[i][j] == this.TV){
					System.out.print("📺");
				}else if(super.map[i][j] == this.DOOR){
					System.out.print("🕳️");
				}else if(super.map[i][j] == this.CHAIR){
					System.out.print("🪑");
				}else if(super.map[i][j] == this.BOX){
					System.out.print("📦");
				}else {
					System.out.print("⌗⌗");
				}
			}
			System.out.println();
		}
		System.out.println();		
	}
	
	public void moveFromHome() {
		try {
			System.out.print("a(←)s(↓)d(→)w(↑)\n : ");
			String dir = br.readLine();
			int y = super.pY;
			int x = super.pX;
			
			if (dir.equals("a"))
				x--;
			else if (dir.equals("d"))
				x++;
			else if (dir.equals("w"))
				y--;
			else if (dir.equals("s"))
				y++;
			else {
				System.err.println("잘못된 입력입니다.");
				return;
			}
			
			if (y < 0 || y >= super.SIZE || x < 0 || x >= super.SIZE||super.map[y][x] == this.CHAIR) {
				System.err.println("더 이상 이동 할 수 없는 곳입니다.");
				return;
			}
		if(super.map[y][x] == this.DOOR) {
			GameManager.stage = 1;
		}
		else if(super.map[y][x] == this.BED) {
			recovery();
		}
		else if(super.map[y][x] == this.TV) {
			save();
		}
			
			
			super.map[super.pY][super.pX] = super.ROAD;
			super.pY = y;
			super.pX = x;
			super.map[super.pY][super.pX] = super.PLAYER;
		} catch (Exception e) {
		}

	}

	private void save() {
		System.out.println("저장되었습니다.");
	}

	private void recovery() {
//		while(HERO.getHp() < HERO.getMax()) {
//			HERO.setHp(HERO.getHp()+10);
			System.out.println("휴식중🛏️...");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
//			if(HERO.getHp()>=HERO.getMax())
//				HERO.setHp(HERO.getMax());
//			System.out.println("HP⬆️ : "+HERO.getHp());
//		}
//		System.out.println("체력을 모두 회복했다!");
	}
	
}
