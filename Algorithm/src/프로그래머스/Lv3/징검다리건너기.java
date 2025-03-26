package 프로그래머스.Lv3;

public class 징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

	static public int solution(int[] stones, int k) {
		int answer = 0;
		int left = 0, right = 200000000;
		while (left < right) {
			int mid = (left + right) / 2; // 건널 수 있는 횟수
			int cnt = 0; // 횟수 초과한 연속된 돌 개수
			for (int i = 0; i < stones.length && cnt < k; i++) { // i가 징검다리 길이보다 작고, 밟을 수 없는 연속된 돌 개수가 k개 미만일 때까지
				if (stones[i] - mid <= 0) { // mid 횟수 후 밟을 수 없는 돌 개수
					cnt += 1;
				} else { // 연속 깨짐, 횟수 초기화
					cnt = 0;
				}
			}

			if (k <= cnt) { // 연속된 돌 개수가 k개 이상이면 횟수 줄이기
				right = mid - 1;
			} else { // 연속된 돌 개수가 k개 미만이면 횟수 늘리기
				left = mid + 1;
			}
		}
		answer = left;
		return answer;
	}

	static public int solution2(int[] stones, int k) { // 시간초과
		int answer = 0;
		int min = getMinValue(stones, k); // 최저 숫자
		while (0 < min) { // 건널 수 있을 때까지 (돌 사이 간격이 k이하일 때까지)
			answer += min;
			for (int i = 0; i < stones.length; i++) {
				if (0 < stones[i]) {
					stones[i] -= min;
				}
			}
			min = getMinValue(stones, k);
		}
		return answer;
	}

	static public int getMinValue(int[] stones, int k) { // 돌에 적힌 숫자 최솟값 반환
		int zero_cnt = 0; // 연속적인 0 개수
		int min = Integer.MAX_VALUE; // 최솟값
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] == 0) {
				zero_cnt += 1;
				if (k <= zero_cnt) { // 연속적인 0 개수가 k보다 크거나 같으면 건널 수 없음
					return -1;
				}
			} else {
				min = Math.min(min, stones[i]);
				zero_cnt = 0;
			}
		}
		return min;
	}
}
