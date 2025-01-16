package 프로그래머스.Lv1;

public class 크키가작은부분문자열 {
	public static void main(String[] args) {
		String t = "204";
		String p = "2";
		System.out.println(solution(t, p));
	}

	static public int solution(String t, String p) {
		int answer = 0;
		for (int i = 0; i <= t.length() - p.length(); i++) {
			String sub = t.substring(i, i + p.length()); // 길이가 p인 부분 문자열
			if (Long.parseLong(sub) <= Long.parseLong(p)) { // 부분 문자열의 크기가 p보다 작거나 같으면
				answer += 1;
			}
		}
		return answer;
	}
}
