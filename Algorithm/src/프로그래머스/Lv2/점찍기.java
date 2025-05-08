package 프로그래머스.Lv2;

public class 점찍기 {
	public static void main(String[] args) {
		int k = 2, d = 4;
		System.out.println(solution(k, d));
	}

	static public long solution(int k, int d) {
		long answer = 0;
		for (int i = 0; i <= d; i += k) { // 반지름 안에 드는 점 개수
			answer += (int) Math.sqrt((long) d * d - (long) i * i) / k + 1;
		}
		return answer;
	}
}
