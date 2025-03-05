package 프로그래머스.Lv1;

public class 숫자짝꿍 {
	public static void main(String[] args) {
		String X = "100";
		String Y = "203045";
		System.out.println(solution(X, Y));
	}

	static public String solution(String X, String Y) {
		String answer = "";
		int[] x_cnt = new int[10]; // X 문자열에 들어간 숫자들 개수
		int[] y_cnt = new int[10]; // Y 문자열에 들어간 숫자들 개수
		for (int i = 0; i < X.length(); i++) {
			x_cnt[X.charAt(i) - '0'] += 1;
		}
		for (int i = 0; i < Y.length(); i++) {
			y_cnt[Y.charAt(i) - '0'] += 1;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 9; 0 <= i; i--) { // 가장 큰 수를 만들어야 하므로 9부터
			for (int j = 0; j < Math.min(x_cnt[i], y_cnt[i]); j++) { // 공통적으로 들어간 개수만큼 추가
				sb.append(i);
			}
		}
		if (sb.length() == 0) { // 짝꿍이 존재하지 않으면 -1
			answer = "-1";
		} else if (sb.charAt(0) == '0') { // 0으로만 구성되어 있다면
			answer = "0";
		} else {
			answer = sb.toString();
		}
		return answer;
	}
}
