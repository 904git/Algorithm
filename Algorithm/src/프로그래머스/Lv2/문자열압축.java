package 프로그래머스.Lv2;

public class 문자열압축 {
	public static void main(String[] args) {
		String s = "abcabcabcd";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = s.length(); // 최소 길이
		for (int i = 1; i <= s.length() / 2; i++) { // 압축할 문자열 단위는 전체 문자열 길이의 반까지
			StringBuffer sb = new StringBuffer(); // 압축한 문자열 저장
			int left = 0, right = i;
			while (left < s.length() && right < s.length()) {
				String target = s.substring(left, right); // 압축 기준 문자열
				int cnt = 1; // 압축된 횟수
				while (s.substring(right, Math.min(s.length(), right + i)).equals(target)) {
					// 다음 문자 압축 가능
					cnt += 1;
					right += i;
				}
				if (1 < cnt) { // 2번 이상 압축되면 (숫자)(압축 문자열)형태로 출력
					sb.append(cnt).append(target);
				} else { // 1번이면 그대로 출력
					sb.append(target);
				}
				left = right;
				right = left + i;
			}
			sb.append(s.substring(left)); // 길이 불충분으로 압축되지 못한 나머지 문자열
			answer = Math.min(answer, sb.length()); // 최소 길이 갱신
		}
		return answer;
	}
}
