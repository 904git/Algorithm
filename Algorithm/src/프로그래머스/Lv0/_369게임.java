package 프로그래머스.Lv0;

public class _369게임 {
	public static void main(String[] args) {
		int order = 29423;
		System.out.println(solution(order));
	}

	static public int solution(int order) {
		int answer = 0;
		while (order > 0) {
			if (order % 10 != 0 && (order % 10) % 3 == 0) { // 끝자리 숫자가 3, 6, 9이면
				answer += 1;
			}
			order /= 10;
		}
		return answer;
	}
}
