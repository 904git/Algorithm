package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 광물캐기 {
	static HashMap<String, Integer> mineral_idx; // 광물 인덱스
	static int[][] fatigue = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } }; // 피로도
	static int[] selected; // 선택된 곡괭이 종류
	static int min; // 피로도 최솟값

	public static void main(String[] args) {
		int[] picks = { 1, 3, 2 };
		String[] minerals = { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" };
		System.out.println(solution(picks, minerals));
	}

	static public int solution(int[] picks, String[] minerals) {
		int answer = Integer.MAX_VALUE;
		mineral_idx = new HashMap<String, Integer>() {
			{
				put("diamond", 0);
				put("iron", 1);
				put("stone", 2);
			}
		};
		Queue<Mine> queue = new LinkedList<>(); // bfs
		queue.add(new Mine(0, 0, picks));

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Mine m = queue.poll();

				if (m.picks[0] + m.picks[1] + m.picks[2] == 0 || minerals.length <= m.idx) {
					// 더이상 사용할 수 있는 곡괭이가 없거나 캘 수 있는 광물이 없으면 최솟값 갱신
					answer = Math.min(answer, m.fatigue);
					continue;
				}

				for (int i = 0; i < m.picks.length; i++) {
					if (0 < m.picks[i]) {
						int sum = m.fatigue; // 현재 곡괭이를 사용했을 때 발생하는 피로도
						for (int j = m.idx; j < Math.min(m.idx + 5, minerals.length); j++) {
							sum += fatigue[i][mineral_idx.get(minerals[j])];
						}
						int[] n_picks = Arrays.copyOfRange(m.picks, 0, 3);
						n_picks[i] -= 1; // 곡괭이 사용
						queue.add(new Mine(m.idx + 5, sum, n_picks));
					}
				}
			}
		}
		return answer;
	}

	static class Mine {
		int idx, fatigue; // 캐야하는 광물 인덱스, 피로도
		int[] picks; // 가진 곡괭이 개수

		Mine(int idx, int fatigue, int[] picks) {
			this.idx = idx;
			this.fatigue = fatigue;
			this.picks = picks;
		}
	}

	static public int solution2(int[] picks, String[] minerals) {
		int answer = 0;
		min = Integer.MAX_VALUE;
		mineral_idx = new HashMap<String, Integer>() {
			{
				put("diamond", 0);
				put("iron", 1);
				put("stone", 2);
			}
		};
		int cnt = 0;
		for (int i = 0; i < picks.length; i++) {
			cnt += picks[i];
		}
		// 사용할 곡괭이 개수
		selected = new int[Math.min(cnt, minerals.length % 5 > 0 ? minerals.length / 5 + 1 : minerals.length / 5)];
		perm(0, picks, minerals); // 곡괭이 사용 순서 지정
		answer = min;
		return answer;
	}

	static public void perm(int cnt, int[] picks, String[] minerals) {
		if (cnt == selected.length) { // 곡괭이 순서 선택 완료
			int temp = 0; // 피로도
			for (int i = 0, idx = 0; i < selected.length; i++) {
				for (int j = idx; j < Math.min(idx + 5, minerals.length); j++) {
					temp += fatigue[selected[i]][mineral_idx.get(minerals[j])];
				}
				idx += 5;
			}
			min = Math.min(min, temp); // 피로도 최솟값
			return;
		}

		for (int i = 0; i < picks.length; i++) {
			if (0 < picks[i]) { // 현재 곡괭이 선택 가능
				selected[cnt] = i;
				picks[i] -= 1;
				perm(cnt + 1, picks, minerals);
				picks[i] += 1;
			}
		}
	}
}
