package 프로그래머스.Lv0;

import java.util.Arrays;

public class n개간격의원소들 {
	public static void main(String[] args) {
		int[] num_list = { 4, 2, 6, 1, 7, 6 };
		int n = 2;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	static public int[] solution(int[] num_list, int n) {
		int[] answer = new int[num_list.length % n == 0 ? num_list.length / n : num_list.length / n + 1];
		// n으로 나눈 나머지가 있으면 + 1
		for (int i = 0, idx = 0; i < num_list.length; i += n) { // i를 n만큼 증가시키면서 삽입
			answer[idx++] = num_list[i];
		}
		return answer;
	}

}
