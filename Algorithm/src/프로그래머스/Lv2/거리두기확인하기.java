package 프로그래머스.Lv2;

import java.util.Arrays;

public class 거리두기확인하기 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상 4방향
//	static int[] di = { 0, 1, 1, 1, 0, -1, -1, -1 }, dj = { 1, 1, 0, -1, -1, -1, 0, 1 }; // 8방향 확인 (오른쪽부터 시계방향)

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(places)));
	}

	static public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			answer[i] = isComplete(places[i]); // 거리두기 확인
		}
		return answer;
	}

	static public int isComplete(String[] place) { // 거리두기 확인
		boolean[][] visit = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i].charAt(j) == 'P') { // 응시자가 있으면
					for (int d = 0; d < di.length; d++) { // 4방향
						int ni = i + di[d];
						int nj = j + dj[d];

						if (0 <= ni && ni < 5 && 0 <= nj && nj < 5) { // 범위 확인
							if (place[ni].charAt(nj) == 'X') {
								continue;
							} else if (place[ni].charAt(nj) == 'P' || visit[ni][nj]) { // 상하좌우에 응시자가 있거나,
																						// 다른 응시자가 확인한 테이블이 존재하면
								return 0;
							} else {
								visit[ni][nj] = true;
							}

						}
					}
					visit[i][j] = true;
				}
			}
		}
		return 1;
	}

	static public int isComplete2(String[] place) { // 거리두기 확인
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i].charAt(j) == 'P') { // 응시자가 있으면
					for (int d = 0; d < di.length; d++) { // 거리 1 8방향
						int ni = i + di[d];
						int nj = j + dj[d];

						if (0 <= ni && ni < 5 && 0 <= nj && nj < 5) { // 범위 확인
							if (place[ni].charAt(nj) == 'P') {
								if (d % 2 == 0) { // 상하좌우에 응시자 있음 (거리두기 실패)
									return 0;
								} else { // 대각선에 응시자 있음
									// 응시자 사이에 파티션 확인
									int prev = d - 1 < 0 ? di.length - 1 : d - 1;
									int next = di.length <= d + 1 ? 0 : d + 1;
									if (place[i + di[prev]].charAt(j + dj[prev]) != 'X'
											|| place[i + di[next]].charAt(j + dj[next]) != 'X') { // 거리두기 실패
										return 0;
									}
								}
							}
						}
					}
					for (int d = 0; d < di.length; d += 2) { // 거리 2 4방향
						int ni = i + di[d] * 2;
						int nj = j + dj[d] * 2;

						if (0 <= ni && ni < 5 && 0 <= nj && nj < 5 && place[ni].charAt(nj) == 'P'
								&& place[i + di[d]].charAt(j + dj[d]) != 'X') { // 응시자 사이에 파티션 확인
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}
}
