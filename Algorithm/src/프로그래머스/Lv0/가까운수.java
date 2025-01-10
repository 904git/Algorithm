package 프로그래머스.Lv0;

public class 가까운수 {
	public static void main(String[] args) {
		int[] array = { 3, 10, 28 };
		int n = 20;
		System.out.println(solution(array, n));
	}

	static public int solution(int[] array, int n) {
		int answer = 0;
		for (int i = 0, min = Integer.MAX_VALUE; i < array.length; i++) {
			if (Math.abs(n - array[i]) < min) { // n과 크기 차이가 적은 것
				min = Math.abs(n - array[i]);
				answer = array[i];
			} else if (Math.abs(n - array[i]) == min && array[i] < answer) { // 차이가 같으면 더 작은 수를 선택
				answer = array[i];
			}
		}
		return answer;
	}
}
