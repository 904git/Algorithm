package 프로그래머스.Lv0;

import java.util.Arrays;

public class 가장큰수찾기 {
	public static void main(String[] args) {
		int[] array = { 1, 8, 3 };
		System.out.println(Arrays.toString(solution(array)));
	}

	static public int[] solution(int[] array) {
		int[] answer = { 0, 0 };
		for (int i = 0; i < array.length; i++) {
			if (answer[0] < array[i]) { // 값 비교
				// 최댓값 갱신
				answer[0] = array[i];
				answer[1] = i;
			}
		}
		return answer;
	}

}
