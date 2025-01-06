package 프로그래머스.Lv0;

public class 원하는문자열찾기 {
	public static void main(String[] args) {
		String myString = "AbCdEfG";
		String pat = "aBc";
		System.out.println(solution(myString, pat));
	}

	static public int solution(String myString, String pat) {
		int answer = myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0; // 모두 소문자로 변환 후 존재하는지 확인
		return answer;
	}
}
