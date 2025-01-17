package 프로그래머스.Lv0;

public class 코드처리하기 {
	public static void main(String[] args) {
		String code = "abc1abc1abc";
		System.out.println(solution(code));
	}

	static public String solution(String code) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int idx = 0, mode = 0; idx < code.length(); idx++) {
			if (code.charAt(idx) == '1') { // code[idx]가 1이면 mode 전환
				mode = (mode + 1) % 2;
			} else {
				if (mode == 0 && idx % 2 == 0) { // mode가 0이면 idx가 짝수일 때만 추가
					sb.append(code.charAt(idx));
				} else if (mode == 1 && idx % 2 != 0) { // mode가 1이면 idx가 홀수일 때만 추가
					sb.append(code.charAt(idx));
				}
			}
		}
		if (0 < sb.length()) {
			answer = sb.toString();
		} else {
			answer = "EMPTY";
		}
		return answer;
	}
}
