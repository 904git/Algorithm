package 프로그래머스.Lv0;

public class 한번만등장한문자 {
	public static void main(String[] args) {
		String s = "abcabcadc";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) { // s에 있는 알파벳 수 카운트
			alpha[s.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == 1) { // 한번만 등장하면 삽입
				sb.append((char) ('a' + i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
