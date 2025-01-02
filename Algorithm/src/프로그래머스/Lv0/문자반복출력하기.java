package 프로그래머스.Lv0;

public class 문자반복출력하기 {
	public static void main(String[] args) {
		String my_string = "hello";
		int n = 3;
		System.out.println(solution(my_string, n));
	}

	static public String solution(String my_string, int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			char c = my_string.charAt(i);
			for (int j = 0; j < n; j++) { // i번째 문자를 n번 추가
				sb.append(c);
			}
		}
		answer = sb.toString();
		return answer;
	}

}
