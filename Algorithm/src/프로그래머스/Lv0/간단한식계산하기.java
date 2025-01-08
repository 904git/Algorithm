package 프로그래머스.Lv0;

public class 간단한식계산하기 {
	public static void main(String[] args) {
		String binomial = "43 + 12";
		System.out.println(solution(binomial));
	}

	static public int solution(String binomial) {
		int answer = 0;
		String[] str_split = binomial.split(" ");
		switch (str_split[1].charAt(0)) {
		case '+':
			answer = Integer.parseInt(str_split[0]) + Integer.parseInt(str_split[2]);
			break;
		case '-':
			answer = Integer.parseInt(str_split[0]) - Integer.parseInt(str_split[2]);
			break;
		case '*':
			answer = Integer.parseInt(str_split[0]) * Integer.parseInt(str_split[2]);
			break;
		default:
			break;
		}
		return answer;
	}

}
