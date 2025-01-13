package 프로그래머스.Lv0;

public class 공던지기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4 };
		int k = 2;
		System.out.println(solution(numbers, k));
	}

	static public int solution(int[] numbers, int k) {
		int idx = 0; // 던지는 사람의 인덱스
		int answer = numbers[idx]; // 던지는 사람의 번호
		for (int i = 1; i <= k; i++) {
			answer = numbers[idx]; // i번째 던진 사람
			idx = (idx + 2) % numbers.length; // 한사람 건너뛰고 던지기
		}
		return answer;
	}
}
