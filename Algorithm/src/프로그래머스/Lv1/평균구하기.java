package 프로그래머스.Lv1;

public class 평균구하기 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(solution(arr));
	}

	static public double solution(int[] arr) {
		double answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		answer /= arr.length;
		return answer;
	}
}
