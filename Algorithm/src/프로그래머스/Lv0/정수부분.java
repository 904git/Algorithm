package 프로그래머스.Lv0;

public class 정수부분 {
	public static void main(String[] args) {
		double flo = 1.42;
		System.out.println(solution(flo));
	}

	static public int solution(double flo) {
		int answer = (int) flo; // 형 변환
		return answer;
	}
}
