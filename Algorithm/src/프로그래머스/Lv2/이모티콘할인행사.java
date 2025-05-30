package 프로그래머스.Lv2;

import java.util.Arrays;

public class 이모티콘할인행사 {
	static int[] sale, max;

	public static void main(String[] args) {
		int[][] users = { { 40, 10000 }, { 25, 10000 } };
		int[] emoticons = { 7000, 9000 };
		System.out.println(Arrays.toString(solution(users, emoticons)));
	}

	static public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = { 0, 0 };
		sale = new int[emoticons.length]; // 이모티콘별 할인율
		max = new int[2]; // 플러스 가입자, 판매액 최대
		perm(0, emoticons, users); // 순열 함수
		answer = max;
		return answer;
	}

	static public void perm(int cnt, int[] emoticons, int[][] users) {
		if (emoticons.length == cnt) { // 모든 이모티콘의 할인율을 정했으면
			int[] join = { 0, 0 }; // 현재 경우의 플러스 가입자와 총 판매액
			for (int i = 0; i < users.length; i++) {
				int total = 0; // i번째 고객의 판매액
				for (int j = 0; j < emoticons.length; j++) {
					if (users[i][0] <= sale[j]) { // 고객이 정한 할인율보다 높으면 구매
						total += emoticons[j] * (100 - sale[j]) / 100;
					}
				}
				if (users[i][1] <= total) { // 판매액이 기준보다 높으면 플러스 가입
					join[0] += 1;
				} else { // 아니면 구매
					join[1] += total;
				}
			}

			if (max[0] < join[0] || (max[0] == join[0] && max[1] < join[1])) { // 플러스 가입자수가 많거나, 판매액이 더 크면 갱신
				max = join;
			}
			return;
		}

		for (int i = 10; i <= 40; i += 10) { // 10, 20, 30, 40 퍼센트 할인
			sale[cnt] = i;
			perm(cnt + 1, emoticons, users);
		}
	}

}
