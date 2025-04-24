package 프로그래머스.Lv3;

import java.util.Arrays;

public class 셔틀버스 {
	public static void main(String[] args) {
		int n = 2, t = 10, m = 2;
		String[] timetable = { "09:10", "09:09", "08:00" };
		System.out.println(solution(n, t, m, timetable));
	}

	static public String solution(int n, int t, int m, String[] timetable) {
		String answer = ""; // 콘은 막차를 타야 함
		Arrays.sort(timetable);
		int max_time = 0; // 가장 마지막에 셔틀을 타는 사람의 도착 시간
		int cnt = 0; // 버스에 탄 사람 수
		for (int i = 0, idx = 0; i < n; i++) {
			int bus_time = 9 * 60 + t * i; // 셔틀 시간
			cnt = 0;
			while (idx < timetable.length && cnt < m) { // 만차가 아닐 때까지
				int p_time = timeToInt(timetable[idx]); // 줄 선 시간
				if (bus_time < p_time) { // 줄 선 사람 못 탐
					break;
				}
				// 버스 탑승
				cnt += 1;
				idx += 1;
				max_time = Math.max(max_time, p_time);
			}
		}
		if (cnt < m) { // 막차가 만차가 아닐때
			// 막차 시간 맞춰서 도착해도 됨
			answer = intToTime(9 * 60 + (n - 1) * t);
		} else { // 막차 만차이면
			// 마지막에 타는 사람보다 1분 앞서서 도착해야 함
			answer = intToTime(max_time - 1);
		}
		return answer;
	}

	static public int timeToInt(String time) {
		String[] str_split = time.split(":");
		return Integer.parseInt(str_split[0]) * 60 + Integer.parseInt(str_split[1]);
	}

	static public String intToTime(int time) {
		return String.format("%02d:%02d", time / 60, time % 60);
	}
}
