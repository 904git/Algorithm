package 프로그래머스.Lv0;

public class 특정문자열로끝나는가장긴부분문자열찾기 {
	public static void main(String[] args) {
		String myString = "AbCdEFG";
		String pat = "dE";
		System.out.println(solution(myString, pat));
	}

	static public String solution(String myString, String pat) {
		String answer = "";
		int index = myString.lastIndexOf(pat); // 가장 나중에 나오는 pat의 인덱스
		answer = myString.substring(0, index + pat.length());
		return answer;
	}
}
