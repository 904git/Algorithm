package 프로그래머스.Lv0;

public class 구슬을나누는경우의수 {
	static int count;

	public static void main(String[] args) {
		int balls = 3, share = 2;
		System.out.println(solution(balls, share));
	}

	static public int solution(int balls, int share) {
		int answer = 0;
		count = 0;
		comb(balls, share, 0, 0);
		answer = count;
		return answer;
	}

	// n개의 공에서 r개를 뽑는 조합 (경우의 수)
	static public void comb(int n, int r, int cur, int cnt) { // n: 공 개수, r: 골라야 할 공 개수, cur: 마지막으로 뽑은 공 번호,
																// cnt: 현재까지 뽑은 공 개수
		if (cnt == r) {
			count += 1;
			return;
		}

		for (int i = cur; i < n; i++) {
			comb(n, r, i + 1, cnt + 1);
		}
	}
}
