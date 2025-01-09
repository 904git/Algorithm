package 프로그래머스.Lv0;

import java.util.HashMap;

public class 모스부호1 {
	public static void main(String[] args) {
		String letter = ".... . .-.. .-.. ---";
		System.out.println(solution(letter));
	}

	static public String solution(String letter) {
		String answer = "";
		HashMap<String, String> morse = new HashMap<String, String>() { // 모스부호
			{
				put(".-", "a");
				put("-...", "b");
				put("-.-.", "c");
				put("-..", "d");
				put(".", "e");
				put("..-.", "f");
				put("--.", "g");
				put("....", "h");
				put("..", "i");
				put(".---", "j");
				put("-.-", "k");
				put(".-..", "l");
				put("--", "m");
				put("-.", "n");
				put("---", "o");
				put(".--.", "p");
				put("--.-", "q");
				put(".-.", "r");
				put("...", "s");
				put("-", "t");
				put("..-", "u");
				put("...-", "v");
				put(".--", "w");
				put("-..-", "x");
				put("-.--", "y");
				put("--..", "z");
			}
		};
		String[] str_split = letter.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str_split.length; i++) {
			sb.append(morse.get(str_split[i]));
		}
		answer = sb.toString();
		return answer;
	}
}
