package 프로그래머스.Lv0;

public class 최댓값만들기1 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		System.out.println(solution(numbers));
	}

	static public int solution(int[] numbers) {
		int answer = Integer.MIN_VALUE; // 최댓값을 구하기 위해 최소값으로 초기화
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (answer < numbers[i] * numbers[j]) { // 인덱스 순서대로 짝을 지어 곱한 후 크기 비교
					answer = numbers[i] * numbers[j];
				}
			}
		}
		return answer;
	}

}
