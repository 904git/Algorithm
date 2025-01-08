package 프로그래머스.Lv1;

public class 서울에서김서방찾기 {
	public static void main(String[] args) {
		String[] seoul = { "Jane", "Kim" };
		System.out.println(solution(seoul));
	}

	static public String solution(String[] seoul) {
		String answer = "";
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				answer = "김서방은 " + i + "에 있다";
			}
		}
		return answer;
	}
}
