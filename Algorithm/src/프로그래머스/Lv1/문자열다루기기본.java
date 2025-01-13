package 프로그래머스.Lv1;

public class 문자열다루기기본 {
	public static void main(String[] args) {
		String s = "a234";
		System.out.println(solution(s));
	}

	static public boolean solution(String s) {
		boolean answer = true;
		if (s.length() != 4 && s.length() != 6) { // 길이가 4 혹은 6이 아니면 false
			answer = false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isAlphabetic(s.charAt(i))) { // 알파벳이 하나라도 나오면 false
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
}
