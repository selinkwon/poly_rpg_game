package poly_rpg;

abstract class Map {
	
	public final int ROAD=0;
	public final int PLAYER = 2;
	public final int WALL=4;
	public final int PORTAL = 9;
	public final int SIZE;
	public final int TREE = 3;
	public final int FLOWER = 5;
	
	public int[][] map;
	
	public int pY;
	public int pX;
	
	public Map(int size) {
		SIZE = size;
		this.map = new int[SIZE][SIZE];
	}
	
	

}
