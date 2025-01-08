package 프로그래머스.Lv0;

public class 등차수열의특정한항만더하기 {
	public static void main(String[] args) {
		int a = 3, d = 4;
		boolean[] included = { true, false, false, true, true };
		System.out.println(solution(a, d, included));
	}

	static public int solution(int a, int d, boolean[] included) {
		int answer = 0;
		for (int i = 0; i < included.length; i++) {
			if (included[i]) { // included[i]가 true인 경우
				answer += a + i * d; // (i+1)항 값 더하기
			}
		}
		return answer;
	}
}
