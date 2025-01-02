package 프로그래머스.Lv0;

public class 피자나눠먹기1 {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = n % 7 > 0 ? n / 7 + 1 : n / 7; // 7로 나눈 나머지가 존재하면 피자 한판 추가
		return answer;
	}

}
