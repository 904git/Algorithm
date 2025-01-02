package 프로그래머스.Lv0;

public class 숫자비교하기 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		System.out.println(solution(num1, num2));
	}

	static public int solution(int num1, int num2) {
		int answer = 0;
		if (num1 == num2) { // 서로 같은 수 이면 1
			answer = 1;
		} else { // 아니면 -1
			answer = -1;
		}
		return answer;
	}
}
