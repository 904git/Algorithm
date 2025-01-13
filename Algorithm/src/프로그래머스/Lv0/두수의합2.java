package 프로그래머스.Lv0;

public class 두수의합2 {
	public static void main(String[] args) {
		String a = "0";
		String b = "0";
		System.out.println(solution(a, b));
	}

	static public String solution(String a, String b) {
		String answer = "";
		int[] sum = new int[Math.max(a.length(), b.length()) + 1]; // 자릿수의 합
		int add = 0;
		for (int i = 0; i < sum.length; i++) {
			int n1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0; // a 자릿수
			int n2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0; // b 자릿수

			sum[sum.length - 1 - i] = (n1 + n2 + add) % 10; // 1의 자리만
			add = (n1 + n2 + add) / 10; // 10이 넘어가면 다음 자릿수에 더해주기

		}
		StringBuffer sb = new StringBuffer(); // 자릿수 배열 문자열로 변환
		for (int i = sum[0] > 0 ? 0 : 1; i < sum.length; i++) {
			sb.append(sum[i]);
		}
		answer = sb.toString();
		return answer;
	}
}
