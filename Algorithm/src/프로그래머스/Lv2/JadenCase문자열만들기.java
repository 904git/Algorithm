package 프로그래머스.Lv2;

public class JadenCase문자열만들기 {
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		String[] str_split = s.split(" ", -1);
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].length() > 0) {
				if (Character.isAlphabetic(str_split[i].charAt(0))) { // 앞글자가 알파벳이면 첫글자 대문자, 뒷글자들 소문자
					str_split[i] = Character.toUpperCase(str_split[i].charAt(0))
							+ str_split[i].substring(1).toLowerCase();
				} else { // 앞글자가 알파벳이 아니면 뒤에 글자 모두 소문자
					str_split[i] = str_split[i].toLowerCase();
				}
			}
		}
		answer = String.join(" ", str_split);
		return answer;
	}
}
