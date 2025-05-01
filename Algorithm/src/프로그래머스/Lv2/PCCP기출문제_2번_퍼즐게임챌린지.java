package 프로그래머스.Lv2;

public class PCCP기출문제_2번_퍼즐게임챌린지 {
	public static void main(String[] args) {
		int[] diffs = { 1, 5, 3 };
		int[] times = { 2, 4, 7 };
		int limit = 30;
		System.out.println(solution(diffs, times, limit));
	}

	static public int solution(int[] diffs, int[] times, long limit) {
		int answer = Integer.MAX_VALUE;
		int left = 1, right = 100001;
		while (left < right) {
			long time = 0;
			int mid = (left + right) / 2; // 현재 숙련도
			for (int i = 0; i < diffs.length && time <= limit; i++) {
				if (diffs[i] <= mid) { // 숙련도가 더 높음
					time += times[i]; // time_cur
				} else {
					// (time_pre + time_cur) * 틀린 횟수 + time_cur
					time += ((times[i - 1] + times[i]) * (diffs[i] - mid)) + times[i];
				}
			}
			if (time <= limit) { // 제한시간 안에 풀 수 있으면
				answer = Math.min(answer, mid);
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}
}
