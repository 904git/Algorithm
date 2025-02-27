package 프로그래머스.Lv3;

public class 등굣길 {
	public static void main(String[] args) {
		int m = 100, n = 100;
		int[][] puddles = {};
		System.out.println(solution(m, n, puddles));
	}

	static public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n + 1][m + 1]; // 지도 (경우의 수 기록)
		map[1][1] = 1;
		for (int i = 0; i < puddles.length; i++) { // 웅덩이 표시
			map[puddles[i][1]][puddles[i][0]] = -1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] != -1) { // 웅덩이가 아니고 길일 때
					if (0 <= map[i - 1][j]) { // 왼쪽에서 오는 경우
						map[i][j] += map[i - 1][j];
					}
					if (0 <= map[i][j - 1]) { // 위에서 오는 경우
						map[i][j] += map[i][j - 1];
					}
					map[i][j] %= 1000000007;
				}
			}
		}
		answer = map[n][m];
		return answer;
	}
}
