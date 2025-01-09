package 프로그래머스.Lv0;

public class 문자열이몇번등장하는지세기 {
	public static void main(String[] args) {
		String myString = "banana";
		String pat = "ana";
		System.out.println(solution(myString, pat));
	}

	static public int solution(String myString, String pat) {
		int answer = 0;
		if (pat.length() <= myString.length()) {
			for (int i = 0; i < myString.length() - pat.length() + 1; i++) {
				if (myString.substring(i, i + pat.length()).equals(pat)) {
					answer += 1;
				}
			}
		}
		return answer;
	}
}
