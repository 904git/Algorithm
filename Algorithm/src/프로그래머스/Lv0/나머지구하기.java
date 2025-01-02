package 프로그래머스.Lv0;

public class 나머지구하기 {
	public static void main(String[] args) {
		int num1 = 3, num2 = 2;
		System.out.println(solution(num1, num2));
	}

	static public int solution(int num1, int num2) {
		int answer = num1 % num2; // 나머지 연산자 %
		return answer;
	}
}
