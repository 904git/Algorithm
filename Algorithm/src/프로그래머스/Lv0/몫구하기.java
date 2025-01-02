package 프로그래머스.Lv0;

public class 몫구하기 {
	public static void main(String[] args) {
		int num1 = 10, num2 = 5;
		System.out.println(solution(num1, num2));
	}

	static public int solution(int num1, int num2) {
		int answer = num1 / num2; // 나누기 연산자 /
		return answer;
	}

}
