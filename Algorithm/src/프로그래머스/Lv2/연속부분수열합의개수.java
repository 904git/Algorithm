package 프로그래머스.Lv2;

import java.util.HashSet;

public class 연속부분수열합의개수 {
	public static void main(String[] args) {
		int[] elements = { 7, 9, 1, 1, 4 };
		System.out.println(solution(elements));

	}

	static public int solution(int[] elements) {
		int answer = 0;
		HashSet<Integer> hash = new HashSet<>(); // 부분 수열 합 저장
		int[][] sum = new int[elements.length][elements.length]; // 부분 수열 합 계산
		for (int i = 1; i < elements.length; i++) { // 길이가 1부터 n-1까지의 부분 수열 합 구하기
			for (int j = 0; j < elements.length; j++) { // j번째 인덱스부터 길이가 i인 수열의 합
				sum[i][j] = elements[j] + sum[i - 1][(j + 1) % elements.length];
				hash.add(sum[i][j]);
			}
		}
		answer = hash.size() + 1; // 모두 합했을 때의 경우(1) 더해주기
		return answer;
	}
}
