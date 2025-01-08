package 프로그래머스.Lv0;

public class 문자열섞기 {
	public static void main(String[] args) {
		String str1 = "aaaaa";
		String str2 = "bbbbb";
		System.out.println(solution(str1, str2));
	}

	static public String solution(String str1, String str2) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str1.length(); i++) {
			sb.append(str1.charAt(i));
			sb.append(str2.charAt(i));
		}
		answer = sb.toString();
		return answer;
	}
}
