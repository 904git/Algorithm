package 프로그래머스.Lv0;

public class A로B만들기 {
	public static void main(String[] args) {
		String before = "allpe";
		String after = "apple";
		System.out.println(solution(before, after));
	}

	static public int solution(String before, String after) {
		int answer = 1;
		int[][] alpha = new int[2][26]; // 각 문자열의 알파벳 갯수
		for (int i = 0; i < before.length(); i++) {
			alpha[0][before.charAt(i) - 'a'] += 1;
			alpha[1][after.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < alpha[0].length; i++) {
			if (alpha[0][i] != alpha[1][i]) { // 알파벳 개수가 맞지 않으면 before을 after 만들수 없다고 판단
				answer = 0;
				break;
			}
		}
		return answer;
	}
}
