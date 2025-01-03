package 프로그래머스.Lv0;

import java.util.Arrays;

public class 할일목록 {
	public static void main(String[] args) {
		String[] todo_list = { "problemsolving", "practiceguitar", "swim", "studygraph" };
		boolean[] finished = { true, false, true, false };
		System.out.println(Arrays.toString(solution(todo_list, finished)));
	}

	static public String[] solution(String[] todo_list, boolean[] finished) {
		int size = 0;
		for (int i = 0; i < finished.length; i++) { // 마치지 못한 일 개수 카운트
			if (!finished[i]) {
				size += 1;
			}
		}
		String[] answer = new String[size]; // 위에 카운트한 만큼 배열 생성
		for (int i = 0, idx = 0; i < todo_list.length; i++) {
			if (!finished[i]) {// 마치지 못한 일만 삽입
				answer[idx++] = todo_list[i];
			}
		}
		return answer;
	}

}
