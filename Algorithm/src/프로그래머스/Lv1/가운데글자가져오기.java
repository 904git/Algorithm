package 프로그래머스.Lv1;

public class 가운데글자가져오기 {
	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		if (s.length() % 2 != 0) { // 길이가 홀수
			answer = s.substring(s.length() / 2, s.length() / 2 + 1);
		} else { // 길이가 짝수
			answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		}
		return answer;
	}
}
