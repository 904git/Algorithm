package 프로그래머스.Lv0;

import java.util.HashMap;

public class 로그인성공 {
	public static void main(String[] args) {
		String[] id_pw = { "meosseugi", "1234" };
		String[][] db = { { "rardss", "123" }, { "yyoom", "1234" }, { "meosseugi", "1234" } };
		System.out.println(solution(id_pw, db));
	}

	static public String solution(String[] id_pw, String[][] db) {
		String answer = "";
		HashMap<String, String> id_pw_db = new HashMap<>(); // db dict
		for (int i = 0; i < db.length; i++) {
			id_pw_db.put(db[i][0], db[i][1]);
		}

		if (!id_pw_db.containsKey(id_pw[0])) {// 아이디가 일치하는 회원이 없다면
			answer = "fail";
		} else if (!id_pw_db.get(id_pw[0]).equals(id_pw[1])) { // 아이디는 있지만 비밀번호가 일치하지 않으면
			answer = "wrong pw";
		} else { // 아이디와 비밀번호가 모두 일치하면
			answer = "login";
		}
		return answer;
	}
}
