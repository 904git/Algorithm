package 프로그래머스.Lv3;

import java.util.Arrays;

public class 숫자게임 {
	public static void main(String[] args) {
		int[] a = { 5, 1, 3, 7 };
		int[] b = { 2, 2, 6, 8 };
		System.out.println(solution(a, b));
	}

	static public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A); // 오름차순 정렬
		Arrays.sort(B); // 오름차순 정렬
		for (int ai = A.length - 1, bi = B.length - 1; 0 <= ai && 0 <= bi;) { // 큰 수부터 탐색
			if (A[ai] < B[bi]) { // B팀이 이기는 경우
				answer += 1;
				bi -= 1;
			}
			ai -= 1;
		}
		return answer;
	}
}
