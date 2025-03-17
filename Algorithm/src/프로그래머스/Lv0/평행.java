package 프로그래머스.Lv0;

public class 평행 {
	public static void main(String[] args) {
		int[][] dots = { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } };
		System.out.println(solution(dots));
	}

	static public int solution(int[][] dots) {
		int answer = 1;
		if (getGradient(dots[0], dots[1]) != getGradient(dots[2], dots[3])
				&& getGradient(dots[0], dots[2]) != getGradient(dots[1], dots[3])
				&& getGradient(dots[0], dots[3]) != getGradient(dots[1], dots[2])) { // 모든 경우에 두 선분이 평행한 경우가 없으면
			answer = 0;
		}
		return answer;
	}

	static public double getGradient(int[] dot1, int[] dot2) { // 두 점을 이은 선분의 기울기 구하기
		return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
	}
}
