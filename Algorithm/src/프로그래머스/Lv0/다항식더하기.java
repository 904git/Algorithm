package 프로그래머스.Lv0;

public class 다항식더하기 {
	public static void main(String[] args) {
		String polynomial = "3x + 7 + x";
		System.out.println(solution(polynomial));
	}

	static public String solution(String polynomial) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int[] num = { 0, 0 };
		String[] str_split = polynomial.split(" ");
		for (int i = 0; i < str_split.length; i += 2) {
			if (str_split[i].endsWith("x")) { // x 계수
				if (str_split[i].length() == 1) { // 1 생략
					num[0] += 1;
				} else {
					num[0] += Integer.parseInt(str_split[i].substring(0, str_split[i].length() - 1));
				}
			} else { // 상수
				num[1] += Integer.parseInt(str_split[i]);
			}
		}
		if (num[0] > 1) { // x의 계수
			sb.append(num[0]);
		}
		if (num[0] >= 1) {
			sb.append("x");
		}
		if (num[1] > 0) { // 상수
			if (sb.length() > 0) { // 앞에 x 항이 존재하면
				sb.append(" + ");
			}
			sb.append(num[1]);
		}
		answer = sb.toString();
		return answer;
	}
}
