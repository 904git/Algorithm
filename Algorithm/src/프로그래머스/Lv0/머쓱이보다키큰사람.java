package 프로그래머스.Lv0;

public class 머쓱이보다키큰사람 {
	public static void main(String[] args) {
		int[] array = { 149, 180, 192, 170 };
		int height = 167;
		System.out.println(solution(array, height));
	}

	static public int solution(int[] array, int height) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			if (height < array[i]) { // 머쓱이보다 키가 큰 사람이면
				answer += 1;
			}
		}
		return answer;
	}
}
