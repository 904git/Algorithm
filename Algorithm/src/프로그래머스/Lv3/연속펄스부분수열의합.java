package 프로그래머스.Lv3;

public class 연속펄스부분수열의합 {
	public static void main(String[] args) {
		int[] sequence = { 2, 3, -6, 1, 3, -1, 2, 4 };
		System.out.println(solution(sequence));
	}

	static public long solution(int[] sequence) {
		long answer = 0;
		long[][] max = new long[2][sequence.length + 1]; // 이전 값에 현재 값을 더한 것과 현재 값 비교
		for (int i = 0; i < sequence.length; i++) { // max[0]는 펄스 수열 1일 때, max[1]은 펄스 수열 -1일 때
			max[0][i + 1] = Math.max(max[1][i] + sequence[i], sequence[i]);
			max[1][i + 1] = Math.max(max[0][i] - sequence[i], -1 * sequence[i]);
			answer = Math.max(answer, Math.max(max[0][i + 1], max[1][i + 1]));
		}
		return answer;
	}
}
