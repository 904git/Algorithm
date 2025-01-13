package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.HashSet;

public class 무작위로k개의수뽑기 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 2, 2, 3 };
		int k = 3;
		System.out.println(Arrays.toString(solution(arr, k)));
	}

	static public int[] solution(int[] arr, int k) {
		HashSet<Integer> hash = new HashSet<>();
		int[] answer = new int[k];
		Arrays.fill(answer, -1); // 배열 -1로 채우기
		for (int i = 0, idx = 0; i < arr.length && idx < k; i++) {
			if (!hash.contains(arr[i])) { // 여태 나온적 없는 수이면 저장
				answer[idx++] = arr[i];
				hash.add(arr[i]);
			}
		}
		return answer;
	}
}
