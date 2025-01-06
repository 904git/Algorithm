package 프로그래머스.Lv0;

public class 최댓값만들기2 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, -3, 4, -5 };
		System.out.println(solution(numbers));
	}

	static public int solution(int[] numbers) {
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (answer < numbers[i] * numbers[j]) { // 두 수의 곱의 최댓값 구하기
					answer = numbers[i] * numbers[j];
				}
			}
		}
		return answer;
	}
}
