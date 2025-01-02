package 프로그래머스.Lv0;

public class 점의위치구하기 {
	public static void main(String[] args) {
		int[] dot = { 2, 4 };
		System.out.println(solution(dot));
	}

	static public int solution(int[] dot) {
		int answer = 0;
		if (dot[0] > 0) { // x가 양수
			if (dot[1] > 0) { // y가 양수, 1사분면
				answer = 1;
			} else { // y가 음수, 4사분면
				answer = 4;
			}
		} else { // x가 음수
			if (dot[1] > 0) { // y가 양수, 2사분면
				answer = 2;
			} else { // y가 음수, 3사분면
				answer = 3;
			}
		}
		return answer;
	}

}
