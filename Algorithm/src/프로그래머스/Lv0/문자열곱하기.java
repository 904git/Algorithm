package 프로그래머스.Lv0;

public class 문자열곱하기 {
	public static void main(String[] args) {
		String my_string = "string";
		int k = 3;
		System.out.println(solution(my_string, k));
	}

	static public String solution(String my_string, int k) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < k; i++) {
			sb.append(my_string);
		}
		answer = sb.toString();
		return answer;
	}
}
