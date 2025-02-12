package 프로그래머스.Lv2;

public class 롤케이크자르기 {
	public static void main(String[] args) {
		int[] topping = { 1, 2, 1, 3, 1, 4, 1, 2 };
		System.out.println(solution(topping));
	}

	static public int solution(int[] topping) {
		int answer = 0;
		boolean[] exist = new boolean[10001];
		int[] left = new int[topping.length]; // 컷팅 후 왼쪽 케이크 토핑 수
		for (int i = 0; i < topping.length; i++) { // 왼쪽 케이크 토핑 수 저장
			if (!exist[topping[i]]) {
				exist[topping[i]] = true;
				left[i] += 1;
			}
			if (0 < i) {
				left[i] += left[i - 1];
			}
		}
		exist = new boolean[10001];
		int right = 0;
		for (int i = topping.length - 1; i > 0; i--) { // 오른쪽 케이크 토핑 수와 비교
			if (!exist[topping[i]]) {
				exist[topping[i]] = true;
				right += 1;
			}
			if (left[i - 1] == right) {
				answer += 1;
			}
		}
		return answer;
	}
}
