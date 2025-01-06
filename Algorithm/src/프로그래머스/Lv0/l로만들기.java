package 프로그래머스.Lv0;

public class l로만들기 {
	public static void main(String[] args) {
		String myString = "abcdevwxyz";
		System.out.println(solution(myString));
	}

	static public String solution(String myString) {
		String answer = "";
		String[] str_split = myString.split("");
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].charAt(0) < 'l') { // l보다 앞서는 문자이면
				str_split[i] = "l"; // l로 변경
			}
		}
		answer = String.join("", str_split);
		return answer;
	}
}
