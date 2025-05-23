package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class 과제진행하기 {
	public static void main(String[] args) {
		String[][] plans = { { "korean", "11:40", "30" }, { "english", "12:10", "20" }, { "math", "12:30", "40" } };
		System.out.println(Arrays.toString(solution(plans)));
	}

	static public String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];
		Arrays.sort(plans, new MySort()); // 시간순으로 정렬
		Stack<String[]> stack = new Stack<>(); // 멈춰진 과제
		int cnt = 0; // 완료한 과제 인덱스
		int time = getTimeint(plans[0][1]); // 현재 시간
		String[] p = plans[0]; // 현재 진행중인 과제
		for (int i = 1; i < plans.length;) {
			int play_time = Integer.parseInt(p[2]); // 과제 완료하는데 걸리는 시간
			int next_time = getTimeint(plans[i][1]); // 다음 과제가 들어오는 시간
			if (time + play_time <= next_time) { // 현재 진행중인 과제를 다음 과제 들어오기 전에 끝마칠 수 있음
				answer[cnt++] = p[0]; // 과제 완료
				if (time + play_time < next_time && !stack.isEmpty()) { // 다음 과제가 들어오기 전까지 시간이 남으면 멈춰진 과제를 수행
					p = stack.pop();
					time += play_time;
				} else { // 바로 다음 과제를 수행해야 하는 경우
					time = getTimeint(plans[i][1]);
					p = plans[i++];
				}
			} else { // 진행중인 과제를 멈추고 다음에 들어올 과제를 수행
				stack.add(new String[] { p[0], p[1], Integer.toString(play_time - (next_time - time)) });
				time = getTimeint(plans[i][1]);
				p = plans[i++];
			}
		}
		answer[cnt++] = p[0];
		// 나머지 멈춰진 과제 수행
		while (!stack.isEmpty()) {
			answer[cnt++] = stack.pop()[0];
		}
		return answer;
	}

	static public int getTimeint(String time) { // 시간 문자열을 숫자로
		String[] str_split = time.split(":");
		return Integer.parseInt(str_split[0]) * 60 + Integer.parseInt(str_split[1]);
	}

	static class MySort implements Comparator<String[]> { // 시간 오름차순으로 정렬

		@Override
		public int compare(String[] o1, String[] o2) {
			// TODO Auto-generated method stub
			return getTimeint(o1[1]) - getTimeint(o2[1]);
		}

	}
}
