package 프로그래머스.Lv1;

public class 둘만의암호 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		System.out.println(solution(s, skip, index));
	}

	static public String solution(String s, String skip, int index) {
		String answer = "";
		StringBuffer alpha = new StringBuffer(); // 암호 만들 때 사용할 문자 저장
		for (int i = 0; i < 26; i++) {
			if (skip.indexOf('a' + i) < 0) { // 스킵할 문자가 아닐 때만 저장
				alpha.append((char) ('a' + i));
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int alphaIdx = alpha.indexOf(Character.toString(s.charAt(i))); // 암호 만들 때 사용할 문자들 중 현재 문자의 인덱스 찾기
			sb.append(alpha.charAt((alphaIdx + index) % alpha.length())); // index만큼 뒤에 있는 문자 출력
		}
		answer = sb.toString();
		return answer;
	}
}
