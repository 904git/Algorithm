package 프로그래머스.Lv1;

public class PCCP기출문제_1번_붕대감기 {
	public static void main(String[] args) {
		int[] bandage = { 5, 1, 5 };
		int health = 30;
		int[][] attacks = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } };
		System.out.println(solution(bandage, health, attacks));
	}

	static public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = health;
		for (int i = 0, time = 0; i < attacks.length; i++) {
			int temp = attacks[i][0] - time - 1; // 공격받을 때까지 시간
			// temp / bandage[0]만큼 보너스
			answer = Math.min(health, answer + (temp * bandage[1]) + bandage[2] * (temp / bandage[0]));
			answer -= attacks[i][1]; // 공격받음
			if (answer <= 0) { // 체력 0이하이면 종료
				return -1;
			}
			time = attacks[i][0]; // 현재 시간 변경
		}
		return answer;
	}
}
