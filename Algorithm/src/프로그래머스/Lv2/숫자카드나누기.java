package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자카드나누기 {
	public static void main(String[] args) {
		int[] arrayA = { 10, 17 };
		int[] arrayB = { 5, 20 };
		System.out.println(solution(arrayA, arrayB));
	}

	static public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		int max = Math.max(arrayA[0], arrayB[0]);
		for (int i = max; 2 <= i; i--) {
			// A배열을 다 나누고 B배열을 다 나누지 않거나, B배열을 다 나누고 A배열을 다 나누지 않거나
			if ((dividing(arrayA, i) && notDividing(arrayB, i)) || dividing(arrayB, i) && notDividing(arrayA, i)) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	static public boolean dividing(int[] array, int num) { // num이 배열의 모든 수를 나누면 true, 아니면 false
		for (int i = 0; i < array.length; i++) {
			if (array[i] % num != 0) {
				return false;
			}
		}
		return true;
	}

	static public boolean notDividing(int[] array, int num) { // num이 배열의 모든 수를 못 나누면 true, 아니면 false
		for (int i = 0; i < array.length; i++) {
			if (array[i] % num == 0) {
				return false;
			}
		}
		return true;
	}

	static public int solution2_1(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		List<Integer> divisorA = getDivisor(arrayA[0]);
		List<Integer> divisorB = getDivisor(arrayB[0]);
		for (int i = 0; i < divisorA.size(); i++) {
			int num = divisorA.get(i);
			boolean check = true;
			for (int j = 0; j < arrayB.length; j++) {
				if (arrayA[j] % num != 0 || arrayB[j] % num == 0) { // A배열을 나누지 못하고, B배열이 나눠지는 수
					check = false;
					break;
				}
			}
			if (check) { // A배열을 모두 나누는 수이면서, B배열을 모두 나누지 않는 수
				answer = Math.max(answer, num);
			}
		}
		for (int i = 0; i < divisorB.size(); i++) {
			int num = divisorB.get(i);
			boolean check = true;
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayB[j] % num != 0 || arrayA[j] % num == 0) { // B배열을 나누지 못하고, A배열이 나눠지는 수
					check = false;
					break;
				}
			}
			if (check) { // B배열을 모두 나누는 수이면서, A배열을 모두 나누지 않는 수
				answer = Math.max(answer, num);
			}
		}
		return answer;
	}
	
	static public int solution2_2(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		List<Integer> divisorA = getDivisor(arrayA[0]);
		List<Integer> divisorB = getDivisor(arrayB[0]);
		for (int i = 0; i < divisorA.size(); i++) {
			int num = divisorA.get(i);
			if (dividing(arrayA, num) && notDividing(arrayB, num)) { // A배열을 모두 나누는 수이면서, B배열을 모두 나누지 않는 수
				answer = Math.max(answer, num);
			}
		}
		for (int i = 0; i < divisorB.size(); i++) {
			int num = divisorB.get(i);
			if (dividing(arrayB, num) && notDividing(arrayA, num)) { // B배열을 모두 나누는 수이면서, A배열을 모두 나누지 않는 수
				answer = Math.max(answer, num);
			}
		}
		return answer;
	}

	static public List<Integer> getDivisor(int n) { // 약수 구하기
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				result.add(i);
				if (i != n / i) {
					result.add(n / i);
				}
			}
		}
		return result;
	}

	static public int solution3_1(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int[] gcd = { arrayA[0], arrayB[0] };
		for (int i = 0; i < arrayA.length; i++) {
			gcd[0] = gcd(gcd[0], arrayA[i]); // arrayA에 있는 수들의 최대 공약수
			gcd[1] = gcd(gcd[1], arrayB[i]); // arrayB에 있는 수들의 최대 공약수
		}
		boolean[] check = { true, true }; // 조건에 맞는 수인지 확인
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] % gcd[1] == 0) { // B배열 최대공약수로 A배열 나눠지는 게 있으면 실패
				check[1] = false;
				break;
			}
		}
		for (int i = 0; i < arrayB.length; i++) {
			if (arrayB[i] % gcd[0] == 0) { // A배열 최대공약수로 B배열 나눠지는 게 있으면 실패
				check[0] = false;
				break;
			}
		}
		for (int i = 0; i < check.length; i++) {
			if (check[i]) { // 성공한 수 중 큰 수
				answer = Math.max(answer, gcd[i]);
			}
		}
		return answer;
	}

	static public int solution3_2(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int[] gcd = { arrayA[0], arrayB[0] };
		for (int i = 0; i < arrayA.length; i++) {
			gcd[0] = gcd(gcd[0], arrayA[i]); // arrayA에 있는 수들의 최대 공약수
			gcd[1] = gcd(gcd[1], arrayB[i]); // arrayB에 있는 수들의 최대 공약수
		}
		// 조건 확인
		boolean[] check = { gcd[0] != 1 && notDividing(arrayB, gcd[0]), gcd[1] != 1 && notDividing(arrayA, gcd[1]) };
		for (int i = 0; i < check.length; i++) {
			if (check[i]) { // 성공한 수 중 큰 수
				answer = Math.max(answer, gcd[i]);
			}
		}
		return answer;
	}

	static int gcd(int a, int b) { // 두 수의 최대공약수
		for (int i = Math.min(a, b); 1 < i; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}
}
