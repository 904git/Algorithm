package 프로그래머스.Lv0;

public class 편지 {
	public static void main(String[] args) {
		String message = "haapy birthday!";
		System.out.println(solution(message));
	}

	static public int solution(String message) {
		int answer = message.length() * 2; // 메세지 길이 * 2
		return answer;
	}

}
