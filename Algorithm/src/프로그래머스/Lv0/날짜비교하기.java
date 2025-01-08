package 프로그래머스.Lv0;

public class 날짜비교하기 {
	public static void main(String[] args) {
		int[] date1 = { 2021, 12, 28 }, date2 = { 2021, 12, 29 };
		System.out.println(solution(date1, date2));
	}

	static public int solution(int[] date1, int[] date2) {
		int answer = 0;
		// date1이 더 앞선 경우 1
		if (date1[0] * 1000 + date1[1] * 100 + date1[2] < date2[0] * 1000 + date2[1] * 100 + date2[2]) {
			answer = 1;
		}
		return answer;
	}
}
