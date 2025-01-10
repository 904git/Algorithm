package 프로그래머스.Lv0;

public class qrcode {
	public static void main(String[] args) {
		int q = 3, r = 1;
		String code = "qjnwezgrpirldywt";
		System.out.println(solution(q, r, code));
	}

	static public String solution(int q, int r, String code) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < code.length(); i++) {
			if (i % q == r) { // 인덱스 i를 q로 나눈 나머지가 r 이면 추가
				sb.append(code.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
