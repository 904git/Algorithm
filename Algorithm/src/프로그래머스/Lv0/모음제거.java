package 프로그래머스.Lv0;

import java.util.HashSet;

public class 모음제거 {
	public static void main(String[] args) {
		String my_string = "bus";
		System.out.println(solution(my_string));
	}

	static public String solution(String my_string) {
		String answer = "";
		HashSet<Character> vowels = new HashSet<Character>() { // 모음 set
			{
				add('a');
				add('e');
				add('i');
				add('o');
				add('u');
			}
		};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			if (!vowels.contains(my_string.charAt(i))) { // 모음이 아니면 stringbuffer에 삽입
				sb.append(my_string.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}
}
