package 프로그래머스.Lv0;

public class 대문자와소문자 {
	public static void main(String[] args) {
		String my_string = "cccCCC";
		System.out.println(solution(my_string));
	}

	static public String solution(String my_string) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			if (Character.isUpperCase(my_string.charAt(i))) { // 대문자이면
				sb.append(Character.toLowerCase(my_string.charAt(i)));
			} else { // 소문자이면
				sb.append(Character.toUpperCase(my_string.charAt(i)));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
