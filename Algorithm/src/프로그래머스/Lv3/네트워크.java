package 프로그래머스.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	static public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visit = new boolean[n]; // 연결 확인
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < computers.length; i++) {
			if (!visit[i]) { // 아직 연결 안 된 컴퓨터면
				answer += 1; // 네트워크 추가
				queue.add(i);
				visit[i] = true;
				while (!queue.isEmpty()) { // 연결된 게 더 없을 때까지
					int c = queue.poll();
					for (int j = 0; j < computers[c].length; j++) {
						if (!visit[j] && computers[c][j] == 1) { // 아직 연결 안 한 컴퓨터이면서 c와 j가 연결되어 있으면
							visit[j] = true;
							queue.add(j);
						}
					}
				}
			}
		}
		return answer;
	}
}
