package 프로그래머스.Lv2;

public class n진수게임 {
	public static void main(String[] args) {
		int n = 2, t = 4, m = 2, p = 1;
		System.out.println(solution(n, t, m, p));
	}

	static public String solution(int n, int t, int m, int p) {
		String answer = "";
		StringBuffer sequence = new StringBuffer();
		StringBuffer tube = new StringBuffer();
		int num = 0;
		while (sequence.length() < m * t) { // 튜브가 t번 말할 동안 필요한 n진수 숫자
			sequence.append(numToNBase(num++, n));
		}
		for (int i = 0; i < t; i++) { // 튜브가 말하는 단어만 저장
			tube.append(sequence.charAt((p - 1) + m * i));
		}
		answer = tube.toString();
		return answer;
	}

	static public String numToNBase(int n, int b) {
		StringBuffer sb = new StringBuffer();
		if (n == 0) {
			return "0";
		}

		while (0 < n) {
			if (10 <= n % b) { // 나머지가 10 이상이면 알파벳으로 표시
				sb.insert(0, (char) ('A' + ((n % b) % 10)));
			} else {
				sb.insert(0, n % b);
			}
			n /= b;
		}
		return sb.toString();
	}
}
