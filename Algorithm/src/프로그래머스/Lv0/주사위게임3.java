package 프로그래머스.Lv0;

import java.util.Arrays;

public class 주사위게임3 {
	public static void main(String[] args) {
		int a = 2, b = 2, c = 2, d = 2;
		System.out.println(solution(a, b, c, d));
	}

	static public int solution(int a, int b, int c, int d) {
		int answer = 0;
		int[] dice = { a, b, c, d };
		Arrays.sort(dice); // 오른차순 정렬
		if (dice[0] == dice[3]) { // 모두 같음
			answer = 1111 * dice[0];
		} else if (dice[0] == dice[2]) { // 3개 같음, dice[3] 다름
			answer = (int) Math.pow((10 * dice[0] + dice[3]), 2);
		} else if (dice[1] == dice[3]) { // 3개 같음, dice[0] 다름
			answer = (int) Math.pow((10 * dice[3] + dice[0]), 2);
		} else if (dice[0] == dice[1] && dice[2] == dice[3]) { // 2개씩 같음
			answer = (dice[0] + dice[3]) * Math.abs(dice[0] - dice[3]);
		} else if (dice[0] == dice[1]) { // 2개 같고, 2개 다름
			answer = dice[2] * dice[3];
		} else if (dice[1] == dice[2]) { // 2개 같고, 2개 다름
			answer = dice[0] * dice[3];
		} else if (dice[2] == dice[3]) { // 2개 같고, 2개 다름
			answer = dice[0] * dice[1];
		} else { // 모두 다름
			answer = dice[0];
		}
		return answer;
	}

	static public int solution2(int a, int b, int c, int d) {
		int answer = 0;
		int[] dice = { a, b, c, d };
		Arrays.sort(dice); // 오른차순 정렬
		int type = 1;
		for (int i = 0; i < dice.length - 1; i++) {
			if (dice[i] != dice[i + 1]) { // 서로 다른 숫자가 몇 개 있는지
				type += 1;
			}
		}
		if (type == 4) { // 모두 다름
			answer = dice[0]; // 가장 작은 숫자
		} else if (type == 3) { // 2개 같고, 2개 서로 다름(p, q, r)
			for (int i = 0; i < dice.length - 1; i++) {
				if (dice[i] == dice[i + 1]) { // 같은 숫자 찾음
					answer = dice[(i + 2) % dice.length] * dice[(i + 3) % dice.length]; // 다른 숫자 q, r
					break;
				}
			}
		} else if (type == 2) {
			if (dice[0] == dice[1] && dice[2] == dice[3]) { // 2개씩 같음 (p, q)
				answer = (dice[0] + dice[3]) * Math.abs(dice[0] - dice[3]);
			} else { // 3개 같고, 1개 다름 (p, q)
				if (dice[0] == dice[1]) {
					answer = (int) Math.pow(10 * dice[0] + dice[3], 2);
				} else {
					answer = (int) Math.pow(10 * dice[3] + dice[0], 2);
				}
			}
		} else { // 모두 같음
			answer = 1111 * dice[0];
		}
		return answer;
	}
}
