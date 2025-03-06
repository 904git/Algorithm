package 프로그래머스.Lv2;

import java.util.Arrays;

public class _2개이하로다른비트 {
	public static void main(String[] args) {
		long[] numbers = { 2, 7 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	static public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) { // 짝수면 맨 끝 비트만 변경하면 되므로 +1
				answer[i] = numbers[i] + 1;
			} else { // 홀수
				String bit = Long.toBinaryString(numbers[i]); // 비트 변환
				int zero_idx = bit.length(); // 0 인덱스
				for (int j = bit.length() - 1; 0 <= j; j--) {
					if (bit.charAt(j) == '0') {
						zero_idx = bit.length() - 1 - j; // 뒤에서부터 0
						break;
					}
				}
				// 인덱스 위치의 0을 1로 변경하고, 바로 뒷 비트를 0으로 변경하면 제일 작은 수
				answer[i] = numbers[i] - (long) Math.pow(2, zero_idx - 1) + (long) Math.pow(2, zero_idx);
			}
		}
		return answer;
	}

	static public long[] solution2(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			StringBuffer sb = new StringBuffer(Long.toBinaryString(numbers[i])); // 비트 변환
			boolean change = false;
			for (int j = sb.length() - 1; 0 <= j; j--) {
				if (sb.charAt(j) == '0') {
					if (j == sb.length() - 1) { // 맨 끝자리가 0이면 1로 변경했을 때가 작은 수
						sb.replace(j, j + 1, "1");
					} else { // 0을 1로 변경하고 바로 뒷 비트를 0으로 바꾼게 제일 작은 수
						sb.replace(j, j + 2, "10");
					}
					change = true;
					break;
				}
			}
			if (!change) { // 모든 비트가 1로 이루어져 있는 경우
				sb.replace(0, 1, "0"); // 첫 비트를 0으로 변경하고
				sb.insert(0, "1"); // 맨 앞에 1 추가
			}
			answer[i] = binaryStringToLong(sb.toString());
		}
		return answer;
	}

	static public long binaryStringToLong(String binary_string) { // 2진수 문자열을 long타입 10진수로 변경
		long result = 0;
		for (int i = binary_string.length() - 1; 0 <= i; i--) {
			if (binary_string.charAt(i) == '1') {
				result += Math.pow(2, binary_string.length() - 1 - i);
			}
		}
		return result;
	}
}
