package 프로그래머스.Lv0;

public class 수조작하기2 {
	public static void main(String[] args) {
		int[] numLog = { 0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1 };
		System.out.println(solution(numLog));
	}

	static public String solution(int[] numLog) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numLog.length - 1; i++) {
			if (numLog[i] + 1 == numLog[i + 1]) { // 수에 1을 더한 거면
				sb.append("w");
			} else if (numLog[i] - 1 == numLog[i + 1]) { // 수에 1을 뺀 거면
				sb.append("s");
			} else if (numLog[i] + 10 == numLog[i + 1]) { // 수에 10을 더한 거면
				sb.append("d");
			} else { // 수에 10을 뺀 거면
				sb.append("a");
			}
		}
		answer = sb.toString();
		return answer;
	}
}
