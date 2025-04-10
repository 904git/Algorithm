package 프로그래머스.Lv3;

import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));
	}

	static public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times); // 처리시간 오름차순
		long left = 0, right = (long) times[times.length - 1] * n; // 최대로 걸리는 시간
		while (left <= right) { // 이분탐색
			long mid = (left + right) / 2; // 걸리는 시간
			long cnt = 0; // mid 시간 동안 처리할 수 있는 인원 수
			for (int i = 0; i < times.length; i++) {
				cnt += mid / times[i];
			}

			if (n <= cnt) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
//		while (left < right) { // 이분탐색
//			long mid = (left + right) / 2; // 걸리는 시간
//			long cnt = 0; // mid 시간 동안 처리할 수 있는 인원 수
//			for (int i = 0; i < times.length; i++) {
//				cnt += mid / times[i];
//			}
//
//			if (n <= cnt) {
//				right = mid;
//			} else {
//				left = mid + 1;
//			}
//		}
//		answer = left;
		return answer;
	}
}
