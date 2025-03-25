package 프로그래머스.Lv1;

public class 신규아이디추천 {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));
	}

	static public String solution(String new_id) {
		String answer = new_id;
		answer = answer.toLowerCase(); // 1단계
		answer = answer.replaceAll("[^a-zA-Z0-9-_.]", ""); // 2단계
		answer = answer.replaceAll("[.]+", "."); // 3단계
		if (answer.startsWith(".")) { // 4단계
			answer = answer.substring(1);
		}
		if (answer.length() < 1) { // 5단계
			answer = "a";
		} else if (15 < answer.length()) { // 6단계
			answer = answer.substring(0, 15);
		}
		if (answer.endsWith(".")) { // 6단계
			answer = answer.substring(0, answer.length() - 1);
		}
		for (int i = answer.length(); i < 3; i++) { // 7단계
			answer += answer.charAt(answer.length() - 1);
		}
		return answer;
	}
}
