package 프로그래머스.Lv0;

public class 이진수더하기 {
	public static void main(String[] args) {
		String bin1 = "10", bin2 = "11";
		System.out.println(solution(bin1, bin2));
	}

	static public String solution(String bin1, String bin2) {
		String answer = "";
		int num1 = binaryToInteger(bin1), num2 = binaryToInteger(bin2);
		answer = Integer.toBinaryString(num1 + num2); // integer to binary
		return answer;
	}

	static public int binaryToInteger(String bin) { // binary to integer
		int num = Integer.parseInt(bin);
		int result = 0;
		int i = 1;
		while (num > 0) {
			result += (num % 10) * i;
			i *= 2;
			num /= 10;
		}
		return result;
	}
}
