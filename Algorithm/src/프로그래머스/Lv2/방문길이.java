package 프로그래머스.Lv2;

public class 방문길이 {
	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 }; // 4방향 탐색 (상우하좌)

	public static void main(String[] args) {
		String dirs = "URULDD";
		System.out.println(solution(dirs));
	}

	static public int solution(String dirs) {
		int answer = 0;
		int[] point = { 5, 5 };
		boolean[][][] map = new boolean[11][11][4]; // 걸은 길 확인
		for (int i = 0, d = 0; i < dirs.length(); i++) {
			if (dirs.charAt(i) == 'U') { // 상
				d = 0;
			} else if (dirs.charAt(i) == 'R') { // 우
				d = 1;
			} else if (dirs.charAt(i) == 'D') { // 하
				d = 2;
			} else { // L 좌
				d = 3;
			}
			int ni = point[0] + di[d];
			int nj = point[1] + dj[d];

			if (0 <= ni && ni < map.length && 0 <= nj && nj < map.length) {
				if (!map[ni][nj][d]) { // 처음 걸어본 길이면
					answer += 1;
					map[ni][nj][d] = true; // 도착 좌표로 가는 방향
					map[point[0]][point[1]][(d + 2) % 4] = true; // 출발 좌표로 가는 방향
				}
				// 좌표가 범위 안에 있으면 이동
				point[0] = ni;
				point[1] = nj;
			}
		}
		return answer;
	}
}
