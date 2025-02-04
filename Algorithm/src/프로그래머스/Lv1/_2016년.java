package 프로그래머스.Lv1;

public class _2016년 {
	public static void main(String[] args) {
		int a = 5, b = 24;
		System.out.println(solution(a, b));
	}

	static public String solution(int a, int b) {
		String answer = "";
		String[] weekend = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" }; // 1월 1일이 금요일부터 시작
		int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 달 별 일자
		int day = 0;
		for (int i = 0; i < a - 1; i++) { // 직전 달까지 일자 수 더해주기
			day += month[i];
		}
		day += b - 1; // 해당 날짜까지 일 수 더하기
		answer = weekend[day % 7]; // 요일 구하기
		return answer;
	}
}
