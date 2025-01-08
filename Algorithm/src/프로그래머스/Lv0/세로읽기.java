package 프로그래머스.Lv0;

public class 세로읽기 {
	public static void main(String[] args) {
		String my_string = "ihrhbakrfpndopljhygc";
		int m = 4, c = 2;
		System.out.println(solution(my_string, m, c));
	}

	static public String solution(String my_string, int m, int c) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length() / m; i++) {
			sb.append(my_string.charAt(i * m + c - 1)); // i번째 줄에서 c번째 있는 문자
		}
		answer = sb.toString();
		return answer;
	}
}
