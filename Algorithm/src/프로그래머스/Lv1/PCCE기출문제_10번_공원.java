package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PCCE기출문제_10번_공원 {
	static int[] di = { 0, 1, 1 }, dj = { 1, 1, 0 }; // 우, 우하, 하

	public static void main(String[] args) {
		int[] mats = { 5, 3, 2 };
		String[][] park = { { "A", "A", "-1", "B", "B", "B", "B", "-1" }, { "A", "A", "-1", "B", "B", "B", "B", "-1" },
				{ "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
				{ "D", "D", "-1", "-1", "-1", "-1", "-1", "F" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" } };
		System.out.println(solution(mats, park));
	}

	static public int solution(int[] mats, String[][] park) {
		int answer = -1; // 돗자리를 못 깔 경우
		int N = park.length, M = park[0].length;
		Arrays.sort(mats); // 돗자리 크기 정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (park[i][j].equals("-1")) { // 돗자리 깔 공간
					for (int k = mats.length - 1; 0 <= k; k--) { // 가지고 있는 돗자리 (큰 것 부터) 깔아보기
						if (N < i + mats[k] || M < j + mats[k]) { // 공간보다 돗자리가 더 크면 다음 돗자리로 넘어가기
							continue;
						}else if(mats[k] < answer) { // 다른 공간에 깐 돗자리가 더 크면 중단
							break;
						}
						boolean flag = true;
						for (int ni = i; ni < i + mats[k] && flag; ni++) {
							for (int nj = j; nj < j + mats[k] && flag; nj++) {
								if (!park[ni][nj].equals("-1")) { // 돗자리가 깔리는 지점에 다른 돗자리가 겹쳐짐
									flag = false;
									break;
								}
							}
						}
						if (flag) { // 돗자리 깔기 성공
							answer = Math.max(answer, mats[k]);
							break;
						}
					}
				}
			}
		}
		return answer;
	}

	static public int solution2(int[] mats, String[][] park) {
		int answer = -1;
		int N = park.length, M = park[0].length;
		int max_len = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (park[i][j].equals("-1")) { // 돗자리 깔 공간
					int len = 1; // 돗자리를 깔 수 있는 공간의 한 변의 길이
					Queue<int[]> queue = new LinkedList<>(); // bfs
					boolean[][] visit = new boolean[N][M];
					queue.add(new int[] { i, j });
					visit[i][j] = true;

					boolean flag = true;
					while (!queue.isEmpty() && flag) {
						int size = queue.size();
						for (int s = 0; s < size; s++) {
							int[] p = queue.poll();

							for (int d = 0; d < di.length; d++) {
								int ni = p[0] + di[d];
								int nj = p[1] + dj[d];

								if (ni < 0 || N <= ni || nj < 0 || M <= nj || !park[ni][nj].equals("-1")) {
									// 더이상 정사각형을 확장할 수 없으면
									flag = false;
									break;
								} else if (!visit[ni][nj]) {
									queue.add(new int[] { ni, nj });
									visit[ni][nj] = true;
								}
							}
						}
						if (flag) {
							len += 1;
						}
					}
					max_len = Math.max(max_len, len); // 정사각형 최대 길이
				}
			}
		}
		for (int i = 0; i < mats.length; i++) {
			if (mats[i] <= max_len && answer < mats[i]) { // 가지고 있는 돗자리 중 최대 길이보다 작거나 같은 가장 큰 값
				answer = mats[i];
			}
		}
		return answer;
	}
}
