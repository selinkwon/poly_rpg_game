package poly_rpg;


public class Town extends Map{
	
	public Town() {
		super(10);
	}

	private final int HOME = 1;
	private final int STORE = 4;

	public void setTown() {
		super.map[super.pY][super.pX] = super.PLAYER;
		super.map[2][3] = this.HOME;
		super.map[super.SIZE - 1][super.SIZE - 1] = super.PORTAL;
		super.map[5][8] = this.STORE;
		super.map[0][8] = super.TREE;
		super.map[1][2] = super.FLOWER;
		super.map[1][5] = super.TREE;
		super.map[2][0] = super.TREE;
		super.map[2][8] = super.TREE;
		super.map[3][4] = super.TREE;
		super.map[3][7] = super.FLOWER;
		super.map[4][5] = super.FLOWER;
		super.map[4][2] = super.TREE;
		super.map[4][9] = super.TREE;
		super.map[5][1] = super.TREE;
		super.map[5][9] = super.TREE;
		super.map[6][1] = super.FLOWER;
		super.map[6][2] = super.FLOWER;
		super.map[6][8] = super.TREE;
		super.map[6][9] = super.TREE;
		super.map[7][6] = super.TREE;
		super.map[7][1] = super.TREE;
		super.map[8][4] = super.TREE;
		super.map[8][6] = super.FLOWER;
		super.map[8][7] = super.TREE;
		super.map[9][3] = super.TREE;

	}

	public void printTown() {
		for (int i = 0; i < super.SIZE; i++) {
			for (int j = 0; j < super.SIZE; j++) {
				int block = super.map[i][j];
				if (block == super.PLAYER) {
					Tool.write("🐧");
				} else if (block == super.TREE) {
					Tool.write("🌳");
				} else if (block == super.FLOWER) {
					Tool.write("🌹");
				} else if (block == this.HOME) {
					System.out.print("🛖");
				} else if (block == super.PORTAL) {
					System.out.print("🌀");
				} else if (block == this.STORE) {
					System.out.print("🏬");
				} else {
					System.out.print("➖");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void moveFromTown() {
		try {
			Tool.write("a(←)s(↓)d(→)w(↑)\n : ");
			String dir = Tool.input();
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

			if (y < 0 || y >= super.SIZE || x < 0 || x >= super.SIZE || super.map[y][x] == super.TREE) {
				System.err.println("더 이상 이동 할 수 없는 곳입니다.");
				return;
			}

			if (super.map[y][x] == super.PORTAL) {
				Tool.write("\n===================");
				Tool.write("새로운 지역으로 이동합니다.\n");
				Tool.write("===================\n");				
				GameManager.stage ++;
			}
			else if(super.map[y][x] == this.HOME) {
				Tool.write("집에 들어왔습니다.\n");
				GameManager.stage = -1;
			}
			else if(super.map[y][x] == this.STORE) {
				Tool.write("상점에 들어왔습니다.\n");
				GameManager.stage = -2;
			}

			super.map[super.pY][super.pX] = super.ROAD;
			super.pY = y;
			super.pX = x;
			super.map[super.pY][super.pX] = super.PLAYER;
		} catch (Exception e) {
		}

	}
}
