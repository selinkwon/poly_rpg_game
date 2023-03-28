package poly_rpg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Town extends Map{
	
	public Town() {
		super(10);
	}

	private BufferedReader br;
	private final int HOME = 1;
	private final int STORE = 4;


	public void setTown() {
		br = new BufferedReader(new InputStreamReader(System.in));
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
					System.out.print("🐧");
				} else if (block == super.TREE) {
					System.out.print("🌳");
				} else if (block == super.FLOWER) {
					System.out.print("🌹");
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

			if (y < 0 || y >= super.SIZE || x < 0 || x >= super.SIZE || super.map[y][x] == super.TREE) {
				System.err.println("더 이상 이동 할 수 없는 곳입니다.");
				return;
			}

			if (super.map[y][x] == super.PORTAL) {
				System.out.println("\n===================");
				System.out.println("새로운 지역으로 이동합니다.");
				System.out.println("===================\n");
				GameManager.stage ++;
			}
			else if(super.map[y][x] == this.HOME) {
				System.out.println("집에 들어왔다.");
				GameManager.stage = -1;
			}
			else if(super.map[y][x] == this.STORE) {
				System.out.println("상점에 들어왔다.");
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
