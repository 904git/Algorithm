package 프로그래머스.Lv2;

import java.util.HashSet;

public class 비밀코드해독 {
	static int[] select;
	static int answer;

	public static void main(String[] args) {
		int n = 10;
		int[][] q = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 3, 7, 8, 9, 10 }, { 2, 5, 7, 9, 10 },
				{ 3, 4, 5, 6, 7 } };
		int[] ans = { 2, 3, 4, 3, 3 };
		System.out.println(solution(n, q, ans));
	}

	static public int solution(int n, int[][] q, int[] ans) {
		answer = 0;
		select = new int[5];
		comb(0, 1, n, q, ans);
		return answer;
	}

	static public void comb(int cnt, int cur, int n, int[][] q, int[] ans) { // 1~n까지 수로 만들 수 있는 숫자 5개 조합
		if (cnt == 5) {
			if (check(q, ans)) {
				answer += 1;
			}
			return;
		}

		for (int i = cur; i <= n; i++) {
			select[cnt] = i;
			comb(cnt + 1, i + 1, n, q, ans);
		}
	}

	static public boolean check(int[][] q, int[] ans) { // 암호분석도구를 모두 통과하는지 확인
		HashSet<Integer> hash = new HashSet<>();
		for (int j = 0; j < select.length; j++) {
			hash.add(select[j]);
		}
		for (int i = 0; i < ans.length; i++) {
			int cnt = 0;
			for (int j = 0; j < q[i].length; j++) {
				if (hash.contains(q[i][j])) {
					cnt += 1;
				}
			}
			if (ans[i] != cnt) {
				return false;
			}
		}
		return true;
	}
}
