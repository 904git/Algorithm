package 프로그래머스.Lv0;

public class 배열의평균값 {
	public static void main(String[] args) {
		int[] numberes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(solution(numberes));
	}

	static public double solution(int[] numbers) {
		double answer = 0;
		for (int i = 0; i < numbers.length; i++) { // 배열의 합 구하기
			answer += numbers[i];
		}
		answer /= numbers.length; // 배열의 길이만큼 나눠서 평균 구하기
		return answer;
	}

}
