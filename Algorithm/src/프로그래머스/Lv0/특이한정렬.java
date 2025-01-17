package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 특이한정렬 {
	public static void main(String[] args) {
		int[] numlist = { 1, 2, 3, 4, 5, 6 };
		int n = 4;
		System.out.println(Arrays.toString(solution(numlist, n)));
	}

	static public int[] solution(int[] numlist, int n) {
		int[] answer = new int[numlist.length];
		Integer[] sortlist = new Integer[numlist.length];
		for (int i = 0; i < numlist.length; i++) {
			sortlist[i] = numlist[i];
		}
		Arrays.sort(sortlist, new MySort(n)); // 기준에 맞춰 정렬
		for (int i = 0; i < numlist.length; i++) {
			answer[i] = sortlist[i];
		}
		return answer;
	}

	static class MySort implements Comparator<Integer> { // 사용자 정렬
		int n;

		public MySort(int n) {
			this.n = n;
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			if (Math.abs(o1 - this.n) == Math.abs(o2 - this.n)) {
				return o2 - o1; // 거리가 같으면 크기가 더 큰 수를 먼저
			}
			return Math.abs(o1 - this.n) - Math.abs(o2 - this.n); // n과 더 가까운 순으로 정렬
		}

	}
}
