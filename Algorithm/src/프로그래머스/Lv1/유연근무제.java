package 프로그래머스.Lv1;

public class 유연근무제 {
	public static void main(String[] args) {
		int[] schedules = { 700, 800, 1100 };
		int[][] timelogs = { { 710, 2359, 1050, 700, 650, 631, 659 }, { 800, 801, 805, 800, 759, 810, 809 },
				{ 1105, 1001, 1002, 600, 1059, 1001, 1100 } };
		int startday = 5;
		System.out.println(solution(schedules, timelogs, startday));
	}

	static public int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer = 0;
		for (int i = 0; i < timelogs.length; i++) {
			boolean flag = true; // 일주일동안 출근 성공했는지
			for (int j = 0; j < timelogs[i].length; j++) {
				int week = ((startday - 1) + j) % 7; // 요일
				if (week == 5 || week == 6) { // 주말이면 패스
					continue;
				} else if (changeTime(schedules[i]) + 10 < changeTime(timelogs[i][j])) { // 평일에 희망 시간 이후에 출근하면 실패
					flag = false;
					break;
				}
			}
			if (flag) { // 성공한 사람
				answer += 1;
			}
		}
		return answer;
	}

	static public int changeTime(int num) { // 시각 계산
		return num / 100 * 60 + num % 100;
	}
}
