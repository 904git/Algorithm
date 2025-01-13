package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.HashSet;

public class 소인수분해 {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(int n) {
		HashSet<Integer> hash = new HashSet<>(); // 소인수
		for (int i = 2; n > 1;) {
			if (n % i == 0) {
				hash.add(i);
				n /= i;
			} else {
				i++;
			}
		}
		int[] answer = new int[hash.size()];
		int idx = 0;
		for (int i : hash) {
			answer[idx++] = i;
		}
		Arrays.sort(answer); // 오름차순 정렬
		return answer;
	}
}
