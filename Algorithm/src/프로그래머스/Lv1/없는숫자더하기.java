package 프로그래머스.Lv1;

public class 없는숫자더하기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
		System.out.println(solution(numbers));
	}

	static public int solution(int[] numbers) {
		int answer = 0;
		boolean[] isExist = new boolean[10]; // 숫자 i가 존재하는지 확인
		for (int i = 0; i < numbers.length; i++) {
			isExist[numbers[i]] = true;
		}
		for (int i = 0; i < isExist.length; i++) {
			if (!isExist[i]) { // 숫자 i가 존재하지 않으면 더하기
				answer += i;
			}
		}
		return answer;
	}
}
