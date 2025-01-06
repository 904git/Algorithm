package 프로그래머스.Lv0;

public class 부분문자열인지확인하기 {
	public static void main(String[] args) {
		String my_string = "banana";
		String target = "ana";
		System.out.println(solution(my_string, target));
	}

	static public int solution(String my_string, String target) {
		int answer = my_string.contains(target) ? 1 : 0;
		return answer;
	}
}
