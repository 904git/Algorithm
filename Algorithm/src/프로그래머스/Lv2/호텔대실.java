package 프로그래머스.Lv2;

import java.util.PriorityQueue;

public class 호텔대실 {
	public static void main(String[] args) {
		String[][] book_time = { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" }, { "14:10", "19:20" },
				{ "18:20", "21:20" } };
		System.out.println(solution(book_time));
	}

	static public int solution(String[][] book_time) {
		int answer = 0;
		PriorityQueue<Integer> start_time = new PriorityQueue<>(); // 입실시간 오름차순 정렬
		PriorityQueue<Integer> end_time = new PriorityQueue<>(); // 퇴실시간 오름차순 정렬
		for (int i = 0; i < book_time.length; i++) {
			start_time.add(timeToInt(book_time[i][0]));
			end_time.add(timeToInt(book_time[i][1]) + 10); // 청소시간 포함해서 저장
		}
		int used = 0; // 사용중인 방 수
		while (!start_time.isEmpty()) {
			int time = start_time.poll();
			while (!end_time.isEmpty() && end_time.peek() <= time) { // 입실시간까지 청소 마친 방
				end_time.poll();
				used -= 1;
			}
			if (answer - used <= 0) { // 쓸 수 있는 방이 없으면
				answer += 1; // 방 추가
			}
			used += 1; // 사용중인 방 수 증가
		}
		return answer;
	}

	static public int timeToInt(String time) { // 문자열 시간을 숫자로
		String[] str_split = time.split(":");
		return Integer.parseInt(str_split[0]) * 60 + Integer.parseInt(str_split[1]);
	}
}
