package poly_rpg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class UserManager{
	private Map<String, User> acc;
	private User user;
	private String log = null;
	private BufferedReader br;

	public UserManager() {
		acc = new HashMap<>();	
		br = new BufferedReader(new InputStreamReader(System.in));
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
				System.out.println("id : ");
				String id = br.readLine();
				System.out.println("pw : ");				
				String pw = br.readLine();
				System.out.println("name : ");								
				String name = br.readLine();
				
				
				if (!acc.containsKey(id)) {
					user = new User(id, pw, name);
					acc.put(id, user);
					System.out.println("회원가입 완료");
				} else {
					System.out.println("중복된 아이디입니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
	}

	public void leave() {
		System.out.println("탈퇴할 id : ");
		try {
			String id = br.readLine();
			System.out.println("pw : ");
			String pw = br.readLine();
			if (acc.containsKey(id)) {
				if (acc.get(id).getPassword().equals(pw)) {
					acc.remove(id);
					System.out.println("회원탈퇴 완료");
				}	
				else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("회원정보를 다시 확인하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logIn() {
		if(log == null) {
			try {
				System.out.println("id : ");
				String id = br.readLine();
				System.out.println("pw : ");
				String pw = br.readLine();
				
				if(acc.containsKey(id)) {
					if(acc.get(id).getPassword().equals(pw)) {
						log = id;
						System.out.println("로그인 되었습니다.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("이미 로그인 상태입니다.");
		}
	}

	public void logOut() {
		if(log != null) {
			log = null;
			System.out.println("로그아웃 되었습니다.");
		}		
		else {
			System.out.println("로그인 상태가 아닙니다.");
		}
	}
}
