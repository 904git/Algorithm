package 프로그래머스.Lv0;

public class 두수의연산값비교하기 {
	public static void main(String[] args) {
		int a = 2, b = 91;
		System.out.println(solution(a, b));
	}

	static public int solution(int a, int b) {
		StringBuffer sb = new StringBuffer(); // a⊕b
		sb.append(a);
		sb.append(b);
		int answer = Math.max(Integer.parseInt(sb.toString()), 2 * a * b);
		return answer;
	}
}
