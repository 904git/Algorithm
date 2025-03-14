package 프로그래머스.Lv2;

public class 큰수만들기 {
	static String max;

	public static void main(String[] args) {
		String number = "11111";
		int k = 4;
		System.out.println(solution(number, k));
	}

	static public String solution(String number, int k) {
		String answer = "";
		StringBuffer sb = new StringBuffer(number);
		int idx = 1, remove_cnt = 0;
		while (idx < sb.length() && remove_cnt < k) {
			if (sb.charAt(idx - 1) - '0' < sb.charAt(idx) - '0') { // 내 앞에 있는 숫자 나보다 작으면
				sb.deleteCharAt(idx - 1); // 앞 숫자 제거
				idx = Math.max(idx - 1, 1); // 인덱스 왼쪽으로 한칸 이동 (인덱스가 0이면 앞에 비교할 숫자가 없으므로 1까지만 이동)
				remove_cnt += 1; // 제거 횟수 증가
			} else { // 내 앞에 있는 숫자가 나보다 크면 오른쪽으로 인덱스 이동
				idx += 1;
			}
		}
		while (remove_cnt < k) { // k개 만큼 제거하지 못했는데 모두 같은 수만 남았을 때
			sb.deleteCharAt(sb.length() - 1); // 뒤에 있는 수부터 제거
			remove_cnt += 1;
		}
		answer = sb.toString();
		return answer;
	}

	static public String solution2(String number, int k) { // 메모리 초과
		String answer = "";
		String[][] DP = new String[number.length() - k + 1][number.length() + 1];
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP[i].length; j++) {
				DP[i][j] = "";
			}
		}
		for (int i = 1; i <= number.length() - k; i++) {
			for (int j = i; j <= number.length(); j++) {
				StringBuffer temp = new StringBuffer(DP[i - 1][j - 1]);
				temp.append(number.charAt(j - 1));
				if (DP[i][j - 1].compareTo(temp.toString()) < 0) {
					DP[i][j] = temp.toString();
				} else {
					DP[i][j] = DP[i][j - 1];
				}
			}
		}
		answer = DP[number.length() - k][number.length()];
		return answer;
	}

	static public String solution4(String number, int k) { // 시간 초과
		String answer = "";
		max = "";
		dfs(number, k, 0, 0);
		answer = max;
		return answer;
	}

	static public void dfs(String number, int n, int cur, int cnt) {
		if (n == cnt) {
			if (max.compareTo(number) < 0) {
				max = number;
			}
			return;
		}
		StringBuffer sb = new StringBuffer(number);
		for (int i = cur; i < number.length(); i++) {
			sb = sb.deleteCharAt(i);
			dfs(sb.toString(), n, i, cnt + 1);
			sb.insert(i, number.charAt(i));
		}
	}
}
