package 프로그래머스.Lv0;

public class 문자열뒤집기2 {
	public static void main(String[] args) {
		String my_string = "Progra21Sremm3";
		int s = 6, e = 12;
		System.out.println(solution(my_string, s, e));

	}

	static public String solution(String my_string, int s, int e) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		sb.append(my_string.substring(s, e + 1)); // 뒤집을 문자열
		sb = sb.reverse(); // 문자열 뒤집기
		answer = my_string.substring(0, s) + sb.toString(); // 앞부분 이어주기
		if (e < my_string.length() - 1) { // 뒷부분 이어주기
			answer += my_string.substring(e + 1);
		}
		return answer;
	}
}
