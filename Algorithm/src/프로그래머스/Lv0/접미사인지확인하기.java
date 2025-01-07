package 프로그래머스.Lv0;

public class 접미사인지확인하기 {
	public static void main(String[] args) {
		String my_string = "banana";
		String is_suffix = "ana";
		System.out.println(solution(my_string, is_suffix));
	}

	static public int solution(String my_string, String is_suffix) {
		int answer = my_string.endsWith(is_suffix) ? 1 : 0;
		return answer;
	}
}
