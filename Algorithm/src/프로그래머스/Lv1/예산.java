package 프로그래머스.Lv1;

import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		int[] d = { 1, 3, 2, 5, 4 };
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	static public int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d); // 오른차순 정렬
		for (int i = 0, sum = 0; i < d.length; i++) {
			if (sum + d[i] <= budget) { // 현재 부서를 지원했을 때 예산을 넘지 않으면 지원해주기
				answer += 1;
				sum += d[i];
			}
		}
		return answer;
	}
}
