package poly_rpg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserManager{
	private Map<String, User> acc;
	private User user;
	public String log = null;

	public UserManager() {
		acc = new HashMap<>();	
	}
	
	public String getName() {
		return user.getName();
	}

	public void join() {
			// 확인용 출력문
			System.out.println("총 회원 수 : " + acc.size());
			
			Object[] keySet = acc.keySet().toArray();
			Arrays.sort(keySet);
			
			for (int i = 0; i < keySet.length; i++) {
				System.out.println("등록된 id : "+keySet[i]);
			}
			
			try {		
				Tool.write("id : ");				
				String id = Tool.input();
				Tool.write("pw : ");
				String pw = Tool.input();
				Tool.write("name : ");
				String name = Tool.input();
				
				
				if (!acc.containsKey(id)) {
					user = new User(id, pw, name);
					acc.put(id, user);
					Tool.write("회원가입 완료!\n");
				} else {
					Tool.write("이미 존재하는 아이디입니다.\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
	}

	public void leave() {
		try {
			Tool.write("탈퇴할 id : ");
			String id = Tool.input();
			Tool.write("pw : ");
			String pw = Tool.input();
			if (acc.containsKey(id)) {
				if (acc.get(id).getPassword().equals(pw)) {
					acc.remove(id);
					Tool.write("회원탈퇴 완료\n");
				}	
				else {
					Tool.write("비밀번호가 일치하지 않습니다.\n");
				}
			} else {
				Tool.write("존재하는 id가 없습니다.\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logIn() {
		if(log == null) {
			try {
				Tool.write("id : ");
				String id = Tool.input();
				Tool.write("pw : ");
				String pw = Tool.input();
				
				if(acc.containsKey(id)) {
					if(acc.get(id).getPassword().equals(pw)) {
						log = id;
						Tool.write("로그인 되었습니다.\n");
					}
					else {
						Tool.write("비밀번호가 일치하지 않습니다.\n");
					}
				}
				else {
					Tool.write("존재하는 id가 없습니다.\n");
				}
			} catch (Exception e) {
			}
		}
		else {
			Tool.write("이미 로그인 상태입니다.\n");
		}
	}

	public void logOut() {
		if(log != null) {
			log = null;
			Tool.write("로그아웃 되었습니다.\n");
		}		
		else {
			Tool.write("로그인 상태가 아닙니다.\n");
		}
	}
}
