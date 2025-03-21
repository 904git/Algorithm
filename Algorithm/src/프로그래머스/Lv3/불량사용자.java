package 프로그래머스.Lv3;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
	static Set<Set<String>> banned_users_set; // 제재아이디 목록 경우의 수
	static boolean[] selected; // 선택 확인
	static String[] users; // 선택한 유저

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };
		System.out.println(solution(user_id, banned_id));
	}

	static public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		// 변수 초기화
		banned_users_set = new HashSet<>();
		selected = new boolean[user_id.length];
		users = new String[banned_id.length];
		perm(0, user_id, banned_id); // 순열
		answer = banned_users_set.size();
		return answer;
	}

	static public void perm(int cnt, String[] user_id, String[] banned_id) {
		if (cnt == banned_id.length) { // 불량 사용자 모두 선택했으면
			Set<String> banned_users = new HashSet<>(); // set
			for (int i = 0; i < users.length; i++) {
				banned_users.add(users[i]);
			}
			if (!banned_users_set.contains(banned_users)) { // 중복있는지 확인
				banned_users_set.add(banned_users);
			}
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (!selected[i] && matchPattern(user_id[i], banned_id[cnt])) { // 아직 선택되지 않았고 불량 사용자일 때
				selected[i] = true;
				users[cnt] = user_id[i];
				perm(cnt + 1, user_id, banned_id);
				selected[i] = false;
			}

		}
	}

	static public boolean matchPattern(String str, String pattern) { // 패턴 확인 함수
		if (str.length() != pattern.length()) { // 길이가 다르면 false
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (pattern.charAt(i) != '*' && str.charAt(i) != pattern.charAt(i)) { // *가 아니면서 서로 문자가 다르면 false
				return false;
			}
		}
		return true;
	}
}
