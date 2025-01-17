package 프로그래머스.Lv0;

public class 문자열밀기 {
	public static void main(String[] args) {
		String A = "hello", B = "ohell";
		System.out.println(solution(A, B));
	}

	static public int solution(String A, String B) {
		int answer = -1;
		StringBuffer sb = new StringBuffer(A);
		for (int i = 0, cnt = 0; i < A.length(); i++, cnt++) {
			System.out.println(sb.toString() + " " + B);
			if (sb.toString().equals(B)) {
				answer = cnt;
				break;
			}
			// 오른쪽으로 밀기
			sb = new StringBuffer(sb.substring(0, sb.length() - 1));
			sb.insert(0, A.charAt(A.length() - 1 - i));
		}
		return answer;
	}
}
