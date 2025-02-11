package 프로그래머스.Lv1;

public class 덧칠하기 {
	public static void main(String[] args) {
		int n = 8, m = 4;
		int[] section = { 2, 3, 6 };
		System.out.println(solution(n, m, section));
	}

	static public int solution(int n, int m, int[] section) {
		int answer = 0;
		int wall = 0; // 페인트 칠해진 구역
		for (int i = 0; i < section.length; i++) {
			if (wall < section[i]) { // 칠해진 구역이 아니면 덧칠
				answer += 1;
				wall = section[i] + m - 1;
			}
		}
		return answer;
	}
}
