package 프로그래머스.Lv0;

public class 두수의차 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		System.out.println(solution(num1, num2));
	}

	static public int solution(int num1, int num2) {
		int answer = num1 - num2; // 빼기 연산자 -
		return answer;
	}
}
