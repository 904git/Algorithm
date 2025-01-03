package 프로그래머스.Lv0;

public class A강조하기 {
	public static void main(String[] args) {
		String myString = "abstract algebra";
		System.out.println(solution(myString));
	}

	static public String solution(String myString) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) == 'a' || myString.charAt(i) == 'A') { // a이면 대문자로
				sb.append(Character.toUpperCase(myString.charAt(i)));
			} else { // 다른 문자는 소문자로
				sb.append(Character.toLowerCase(myString.charAt(i)));
			}
		}
		answer = sb.toString();
		return answer;
	}

}
