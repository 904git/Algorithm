package 프로그래머스.Lv0;

import java.util.HashSet;

public class 중복된문자제거 {
	public static void main(String[] args) {
		String my_string = "people";
		System.out.println(solution(my_string));
	}

	static public String solution(String my_string) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		HashSet<Character> hash = new HashSet<>();
		for (int i = 0; i < my_string.length(); i++) {
			if (!hash.contains(my_string.charAt(i))) { // 아직 한번도 나오지 않은 문자이면
				hash.add(my_string.charAt(i));
				sb.append(my_string.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
