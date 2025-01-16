package 프로그래머스.Lv1;

public class 최소직사각형 {
	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		System.out.println(solution(sizes));
	}

	static public int solution(int[][] sizes) {
		int answer = 0;
		int[] wallet = { 0, 0 };
		for (int i = 0; i < sizes.length; i++) {
			if (Math.max(wallet[0], sizes[i][1]) * Math.max(wallet[1], sizes[i][0]) < // 회전 했을 때
					Math.max(wallet[0], sizes[i][0]) * Math.max(wallet[1], sizes[i][1])) { // 회전 안 한 것 보다 부피가 더 작으면
				wallet[0] = Math.max(wallet[0], sizes[i][1]);
				wallet[1] = Math.max(wallet[1], sizes[i][0]);
			} else {
				wallet[0] = Math.max(wallet[0], sizes[i][0]);
				wallet[1] = Math.max(wallet[1], sizes[i][1]);
			}
		}
		answer = wallet[0] * wallet[1];
		return answer;
	}
}
