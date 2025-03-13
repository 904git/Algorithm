package 프로그래머스.Lv2;

public class 큰수만들기 {
	public static void main(String[] args) {
		String number = "994443";
		int k = 2;
		System.out.println(solution(number, k));
	}

	static public String solution(String number, int k) {
		String answer = number;
		int idx = 0;
		while (0 < k) {
			StringBuffer num1 = new StringBuffer(answer);
			StringBuffer num2 = new StringBuffer(answer);
			String str1 = num1.deleteCharAt(idx).toString();
			String str2 = num2.deleteCharAt(idx + 1).toString();
			System.out.println(str1+" "+str2);
			if (0 < str1.compareTo(str2)) {
				answer = str1;
				k -= 1;
			} else if (str1.compareTo(str2) < 0) {
				answer = str2;
				k -= 1;
			} else {
				idx += 1;
			}
		}
		return answer;
	}
}
