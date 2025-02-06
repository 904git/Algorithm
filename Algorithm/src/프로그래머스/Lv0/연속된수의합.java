package 프로그래머스.Lv0;

import java.util.Arrays;

public class 연속된수의합 {
	public static void main(String[] args) {
		int num = 3, total = 12;
		System.out.println(Arrays.toString(solution(num, total)));
	}

	static public int[] solution(int num, int total) {
		int[] answer = new int[num];
		int sum = 0, left = 0, right = num - 1; // left부터 right까지의 합 = sum
		for (int i = 0; i < num; i++) {
			sum += i;
		}
		while (sum != total) {
			if (sum < total) { // sum이 total보다 작으면 오른쪽으로 이동
				sum -= left;
				left += 1;
				right += 1;
				sum += right;
			} else { // sum이 total보다 크면 왼쪽으로 이동
				sum -= right;
				left -= 1;
				right -= 1;
				sum += left;
			}
		}
		for (int i = left, idx = 0; i <= right; i++) {
			answer[idx++] = i;
		}
		return answer;
	}
}
