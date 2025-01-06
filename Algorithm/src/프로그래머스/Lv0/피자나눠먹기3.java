package 프로그래머스.Lv0;

public class 피자나눠먹기3 {
	public static void main(String[] args) {
		int slice = 7, n = 10;
		System.out.println(solution(slice, n));
	}

	static public int solution(int slice, int n) {
		// n이 slice로 나누어 떨어지지 않으면 한판 추가
		int answer = n % slice == 0 ? n / slice : n / slice + 1;
		return answer;
	}
}
