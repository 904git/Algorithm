package 프로그래머스.Lv0;

public class 특정한문자를대문자로바꾸기 {
	public static void main(String[] args) {
		String my_string = "programmers", alp = "p";
		System.out.println(solution(my_string, alp));
	}

	static public String solution(String my_string, String alp) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) == alp.charAt(0)) { // i번째 문자와 alp 비교
				sb.append(Character.toUpperCase(my_string.charAt(i))); // 같으면 대문자로 변환
			} else {
				sb.append(my_string.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
