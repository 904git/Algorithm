package 프로그래머스.Lv1;

public class 문자열나누기 {
	public static void main(String[] args) {
		String s = "banana";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 0;
		String temp = s; // 자를 문자열
		while (0 < temp.length()) {
			char x = temp.charAt(0); // 문자열의 첫 문자
			int cnt = 0, xCnt = 1, idx = 1; // 첫 문자와 다른 문자 수, 첫 문자와 같은 문자 수, 인덱스
			while (idx < temp.length() && cnt != xCnt) { // 인덱스가 길이보다 작고, 두 횟수가 같지 않을 때까지
				if (temp.charAt(idx) == x) { // 첫 문자와 같은 문자 카운트
					xCnt += 1;
				} else { // 첫 문자와 다른 문자 카운트
					cnt += 1;
				}
				idx += 1;
			}
			temp = temp.substring(idx); // 문자열 나누기
			answer += 1; // 분해한 문자열 개수 증가
		}
		return answer;
	}
}
