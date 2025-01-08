package 프로그래머스.Lv1;

public class 문자열내p와y의개수 {
	public static void main(String[] args) {
		String s = "pPoooyY";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		boolean answer = true;
		int[] cnt = { 0, 0 }; // p와 y 개수 카운트
		for (int i = 0; i < s.length(); i++) {
			if (Character.toLowerCase(s.charAt(i)) == 'p') {
				cnt[0] += 1;
			} else if (Character.toLowerCase(s.charAt(i)) == 'y') {
				cnt[1] += 1;
			}
		}
		if (cnt[0] != cnt[1]) { // 서로 개수가 다르면 false
			answer = false;
		}
		return answer;
	}
}
