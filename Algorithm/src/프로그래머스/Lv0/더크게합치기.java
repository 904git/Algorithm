package 프로그래머스.Lv0;

public class 더크게합치기 {
	public static void main(String[] args) {
		int a = 9, b = 91;
		System.out.println(solution(a, b));
	}

	static public int solution(int a, int b) {
		int answer = 0;
		String ab = Integer.toString(a) + Integer.toString(b); // a⊕b
		String ba = Integer.toString(b) + Integer.toString(a); // b⊕a
		answer = Math.max(Integer.parseInt(ab), Integer.parseInt(ba));
		return answer;
	}

}
