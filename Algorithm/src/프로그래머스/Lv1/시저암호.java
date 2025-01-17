package 프로그래머스.Lv1;

public class 시저암호 {
	public static void main(String[] args) {
		String s = "AB";
		int n = 1;
		System.out.println(solution(s, n));
	}

	static public String solution(String s, int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i))) { // 알파벳이면
				char ch;
				if (Character.isUpperCase(s.charAt(i))) { // 대문자면
					ch = (char) ('A' + (s.charAt(i) + n) % 'A' % 26);
				} else { // 소문자면
					ch = (char) ('a' + (s.charAt(i) + n) % 'a' % 26);
				}
				sb.append(ch);
			} else { // 알파벳이 아니면
				sb.append(s.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
