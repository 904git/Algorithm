package 프로그래머스.Lv2;

import java.util.HashMap;

public class n의최소공배수 {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };
		System.out.println(solution(arr));
	}

	static public int solution(int[] arr) {
		int answer = 1;
		for (int i = 0; i < arr.length; i++) {
			answer = (answer * arr[i]) / gcd(answer, arr[i]); // 두 수의 최소공배수
		}
		return answer;
	}

	static public int gcd(int a, int b) { // 두 수의 최대공약수
		int result = 1;
		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		return result;
	}

	static public int solution2(int[] arr) {
		int answer = 1;
		HashMap<Integer, Integer> lcm = new HashMap<>(); // 최소공배수
		for (int i = 0; i < arr.length; i++) {
			HashMap<Integer, Integer> elements = new HashMap<>(); // 소인수분해
			int num = arr[i];
			for (int j = 2; j <= num;) { // arr[i] 소인수 분해
				if (num % j == 0) {
					if (elements.containsKey(j)) {
						elements.replace(j, elements.get(j) + 1);
					} else {
						elements.put(j, 1);
					}
					num /= j;
				} else {
					j += 1;
				}
			}
			for (Integer key : elements.keySet()) {
				if (!lcm.containsKey(key)) {
					lcm.put(key, elements.get(key));
				} else {
					lcm.replace(key, Math.max(elements.get(key), lcm.get(key)));
				}
			}
		}
		for (Integer key : lcm.keySet()) { // 최소공배수 계산
			answer *= Math.pow(key, lcm.get(key));
		}
		return answer;
	}
}
