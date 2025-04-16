package 프로그래머스.Lv1;

import java.util.Arrays;

public class 공원산책 {
	static int H, W; // 맵 크기
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // ESWN(우하좌상)

	public static void main(String[] args) {
		String[] park = { "SOO", "OOO", "OOO" };
		String[] routes = { "E 2", "S 2", "W 1" };
		System.out.println(Arrays.toString(solution(park, routes)));
	}

	static public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		H = park.length; // 세로 길이
		W = park[0].length(); // 가로 길이
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (park[i].charAt(j) == 'S') { // 시작 지점
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
		}
		for (int i = 0; i < routes.length; i++) {
			String[] str_split = routes[i].split(" ");
			int n = Integer.parseInt(str_split[1]); // 이동하는 칸 수
			int d = 0; // 방향 (default: 우)
			if (str_split[0].equals("S")) { // 하
				d = 1;
			} else if (str_split[0].equals("W")) { // 좌
				d = 2;
			} else if (str_split[0].equals("N")) { // 상
				d = 3;
			}
			if (isPossible(answer, d, n, park)) { // 이동하는 길에 범위를 넘어가거나 장애물이 있는지 확인
				answer[0] += di[d] * n;
				answer[1] += dj[d] * n;
			}
		}
		return answer;
	}

	static public boolean isPossible(int[] dog, int d, int n, String[] map) {
		for (int i = 1; i <= n; i++) {
			int ni = dog[0] + di[d] * i;
			int nj = dog[1] + dj[d] * i;

			if (ni < 0 || H <= ni || nj < 0 || W <= nj || map[ni].charAt(nj) == 'X') {
				// 범위를 넘어가거나 장애물이 있으면
				return false;
			}
		}
		return true;
	}
}
