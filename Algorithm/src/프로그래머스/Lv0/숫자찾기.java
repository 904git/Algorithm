package 프로그래머스.Lv0;

public class 숫자찾기 {
	public static void main(String[] args) {
		int num = 29183;
		int k = 1;
		System.out.println(solution(num, k));
	}

	static public int solution(int num, int k) {
		int answer = -1;
		if (Integer.toString(num).indexOf(Integer.toString(k)) >= 0) {
			answer = Integer.toString(num).indexOf(Integer.toString(k)) + 1;
		}
		return answer;
	}
}
