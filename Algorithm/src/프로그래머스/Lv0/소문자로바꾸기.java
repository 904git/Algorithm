package 프로그래머스.Lv0;

public class 소문자로바꾸기 {
	public static void main(String[] args) {
		String myString = "aBcDeFg";
		System.out.println(solution(myString));
	}

	static public String solution(String myString) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < myString.length(); i++) {
			sb.append(Character.toLowerCase(myString.charAt(i)));
		}
		answer = sb.toString();
		return answer;
	}

}
