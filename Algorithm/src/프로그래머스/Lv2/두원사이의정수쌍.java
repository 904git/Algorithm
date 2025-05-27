package 프로그래머스.Lv2;

public class 두원사이의정수쌍 {
	public static void main(String[] args) {
		int r1 = 10, r2 = 20;
		System.out.println(solution(r1, r2));
	}

	static public long solution(int r1, int r2) {
		long answer = 0;
		for (int i = 1; i <= r2; i++) { // 1사분면 좌표
			answer += (long) getDotCnt(r2, i) - Math.ceil(getDotCnt(r1, i)) + 1;
		}
		return answer * 4;
	}

	static public double getDotCnt(int r, int x) { // x좌표가 주어질 때 원점에서 부터 길이가 r 만큼 떨어진 y좌표 값
		if (r < x) {
			return 0;
		}
		return Math.sqrt((long) r * r - (long) x * x);
	}

}
