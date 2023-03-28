package poly_rpg;

public class Beach extends Map{

	public Beach() {
		super(10);
		super.pX = 1;
	}

	private final int BACKPORTAL = 8;
	
	public void setBeach() {
		super.map[pY][pX] = super.PLAYER;
		super.map[0][0] = this.BACKPORTAL;
		super.map[0][8] = super.WALL;
		super.map[3][2] = super.WALL;
		super.map[5][0] = super.WALL;
		super.map[6][7] = super.WALL;
		super.map[9][4] = super.WALL;
		super.map[0][7] = super.FLOWER;
		super.map[1][3] = super.FLOWER;
		super.map[2][3] = super.FLOWER;
		super.map[2][2] = super.FLOWER;
		super.map[4][7] = super.FLOWER;
		super.map[4][8] = super.FLOWER;
		super.map[7][1] = super.FLOWER;
		super.map[7][2] = super.FLOWER;
		super.map[8][5] = super.FLOWER;
		super.map[8][2] = super.FLOWER;
		super.map[9][3] = super.FLOWER;
		super.map[9][5] = super.FLOWER;
		super.map[1][4] = super.TREE;
		super.map[2][6] = super.TREE;
		super.map[2][7] = super.TREE;
		super.map[3][7] = super.TREE;
		super.map[5][3] = super.TREE;
		super.map[5][4] = super.TREE;
		super.map[6][8] = super.TREE;
		super.map[7][8] = super.TREE;
		super.map[9][9] = super.PORTAL;
	}
	
	public void printBeach() {
		for (int i = 0; i < super.SIZE; i++) {
			for (int j = 0; j < super.SIZE; j++) {
				if (super.map[i][j] == super.PLAYER) {
					Tool.write("🐧 ");
				} else if (super.map[i][j] == super.TREE) {
					Tool.write("🪸 ");
				} else if (super.map[i][j] == super.WALL) {
					Tool.write("🐚 ");
				}else if (super.map[i][j] == super.FLOWER) {
					Tool.write("🌿 ");
				}else if (super.map[i][j] == super.PORTAL) {
					Tool.write("🌀");
				} else if (super.map[i][j] == this.BACKPORTAL) {
					Tool.write("🌀 ");
				} else {
					Tool.write("৹º ");
				}
			}
			System.out.println();
		}
		System.out.println();		
	}
	

	public void moveFromBeach() {
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
			
			if (y < 0 || y >= super.SIZE || x < 0 || x >= super.SIZE || super.map[y][x] == this.TREE || super.map[y][x] == super.WALL) {
				System.err.println("더 이상 이동 할 수 없는 곳입니다.");
				return;
			}
			if (super.map[y][x] == super.PORTAL) {
				Tool.write("\n===================");
				Tool.write("새로운 지역으로 이동합니다.\n");
				Tool.write("===================\n");
				GameManager.stage ++;
			}else if (super.map[y][x] == this.BACKPORTAL) {
				Tool.write("\n===================");
				Tool.write("이전 지역으로 이동합니다.\n");
				Tool.write("===================\n");
				GameManager.stage --;
			}
			
			super.map[super.pY][super.pX] = super.ROAD;
			super.pY = y;
			super.pX = x;
			super.map[super.pY][super.pX] = super.PLAYER;
		} catch (Exception e) {
		}		
	}
}
