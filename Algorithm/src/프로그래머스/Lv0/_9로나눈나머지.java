package 프로그래머스.Lv0;

public class _9로나눈나머지 {
	public static void main(String[] args) {
		String number = "123";
		System.out.println(solution(number));
	}

	static public int solution(String number) {
		int answer = 0;
		for (int i = 0; i < number.length(); i++) { // 각 자리 숫자의 합
			answer += Character.getNumericValue(number.charAt(i));
		}
		answer %= 9;
		return answer;
	}
}
