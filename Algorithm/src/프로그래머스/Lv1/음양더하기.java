package 프로그래머스.Lv1;

public class 음양더하기 {
	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
		System.out.println(solution(absolutes, signs));
	}

	static public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) { // 부호가 true면 더하기
				answer += absolutes[i];
			} else { // 부호가 false면 빼기
				answer -= absolutes[i];
			}
		}
		return answer;
	}
}
