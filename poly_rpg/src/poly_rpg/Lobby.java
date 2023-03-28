package poly_rpg;

public class Lobby {
	UserManager user = new UserManager();
	
	public void printMenu() {
		System.out.println("============");
		System.out.println("회원가입");
		System.out.println("회원탈퇴");
		System.out.println("로그인");
		System.out.println("로그아웃");
		System.out.println("============");
		System.out.println("원하는 메뉴를 적어주세요.");
	}
	
	public void run() {
		while(true) {
			printMenu();
			try {
				String input=br.readLine;
				if(input.equals("회원가입")) user.join();
				else if(input.equals("회원탈퇴")) user.leave();
				else if(input.equals("로그인")) user.logIn();
				else if(input.equals("로그아웃")) user.logOut();
			} catch (Exception e) {
			}
		}
	}
}
