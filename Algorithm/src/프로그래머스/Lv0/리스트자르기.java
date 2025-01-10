package 프로그래머스.Lv0;

import java.util.Arrays;

public class 리스트자르기 {
	public static void main(String[] args) {
		int n = 4;
		int[] slicer = { 1, 5, 2 }; // a, b, c
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(solution(n, slicer, num_list)));
	}

	static public int[] solution(int n, int[] slicer, int[] num_list) {
		int[] answer = {};
		switch (n) {
		case 1: // 0 부터 b까지
			answer = new int[slicer[1] + 1];
			for (int i = 0; i <= slicer[1]; i++) {
				answer[i] = num_list[i];
			}
			break;
		case 2: // a부터 끝까지
			answer = new int[num_list.length - slicer[0]];
			for (int i = slicer[0], idx = 0; i < num_list.length; i++) {
				answer[idx++] = num_list[i];
			}
			break;
		case 3: // a부터 b까지
			answer = new int[slicer[1] - slicer[0] + 1];
			for (int i = slicer[0], idx = 0; i <= slicer[1]; i++) {
				answer[idx++] = num_list[i];
			}
			break;
		case 4: // a부터 b까지 c 간격으로
			int size = (slicer[1] - slicer[0] + 1) % slicer[2] == 0 ? (slicer[1] - slicer[0] + 1) / slicer[2]
					: (slicer[1] - slicer[0] + 1) / slicer[2] + 1;
			answer = new int[size];
			for (int i = slicer[0], idx = 0; i <= slicer[1]; i += slicer[2]) {
				answer[idx++] = num_list[i];
			}
			break;
		default:
			break;
		}
		return answer;
	}
}
