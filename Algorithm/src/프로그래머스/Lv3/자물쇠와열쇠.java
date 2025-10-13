package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.List;

public class 자물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	static public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
		int N = lock.length, M = key.length;
		List<int[]> lock_point = new ArrayList<int[]>(); // 홈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] == 0) {
					lock_point.add(new int[] { i, j });
				}
			}
		}
		if (0 < lock_point.size()) {
			answer = false;
			List<int[]> key_point = new ArrayList<int[]>(); // 돌기
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					if (key[i][j] == 1) {
						key_point.add(new int[] { i, j });
					}
				}
			}
			
			for (int d = 0; d < 4; d++) { // 회전
				for (int i = 0; i < lock_point.size(); i++) {
					int[] lp = lock_point.get(i); // 자물쇠 기준점
					for (int j = 0; j < key_point.size(); j++) {
						int[] kp = key_point.get(j); // 열쇠 기준점
						int deltaI = lp[0] - kp[0], deltaJ = lp[1] - kp[1]; // 이동 거리
						int count = 0;
						for (int k = 0; k < key_point.size(); k++) {
							int[] p = key_point.get(k);
							int ni = p[0] + deltaI, nj = p[1] + deltaJ;
							if (0 <= ni && ni < N && 0 <= nj && nj < N) {
								if (lock[ni][nj] + 1 != 1) {
									break;
								}
								count += 1;
							}
						}
						if (count == lock_point.size()) {
							return true;
						}
					}
				}
				key_point = rotate(M, key_point);
			}
		}
		return answer;
    }
    
    static public List<int[]> rotate(int n, List<int[]> list) { // 오른쪽으로 90도 회전
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int[] p = list.get(i);
			result.add(new int[] { p[1], n - 1 - p[0] });
		}
		return result;
	}
}
