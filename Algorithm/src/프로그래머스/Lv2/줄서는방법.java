package 프로그래머스.Lv2;

import java.util.Arrays;

public class 줄서는방법 {
	static int[] array;
	static boolean[] selected;
	static int order;

	public static void main(String[] args) {
		int n = 20;
		long k = 5;
		System.out.println(Arrays.toString(solution(n, k)));
	}

	static public int[] solution(int n, long k) {
		int[] answer = new int[n]; // 순열
		long[] fact = new long[n + 1]; // 팩토리얼
		boolean[] used = new boolean[n + 1]; // 이미 자리 배치한 숫자인지 확인
		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}
		k -= 1;
		for (int i = 0; i < n; i++) {
			long order = k / fact[(n - i) - 1]; // 이번에 배치할 숫자 순서
			for (int j = 1, idx = 0; j <= n; j++) {
				if (used[j]) { // 이미 사용한 숫자이면 패스
					continue;
				}
				if (idx == order) { // 현재 숫자가 사용할 순서이면
					answer[i] = j;
					used[j] = true;
					break;
				} else {
					idx += 1;
				}
			}
			k = k % fact[(n - i) - 1]; // 남은 순서
		}
		return answer;
	}

	static public int[] solution2(int n, long k) { // 시간초과
		int[] answer = new int[n];
		array = new int[n];
		selected = new boolean[n];
		order = 0;
		perm(n, 0, k);
		answer = array;
		return answer;
	}

	static public boolean perm(int n, int cnt, long k) { // 시간초과
		if (n == cnt) {
			order += 1;
			if (order == k) {
				return true;
			}
			return false;
		}
		boolean flag = false;
		for (int i = 1; i <= n && !flag; i++) {
			if (!selected[i - 1]) {
				selected[i - 1] = true;
				array[cnt] = i;
				flag = perm(n, cnt + 1, k);
				selected[i - 1] = false;
			}

		}
		return flag;
	}
}
