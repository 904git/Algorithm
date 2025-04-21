package 프로그래머스.Lv3;

public class 가장긴팰린드롬 {
	static int max;

	public static void main(String[] args) {
		String s = "abacde";
		System.out.println(solution(s));
	}

	static public int solution(String s) { // 마나커 알고리즘
		int answer = 0;
		StringBuffer sb = new StringBuffer("#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i)).append("#");
		}
		int[] dp = new int[sb.length()];
		int mid_idx = 0, last_idx = 0;

		for (int i = 0; i < sb.length(); i++) {
			int len = 0; // i번째 기준으로 대칭 문자열 반지름 길이
			if (i <= last_idx) { // 최소 보장 길이
				len = Math.min(dp[mid_idx - (i - mid_idx)], last_idx - i);
			}

			// 대칭 탐색
			int left = i - len - 1;
			int right = i + len + 1;

			while (0 <= left && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
				// 범위를 넘어가지 않으면서 양쪽으로 문자가 같으면
				left -= 1;
				right += 1;
				len += 1;
			}
			dp[i] = len;

			if (last_idx < i + len) {
				mid_idx = i;
				last_idx = i + len;
			}
		}

		for (int i = 0; i < dp.length; i++) { // 최댓값 찾기
			answer = Math.max(answer, dp[i]);
		}
		return answer;
	}

	static public int solution2(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			answer = Math.max(answer, palindrome(s, i - 1, i + 1) + 1); // i번째 문자를 기준으로 팰리드롬 확인 (홀수 길이)
			answer = Math.max(answer, palindrome(s, i, i + 1)); // i번째 문자를 기준으로 팰리드롬 확인 (짝수 길이)
		}
		return answer;
	}

	static public int palindrome(String s, int start, int end) { // 팰린드롬 길이
		int len = 0;
		while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start -= 1;
			end += 1;
			len += 2;
		}
		return len;
	}
}
