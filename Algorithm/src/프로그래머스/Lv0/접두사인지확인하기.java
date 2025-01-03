package 프로그래머스.Lv0;

public class 접두사인지확인하기 {
	public static void main(String[] args) {
		String my_string = "banana";
		String is_prefix = "ban";
		System.out.println(solution(my_string, is_prefix));
	}

	static public int solution(String my_string, String is_prefix) {
		int answer = 0;
		if (my_string.startsWith(is_prefix)) { // is_prefix로 시작하는 문자열인지 확인
			answer = 1;
		}
		return answer;
	}
}
