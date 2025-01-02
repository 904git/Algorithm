package 프로그래머스.Lv0;

public class 두수의나눗셈 {
	public static void main(String[] args) {
		int num1 = 3, num2 = 2;
		System.out.println(solution(num1, num2));
	}

	static public int solution(int num1, int num2) {
		int answer = (int) (((float) num1 / num2) * 1000); // 형 변환 후 나누기
		return answer;
	}

}
