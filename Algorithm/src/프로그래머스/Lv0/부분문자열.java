package 프로그래머스.Lv0;

public class 부분문자열 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "aabcc";
		System.out.println(solution(str1, str2));
	}

	static public int solution(String str1, String str2) {
		int answer = str2.contains(str1) ? 1 : 0;
		return answer;
	}
}
