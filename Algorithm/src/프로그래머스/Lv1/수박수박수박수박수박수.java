package 프로그래머스.Lv1;

public class 수박수박수박수박수박수 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(n));
	}

	static public String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		String subak = "수박";
		for (int i = 0; i < n; i++) {
			sb.append(subak.charAt(i % 2));
		}
		answer = sb.toString();
		return answer;
	}
}
