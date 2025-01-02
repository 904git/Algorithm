package 프로그래머스.Lv0;

public class 각도기 {
	public static void main(String[] args) {
		int angle = 70;
		System.out.println(solution(angle));
	}

	static public int solution(int angle) {
		int answer = 0;
		if (angle < 90) { // 예각일 때
			answer = 1;
		} else if (angle == 90) { // 직각일 때
			answer = 2;
		} else if (angle == 180) { // 평각일 때
			answer = 4;
		} else { // 둔각일 때
			answer = 3;
		}
		return answer;
	}

}
