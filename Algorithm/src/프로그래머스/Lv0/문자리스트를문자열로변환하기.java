package 프로그래머스.Lv0;

public class 문자리스트를문자열로변환하기 {
	public static void main(String[] args) {
		String[] arr = { "a", "b", "c" };
		System.out.println(solution(arr));
	}

	static public String solution(String[] arr) {
		String answer = String.join("", arr);
		return answer;
	}
}
