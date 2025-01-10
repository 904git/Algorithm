package 프로그래머스.Lv0;

public class _7의개수 {
	public static void main(String[] args) {
		int[] array = { 7, 77, 17 };
		System.out.println(solution(array));
	}

	static public int solution(int[] array) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			while (num > 0) {
				if (num % 10 == 7) { // 자릿수가 7이면 개수 증가
					answer += 1;
				}
				num /= 10;
			}
		}
		return answer;
	}
}
