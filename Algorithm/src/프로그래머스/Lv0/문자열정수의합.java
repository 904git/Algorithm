package 프로그래머스.Lv0;

public class 문자열정수의합 {
	public static void main(String[] args) {
		String num_str = "123456789";
		System.out.println(solution(num_str));
	}

	static public int solution(String num_str) {
		int answer = 0;
		for (int i = 0; i < num_str.length(); i++) {
			answer += Character.getNumericValue(num_str.charAt(i)); // 숫자 더하기
		}
		return answer;
	}
}
