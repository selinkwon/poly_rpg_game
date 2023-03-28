package poly_rpg;

import java.util.ArrayList;

public class Lobby {
	private ArrayList<Player> playerList = new ArrayList<>();
	UserManager user = new UserManager();
	User player;
	
	public void printMenu() {
		Tool.write("============\n");
		Tool.write("[1]회원가입\n");
		Tool.write("[2]회원탈퇴\n");
		Tool.write("[3]로그인\n");
		Tool.write("[4]로그아웃\n");
		Tool.write("[5]게임시작\n");
		Tool.write("============\n");
		Tool.write("원하는 메뉴의 숫자를 적어주세요.\n");		
	}
	
	public void run() {
		while(true) {
			printMenu();
			try {
				String input = Tool.input();
				if(input.equals("1")) user.join();
				else if(input.equals("2")) user.leave();
				else if(input.equals("3")) user.logIn();
				else if(input.equals("4")) user.logOut();
				else if(input.equals("5")) {
					if(user.log!=null) {
						for(int i=0;i<playerList.size();i++) {
							if(playerList.get(i).getName().equals(user.log)) {
								
							}
						}
						Player player = new Player(user.getName(), 1, 200, 10, 10, 0);
						playerList.add(player);
						Tool.write(String.format("%d님 접속을 환영합니다.\n", user.getName()));
						GameManager.stage = 1;	
						break;
					}
					else {
						Tool.write("로그인 후 게임시작이 가능합니다.\n");
					}
				}
			} catch (Exception e) {
			}
		}
	}
}
