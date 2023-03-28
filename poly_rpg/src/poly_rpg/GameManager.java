package poly_rpg;


public class GameManager {
	private Lobby lobby;
	private Forest forest;
	private Home home;
	private Town town;
	private Beach beach;
	public static int stage;
	
	public GameManager() {
		lobby = new Lobby();
		forest = new Forest();
		home = new Home();
		town = new Town();
		beach = new Beach();
		stage = 1;
	}
	private void init() {
		town.setTown();
		home.setHome();
		forest.setForest();	
		beach.setBeach();
	}
	
	
	public void run() {
		while(true) {
			init();
			lobby.run();
			if(stage == 1) {
				town.printTown();
				town.moveFromTown();				
			}
			else if(stage == 2) {
				forest.printForest();
				forest.moveFromForest();
			}
			else if(stage == -1) {
				home.printHome();
				home.moveFromHome();
			}	
			else if(stage == 3) {
				beach.printBeach();
				beach.moveFromBeach();
			}
		}
	}
}
