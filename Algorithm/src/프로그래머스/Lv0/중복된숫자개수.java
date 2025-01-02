package 프로그래머스.Lv0;

public class 중복된숫자개수 {
	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 3, 4, 5 };
		int n = 1;
		System.out.println(solution(array, n));
	}

	static public int solution(int[] array, int n) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) { // i번째 수와 n이 같으면 카운트
				answer += 1;
			}
		}
		return answer;
	}

}
