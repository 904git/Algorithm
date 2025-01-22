package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최빈값구하기 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 3, 4 };
		System.out.println(solution(array));
	}

	static public int solution(int[] array) {
		int answer = 0;
		Arrays.sort(array); // 정렬
		PriorityQueue<int[]> queue = new PriorityQueue<>(new MySort()); // 최빈값 구하기
		int num = array[0], idx = 0;
		for (int i = 0; i < array.length; i++) {
			if (num != array[i]) {
				queue.add(new int[] { num, i - idx }); // num, num의 빈도
				idx = i;
				num = array[i];
			}
		}
		queue.add(new int[] { num, array.length - idx });

		int[] max = queue.poll(); // 최빈값
		answer = max[0];
		if (!queue.isEmpty() && max[1] == queue.peek()[1]) { // 만약 최빈값이 여러개이면 -1
			answer = -1;
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 빈도 내림차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[1] - o1[1];
		}

	}
}
