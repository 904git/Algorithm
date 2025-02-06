package 프로그래머스.Lv2;

public class 피로도 {
	static int[] order;
	static boolean[] visit;
	static int answer;

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
		System.out.println(solution(k, dungeons));
	}

	static public int solution(int k, int[][] dungeons) {
		answer = -1;
		order = new int[dungeons.length]; // 던전 도는 순서
		visit = new boolean[dungeons.length]; // 던전 방문 확인
//		perm(dungeons.length, 0, k, dungeons);
		go(0, k, dungeons); // 탐험 시작
		return answer;
	}

	static public void go(int cnt, int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i] && dungeons[i][0] <= k) { // 처음 방문하며, 최소 필요 피로도 조건을 만족할 때
				visit[i] = true; // 방문
				go(cnt + 1, k - dungeons[i][1], dungeons);
				visit[i] = false;
			} else { // 조건을 만족하지 않으면 갯수 갱신
				answer = Math.max(answer, cnt);
			}
		}
	}

	static public void perm(int n, int cnt, int k, int[][] dungeons) { // n개 던전을 돌 수 있는 모든 경우의 수
		if (n == cnt) {
			int fatigue = k;
			int dungeonCnt = 0;
			for (int i = 0; i < order.length; i++) {
				if (dungeons[order[i]][0] <= fatigue) { // 최소 필요 피로도가 현재 피로도보다 작거나 같으면
					dungeonCnt += 1; // 던전 돌기
					fatigue -= dungeons[order[i]][1]; // 피로도 감소
				}
			}
			answer = Math.max(answer, dungeonCnt);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) { // 아직 방문 안 한 던전이면
				visit[i] = true;
				order[cnt] = i;
				perm(n, cnt + 1, k, dungeons);
				visit[i] = false;
			}
		}
	}
}
