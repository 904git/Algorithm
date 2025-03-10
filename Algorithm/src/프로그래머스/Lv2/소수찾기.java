package 프로그래머스.Lv2;

import java.util.HashSet;

public class 소수찾기 {
	static boolean[] selected;
	static int count;
	static HashSet<Integer> hash;

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}

	static public int solution(String numbers) {
		int answer = 0;
		count = 0;
		selected = new boolean[numbers.length()]; // 선택된 수인지 확인용
		hash = new HashSet<>(); // 이미 만들었던 적이 있는 수인지 확인용
		for (int i = 1; i <= numbers.length(); i++) { // 만들 수 있는 숫자의 길이
			perm(i, 0, numbers, 0);
		}
		answer = count;
		return answer;
	}

	static public void perm(int n, int cnt, String numbers, int num) { // 순열
		if (n == cnt) { // 숫자 완성
			if (isPrime(num) && !hash.contains(num)) { // 소수이면서 아직 만든적 없는 수
				hash.add(num);
				count += 1;
			}
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!selected[i]) {
				selected[i] = true;
				perm(n, cnt + 1, numbers, num * 10 + (numbers.charAt(i) - '0')); // 숫자 만들기
				selected[i] = false;
			}
		}
	}

	static public boolean isPrime(int n) { // 소수인지 확인하는 함수
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
