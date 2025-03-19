package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 서버증설횟수 {
	public static void main(String[] args) {
		int[] players = { 0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5 };
		int m = 3, k = 5;
		System.out.println(solution(players, m, k));
	}

	static public int solution(int[] players, int m, int k) {
		int answer = 0;
		int server = 0; // 증설된 서버의 수
		Queue<int[]> queue = new LinkedList<>(); // 서버 관리 (k시간 후 반납)
		for (int i = 0; i < players.length; i++) {
			if (!queue.isEmpty() && queue.peek()[0] == i) { // 반납할 서버 있는지 확인
				server -= queue.poll()[1]; // 반납
			}
			if (server * m + (m - 1) < players[i]) { // 서버 증설이 필요하면
				int server_cnt = players[i] / m - server; // 증설 횟수
				answer += server_cnt;
				server = players[i] / m; // 증설된 서버의 수 갱신
				queue.add(new int[] { i + k, server_cnt }); // {반납할 시간: 증설 횟수}
			}
		}
		return answer;
	}
}
