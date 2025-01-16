package 프로그래머스.Lv1;

public class 이상한문자만들기 {
	public static void main(String[] args) {
		String s = "try hello  world";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		String[] str_split = s.split(" ", -1);
		for (int i = 0; i < str_split.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < str_split[i].length(); j++) {
				if (j % 2 == 0) { // 짝수번째 인덱스는 대문자
					sb.append(Character.toUpperCase(str_split[i].charAt(j)));
				} else { // 홀수번째 인덱스는 소문자
					sb.append(Character.toLowerCase(str_split[i].charAt(j)));
				}
			}
			str_split[i] = sb.toString();
		}
		answer = String.join(" ", str_split);
		return answer;
	}
}
