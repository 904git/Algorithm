package 프로그래머스.Lv0;

public class 암호해독 {
	public static void main(String[] args) {
		String cipher = "dfjardstddetckdaccccdegk";
		int code = 4;
		System.out.println(solution(cipher, code));
	}

	static public String solution(String cipher, int code) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = code - 1; i < cipher.length(); i += code) { // code 크기만큼 증가하면서 문자 삽입
			sb.append(cipher.charAt(i));
		}
		answer = sb.toString();
		return answer;
	}
}
